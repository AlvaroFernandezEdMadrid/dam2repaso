package practicaTocha;

import java.time.LocalDate;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.opencsv.bean.CsvBindAndSplitByPosition;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByPosition;
import com.opencsv.bean.CsvDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@XmlAccessorType(XmlAccessType.FIELD)
public class Empleado {
	@EqualsAndHashCode.Include
	@CsvBindByPosition(position = 0)
	private String id;
	@CsvBindByPosition(position = 1)
	private String nombre;
	@CsvDate("yyyy-MM-dd")
	@CsvBindByPosition(position = 2)
	@XmlJavaTypeAdapter(XLocalDateAdapter.class)
	private LocalDate fechaNac;
	@CsvCustomBindByPosition(position = 3, converter = CsvEnumConverter.class)
	private EstadoEmpleo estadoEmpleo;
	@CsvBindAndSplitByPosition(position = 4, elementType = Proyecto.class, converter = CsvProyectoConverter.class, splitOn = Separadores.SEPARADORPROYECTOS)
	@XmlElementWrapper(name = "proyectos")
	@XmlElement(name = "proyecto")
	private List<Proyecto> proyectos;
	
}
