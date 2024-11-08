package practicaTocha;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

public class CsvEnumConverter extends AbstractBeanField<String, EstadoEmpleo>{

	@Override
	protected Object convert(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
		return EstadoEmpleo.toEnum(value);
	}
	
	
	
}
