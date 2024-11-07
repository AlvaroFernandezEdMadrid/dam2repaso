package practicaPreExamen;

import java.time.LocalDate;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;

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
public class Corredor {
	@EqualsAndHashCode.Include
	@CsvBindByPosition(position = 0)
	private String dni;
	@CsvBindByPosition(position = 1)
	private String nombre;
	@CsvBindByPosition(position = 2)
	@CsvDate("yyyy-MM-dd")
	private LocalDate fechaNac;
	@CsvBindByPosition(position = 3)
	private boolean profesional;
	
	public boolean isMayorEdad() {
		return LocalDate.now().minusYears(18).isAfter(fechaNac);
		
	}
}


