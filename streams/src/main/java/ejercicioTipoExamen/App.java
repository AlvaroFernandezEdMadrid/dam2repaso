package ejercicioTipoExamen;

import java.io.*;
import java.util.List;


import com.opencsv.bean.*;
import com.opencsv.exceptions.*;

public class App {

	public static void main(String[] args) throws IllegalStateException, FileNotFoundException{
		List<Instituto> beans = new CsvToBeanBuilder(new FileReader("institutos.csv"))
                .withType(Instituto.class)
                .withSeparator(':')
                .build()
                .parse();

		guardarDatosCSV(beans);
		
    	beans.forEach(System.out::println);
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
