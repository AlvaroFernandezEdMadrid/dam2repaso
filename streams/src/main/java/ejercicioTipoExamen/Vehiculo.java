package ejercicioTipoExamen;

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
public class Vehiculo {
	@CsvBindByPosition(position = 0)
	private String modelo;
	@CsvBindByPosition(position = 1)
	private String color;
	@CsvBindByPosition(position = 2)
	@EqualsAndHashCode.Include
	private String matricula;
	
	
}
