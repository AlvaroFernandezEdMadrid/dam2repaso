package practicaPreExamen;

import java.util.List;

import com.opencsv.bean.CsvBindAndSplitByPosition;
import com.opencsv.bean.CsvBindByPosition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Vuelta {
	@CsvBindByPosition(position = 0) 
	@EqualsAndHashCode.Include
	private String nombre;
	@CsvBindByPosition(position = 1) 
	private float premio;
	@CsvBindByPosition(position = 2) 
	private String director;
	@CsvBindByPosition(position = 3) 
	private int numEtapas;
	@CsvBindByPosition(position = 4) 
	@EqualsAndHashCode.Include
	private int anio;
	@CsvBindAndSplitByPosition(position = 5, elementType = Equipo.class, splitOn = ";", converter = TextToEquipo.class)
	private List<Equipo> equipos; 
}
