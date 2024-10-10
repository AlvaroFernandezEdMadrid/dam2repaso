package ejercicioTipoExamen;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;


import com.opencsv.bean.CsvToBeanBuilder;

public class App {

	public static void main(String[] args) throws IllegalStateException, FileNotFoundException{
		List<Instituto> beans = new CsvToBeanBuilder(new FileReader("institutos.csv"))
                .withType(Instituto.class)
                .withSeparator(':')
                .build()
                .parse();

    	beans.forEach(System.out::println);
	}

}
