package ejercicioStreams.org.streams;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import daw.com.Pantalla;
import daw.com.Teclado;

public class App {

	/*
	1) Iniciales de los alumnos repetidores que han aprobado
	2) Cursos donde hay alumnos menores de edad
	3) Alumnos por curso
	4) n.º de alumnos por curso
	5)¿Hay algún alumno en el curso "DAM2"?
	6)Alumno repetidor con peor nota del curso introducido por el teclado, mostrar antes la lista de cursos.
	7)Nota media de los alumnos del curso con más alumnos.
	 */


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Consumer<Object> ESCRIBIDOR = System.out::println;
		List <Alumno> alumnos;
		Set<String> cursos;
		String curso;


		// Cargar alumnos
		alumnos = cargarAlumnos ();

		System.out.println("listado de alumnos cargados");
		alumnos.forEach(ESCRIBIDOR);


		//Mostrar iniciales de los alumnos repetidores que han aprobado

		System.out.println("\nIniciales alumnos:\n");

		alumnos.stream()
		.filter(Alumno::isRepetidor) //Quitar no repetidores   
		.filter(Alumno::estaAprobado) //Quitar no aprobados 
		.map(a -> Arrays.stream(a.getNombre().split(" ")) //Obtener Array con todos los elementos del nombre
				.map(p -> p.substring(0, 1).toUpperCase()) //Obtener iniciales y pasarlas a mayuscula
				.reduce("", (s1, s2) -> s1 + s2)) //Concatena las iniciales
		.forEach(ESCRIBIDOR); //Escribe


		//Mostrar cursos donde hay alumnos menores de edad

		System.out.println("\nCursos con alumnos mayores de edad:\n");//La regla de negocio no permite menores

		alumnos.stream()
		.filter(Alumno::esMayorEdad) //Filtramos mayores de edad
		.map(Alumno::getCurso) //Recogemos cursos
		.distinct() //Quitamos repes
		.collect(Collectors.toList()) //Pasamos a lista
		.forEach(ESCRIBIDOR); //Escribe


		//Alumnos por curso  
		
		System.out.println("\nAlumnos por curso: \n");
		
		alumnos.stream()
		.collect(Collectors.groupingBy(Alumno::getCurso))
		.entrySet()
		.forEach(ESCRIBIDOR);

		//N.º de alumnos por curso 
		
		System.out.println("\nNº de alumnos por curso: \n");
		
		alumnos.stream()
		.collect(Collectors.groupingBy(Alumno::getCurso, Collectors.counting()))
		.entrySet()
		.forEach(ESCRIBIDOR);

		//¿Hay algún alumno en el curso "DAM2"?

		System.out.println(alumnos.stream()
				.anyMatch(a -> a.getCurso()
						.equalsIgnoreCase("DAM2")) 
				? "\nHay alumnos en DAM2." 
						: "\nNo hay alumnos en DAM2.");

		//Alumno repetidor con peor nota del curso introducido por el teclado, mostrar antes la lista de cursos.

		cursos=alumnos.stream()
				.map(Alumno::getCurso)
				.distinct()
				.collect(Collectors.toSet());

		do {
			cursos.forEach(ESCRIBIDOR);

			curso=Teclado.leerString("\nQue curso ?");
		} while (!cursos.contains(curso));

		String cursoActual=curso;

		alumnos.stream()
		.filter(a->a.getCurso()
				.equalsIgnoreCase(cursoActual))
		.filter(Alumno::isRepetidor)
		.min((a1,a2)->Float
				.compare(a1.getNota(), a2.getNota()))
		.ifPresentOrElse(ESCRIBIDOR, ()->System.out.println("\nSin datos"));

		//Nota media de los alumnos del curso con más alumnos. A medias
		DoubleSummaryStatistics summary= alumnos.stream()
				.filter(a->a.getCurso()
						.equalsIgnoreCase(cursoActual))
				.mapToDouble(Alumno::getNota)
				.summaryStatistics();

		System.out.println(summary.getAverage());

	}

	public static List<Alumno> cargarAlumnos ()
	{
		List <Alumno> alumnos = new ArrayList<Alumno>();
		Alumno alumno;
		try (BufferedReader fichero = new BufferedReader (new FileReader ("alumnos.csv")) )
		{

			while (fichero.ready())
			{
				alumno = Alumno.fromCSV(fichero.readLine());
				alumnos.add(alumno);
			}

			/*alumnos = fichero.lines(). // obtener lineas de fichero como stream
			 * 				map(Alumno::fromCSV).// convertir la linea a un alumno
			 * 				toList();// convertir stream de alumnos a lista
			 */

		}

		catch (IOException e)
		{
			Pantalla.escribirString("\nError accediendo al fichero...");

		}

		return alumnos;
	}

}
