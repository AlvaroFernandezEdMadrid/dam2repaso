package ejercicioTipoExamen;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;
import java.util.stream.Stream;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.AbstractCsvConverter;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class TextToTelefono extends AbstractCsvConverter {
	@Override
	public Object convertToRead(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
		// TODO Auto-generated method stub
		StringReader stringReader = new StringReader(value);

		CSVParser icsvParser = new CSVParserBuilder().withSeparator('#').build();
		CSVReader csvReader = new CSVReaderBuilder(stringReader).withCSVParser(icsvParser).build();

		Stream <Telefono> beans = new CsvToBeanBuilder(csvReader)
				.withType(Telefono.class)
				//.withSeparator(';') // aquí no funciona
				.build()
				.stream();

		return beans.findFirst().orElseGet(Telefono::new);
	}
	
	public String convertToWrite(Object value) throws CsvDataTypeMismatchException
	{
		Writer writer = new StringWriter();
		try {
		     StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).
		    		 withSeparator('#'). // separador de campos
		    		 withApplyQuotesToAll(false).// no poner comillas
		    		 withLineEnd("").//separador de elementos
		    		 build();
		     beanToCsv.write(List.of(value));
		     //System.out.println(writer.toString());
		} catch (CsvDataTypeMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CsvRequiredFieldEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return writer.toString();
	}

}
