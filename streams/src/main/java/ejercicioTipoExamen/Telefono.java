package ejercicioTipoExamen;

import com.opencsv.bean.CsvBindByPosition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Telefono {
	@CsvBindByPosition(position = 0)
	private String compania;
	@CsvBindByPosition(position = 1)
	@EqualsAndHashCode.Include
	private String numero;
	@CsvBindByPosition(position = 2)
	private String sistemaOperativo;
}
