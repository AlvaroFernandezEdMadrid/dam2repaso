package practicaTocha;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.opencsv.bean.CsvBindAndSplitByPosition;
import com.opencsv.bean.CsvToBeanBuilder;

import lombok.Data;
@Data

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class EmpleadosWrapper {
	
	@CsvBindAndSplitByPosition(position = 0, splitOn = Separadores.SEPARADOREMPL, converter = CsvEmpleadosConverter.class, elementType = Empleado.class)

	private List<Empleado> empleados;
	
	
	public EmpleadosWrapper() {
		/*try {
			empleados=cargarCsv();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
	}

	private List<Empleado> cargarCsv() throws IllegalStateException, FileNotFoundException {
		List<Empleado> emp=new CsvToBeanBuilder(new FileReader("empleados.csv"))
				.withType(Empleado.class)
				.withSeparator(Separadores.SEPARADORCOSASEMPL.charAt(0))
				.build()
				.parse();
		
		return emp;
	}
	
	
}


