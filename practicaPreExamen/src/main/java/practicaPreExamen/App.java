package practicaPreExamen;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.opencsv.bean.CsvToBeanBuilder;

public class App 
{

	public static void main( String[] args ) 
	{
		try {
			List<Carrera> carreras=cargarDatos();

			System.out.println(carreras);

			//Consultas
			//
			
			System.out.println("\nListado del nombre, año y director de todas las vueltas con más de 10 etapas., ordenado por año en sentido creciente (de menor a mayor):\n");
			
			carreras.stream()
			.flatMap(a -> a.getVueltas().stream())
			.filter(b -> b.getNumEtapas() > 10)
			.sorted(Comparator.comparing(Vuelta::getAnio))
			.map(b -> "Nombre: " + b.getNombre() + ", Año: " + b.getAnio() + ", Director: " + b.getDirector())
			.forEach(System.out::println);

			// 
			
			System.out.println("\nListado del nombre de todos los corredores que participen en vueltas ciclistas con un premio superior a 30000 euros:\n");
			
			carreras.stream()
			.flatMap(a -> a.getVueltas().stream())
			.filter(d->d.getPremio()>30000)
			.flatMap(b-> b.getEquipos().stream())
			.flatMap(c->c.getCorredores().stream())
			.map(e->e.getNombre())
			.forEach(System.out::println);
			
			//
			
			System.out.println("\nListado de todos los equipos con corredores profesionales menores de edad: \n");
			
			carreras.stream()
			.flatMap(a -> a.getVueltas().stream())
			.flatMap(b-> b.getEquipos().stream())
			.flatMap(c->c.getCorredores().stream())
			.filter(e->e.isMayorEdad())
			.collect(Collectors.toList())
			.forEach(System.out::println);
			
			//
			
			System.out.println("\nListado de los directores de las vueltas que tengan patrocinadores de nacionalidad “española” desde 2010 a 2020 ambos incluidos: \n");
			
			

		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public static List<Carrera> cargarDatos()throws IllegalStateException, FileNotFoundException{
		List<Carrera> beans = new CsvToBeanBuilder(new FileReader("datos.csv"))
				.withType(Carrera.class)
				.withSeparator('@')
				.build()
				.parse();

		return beans;
	}


}
