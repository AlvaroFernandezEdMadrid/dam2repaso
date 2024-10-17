package ejercicioTipoExamen;

import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import static java.util.stream.Collectors.*;
import com.opencsv.bean.*;
import com.opencsv.exceptions.*;

public class App {
	final static Consumer<Object> ESCRIBIDOR=System.out::println;
	public static void main(String[] args) throws IllegalStateException, FileNotFoundException{
		List<Instituto> beans = new CsvToBeanBuilder(new FileReader("institutos.csv"))
				.withType(Instituto.class)
				.withSeparator(':')
				.build()
				.parse();

		//guardarDatosCSV(beans);

		beans.forEach(System.out::println);
		
		//Consultas:

		//1 - Listado del nombre y el número de teléfono, 
		//ordenado por nombre, de todos los institutos cuyo código de centro comience por “28”. 
		System.out.println("\nConsulta 1:\n");

		beans.stream()
		.filter(i->i.getCodigoCentro()
				.startsWith("28"))
		.map(a->a.getNombre()+" - "+a.getNumeroTel())
		.sorted(Comparator.comparing(e->e.toString()))
		.collect(toList()).forEach(ESCRIBIDOR);

		//2 - Listado del nombre de todas las personas de todos los institutos que tengan un 
		// vehículo de color “verde”. 

		// 3 - Listado de todas las compañías de telecomunicaciones de todas las personas mayores 
		// de edad de todos los institutos. 
		System.out.println("\nConsulta 3:\n");

		beans.stream()
		.flatMap(a -> a.getEmpleados().stream()
				.filter(Empleado::isMayorEdad)
				.flatMap(e -> e.getTelefonos().stream()
						.map(Telefono::getCompania)))
		.distinct()
		.collect(toList())
		.forEach(ESCRIBIDOR);

		//Total del presupuesto de todos los institutos que tengan más de una persona. 
		System.out.println("\nConsulta 4:\n");

		System.out.println(
				beans.stream()
				.filter(i->i.getEmpleados()
						.size()>1)
				.mapToDouble(Instituto::getPresupuesto)
				.sum());

		//Listado de los centros de adultos, es decir los institutos que no tengan 
		//alumnos menores de edad. 
		System.out.println("\nConsulta 5:\n");

		beans.stream()
		.filter(i -> i.getEmpleados().stream()
				.noneMatch(empleado -> !empleado.isMayorEdad()))
		.collect(toList()).forEach(ESCRIBIDOR);

		//Listado del nombre y todos los datos de todos los teléfonos de contactos 
		//de todas las personas menores de edad por nombre de instituto.
		System.out.println("\nConsulta 6:\n");
		
		
		 
	}

	public static void guardarDatosCSV (List<Instituto> deptos)
	{

		Writer writer;
		try {
			writer = new FileWriter("institutos1.csv");
			StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).
					withSeparator(':').
					withApplyQuotesToAll(false).
					build();
			beanToCsv.write(deptos);
			writer.close();
			System.out.println("Datos guardados");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CsvDataTypeMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CsvRequiredFieldEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}


}
