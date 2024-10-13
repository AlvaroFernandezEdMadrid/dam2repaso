package ejercicioTipoExamen;


import java.util.Optional;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class OptionalToText extends AbstractBeanField<String, Optional<Vehiculo>>{

	@Override
	protected Object convert(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
		// TODO Auto-generated method stub
		Optional<Vehiculo> transporte;

		transporte = value.equals("sin vehiculo")?
				Optional.empty():
					Optional.of(Vehiculo.builder().matricula(value).build());

		return transporte;
	}


	@Override
	protected String convertToWrite(Object value) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException 
	{

		Optional<Vehiculo> transporte = value== null? Optional.empty():Optional.of((Vehiculo)value);

		return transporte.map(Vehiculo::getMatricula).orElse("sin vehiculo");

	}

}