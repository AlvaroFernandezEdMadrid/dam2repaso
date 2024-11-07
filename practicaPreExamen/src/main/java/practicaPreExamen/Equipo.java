package practicaPreExamen;

import java.util.Set;

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
public class Equipo {
	@EqualsAndHashCode.Include
	@CsvBindByPosition(position = 0)
	private String nombre;
	@CsvBindAndSplitByPosition(position = 1, elementType = Corredor.class, splitOn = "~", converter = CorredorToText.class)
	private Set<Corredor> corredores;
	@CsvBindByPosition(position = 2)
	private String nombrePatro;
	@CsvBindByPosition(position = 3)
	private String nacionalidadPatro;
	@CsvBindByPosition(position = 4)
	private float donacionPatro;
	
}
