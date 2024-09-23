package org.vb.ejercicioRepaso;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import daw.com.Teclado;

public class App 
{
	public static void main( String[] args )
	{
		ArrayList<Alumno> alumnos;

		alumnos=cargarAlumnos();

		mostrarPorNombre(alumnos);

		mostrarPorFechayNombre(alumnos);

		mostrarPorCursoyNota(alumnos);

		mostrarAprobadosCurso(alumnos);
		
		mostrarMasJovenMasViejo(alumnos);

	}

	private static void mostrarMasJovenMasViejo(ArrayList<Alumno> alumnos) {
		Optional<Alumno> mayorEdad, menorEdad;
		
		mayorEdad=alumnos.stream()
				.min(Comparator.comparing(Alumno::getFechaNac));
		
		menorEdad=alumnos.stream()
				.max(Comparator.comparing(Alumno::getFechaNac));
		
		
		System.out.println("\nEl alumno mayor es: ");
		mayorEdad.ifPresent(System.out::println);
		
		System.out.println("\nEl alumno menor es: ");
		menorEdad.ifPresent(System.out::println);
		
	}

	private static void mostrarAprobadosCurso(ArrayList<Alumno> alumnos) {
		List<String> cursos, temp;
		List<Alumno> aprobados;
		String cual;
		
		System.out.println("\nCursos: \n");
		
		cursos=(ArrayList<String>) alumnos.stream()
				.map(Alumno::getCurso) // Recogemos los cursos
				.distinct() // Quitamos duplicados
				.collect(Collectors.toList()); // Recogemos en forma de lista
		
		cursos.forEach(System.out::println); // Pintamos
		
		temp=(ArrayList<String>) cursos.stream()
				.map(curso -> curso.toUpperCase()) //Transformamos a mayusculas 
				.collect(Collectors.toList());
		
		do {	
			
			cual=Teclado.leerString("\nElige un curso: ").toUpperCase();
				
		} while (!temp.contains(cual));
		
		
		aprobados=filtrarAlumnosPorCurso(cual,alumnos);
		
		System.out.println("\nAlumnos aprobados de "+cual+" :\n");
		
		aprobados.forEach(System.out::println);
		
	}

	private static List<Alumno> filtrarAlumnosPorCurso(String cual, ArrayList<Alumno> alumnos) {
		List<Alumno> aprobados;
		
		aprobados=alumnos.stream()
	            .filter(alumno -> alumno.getCurso().equalsIgnoreCase(cual) && alumno.getNota() >= 5)
	            .collect(Collectors.toList());
		
		return aprobados;
	}

	private static void mostrarPorCursoyNota(ArrayList<Alumno> alumnos) {
		System.out.println("\nAlumnos ordenados por curso y nota:\n");

		alumnos.stream().sorted(Comparator.
				comparing(Alumno::getNota).
				thenComparing(Alumno::getCurso)).
		collect(Collectors.toList()).
		forEach(System.out::println);
	}

	private static void mostrarPorFechayNombre(ArrayList<Alumno> alumnos) {
		System.out.println("\nAlumnos ordenados por fecha y nombre:\n");

		alumnos.stream().sorted(Comparator.
				comparing(Alumno::getNombre).
				thenComparing(Alumno::getFechaNac)).
		collect(Collectors.toList()).
		forEach(System.out::println);
	}

	private static void mostrarPorNombre(ArrayList<Alumno> alumnos) {
		System.out.println("\nAlumnos ordenados por nombre:\n");

		alumnos.stream().sorted(Comparator.comparing(Alumno::getNombre)).
		collect(Collectors.toList()).
		forEach(System.out::println);

	}

	public static ArrayList<Alumno> cargarAlumnos(){

		ArrayList<Alumno> alumnos=new ArrayList<Alumno>();

		Alumno alumno;
		String linea;

		// Leer alumnos del fichero
		try (BufferedReader buffer = new BufferedReader(new FileReader ("alumnos.csv")))
		{

			while (buffer.ready()&&alumnos.size()<10)
			{
				linea = buffer.readLine();
				alumno = new Alumno ();
				alumno.fromCsv(linea);
				alumnos.add(alumno);
			}


		}  catch (IOException e) {
			System.err.println("\nError leyendo fichero...");
		}

		return alumnos;
	}
}

