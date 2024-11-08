package practicaTocha;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@XmlAccessorType(XmlAccessType.FIELD)
public class Proyecto {
	@CsvBindByPosition(position = 0)
	private String nombre;
	@CsvDate("yyyy-MM-dd")
	@CsvBindByPosition(position = 1)
	@XmlJavaTypeAdapter(XLocalDateAdapter.class)
	private LocalDate fecha;
}
