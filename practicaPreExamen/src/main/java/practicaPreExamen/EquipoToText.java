package practicaPreExamen;

import java.io.StringReader;
import java.util.stream.Stream;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.AbstractCsvConverter;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

public class EquipoToText extends AbstractCsvConverter{

	@Override
	public Object convertToRead(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
		StringReader stringReader = new StringReader(value);

		CSVParser icsvParser = new CSVParserBuilder().withSeparator('$').build();
		CSVReader csvReader = new CSVReaderBuilder(stringReader).withCSVParser(icsvParser).build();

		Stream <Equipo> beans = new CsvToBeanBuilder(csvReader)
				.withType(Equipo.class)
				.build()
				.stream();

		return beans.findFirst().orElseGet(Equipo::new);
		
	}

}