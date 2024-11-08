package practicaTocha;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.opencsv.bean.CsvToBeanBuilder;

public class Apepe {

	public static void main(String[] args) throws IllegalStateException, FileNotFoundException {

		EmpleadosWrapper wrapper=new EmpleadosWrapper();


		
		//Escritura XML
		/*try {
			LeerYEscribirXML<EmpleadosWrapper> escribidor = new LeerYEscribirXML<EmpleadosWrapper>();

			escribidor.escribirXML(wrapper, new FileWriter(new File("empleados.xml")));

		} catch (Exception e) {
			System.err.println(e);
		}*/
		
		//Lectura XML
		/*try {
			LeerYEscribirXML<EmpleadosWrapper> lector = new LeerYEscribirXML<EmpleadosWrapper>();

			wrapper=lector.leerXML(EmpleadosWrapper.class, new File("empleados.xml"));
		} catch (Exception e) {
			System.err.println(e);
		}*/
		
		//Escritura JSON
		/*GsonBuilder creadorGson = new GsonBuilder();
		creadorGson.setPrettyPrinting();
		creadorGson.registerTypeAdapter (LocalDate.class, new JLocalDateAdapter());
		Gson gson = creadorGson.create();

		try (FileWriter writer=new FileWriter("empleados.json")){
			gson.toJson (wrapper, writer);
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		
		//Lectura JSON
		
		GsonBuilder creadorGson = new GsonBuilder();
		creadorGson.setPrettyPrinting();
		creadorGson.registerTypeAdapter (LocalDate.class, new JLocalDateAdapter());
		Gson gson = creadorGson.create();
		
		try (FileReader reader= new FileReader("empleados.json")){
			wrapper=gson.fromJson(reader, EmpleadosWrapper.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Consultas
		wrapper.getEmpleados().stream()
		.collect(Collectors.toList())
		.forEach(System.out::println);

		wrapper.getEmpleados().stream()
		.map(Empleado::getNombre)
		.collect(Collectors.toList())
		.forEach(System.out::println);

	}



}
