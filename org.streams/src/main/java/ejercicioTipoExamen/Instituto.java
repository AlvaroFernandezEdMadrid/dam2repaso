package ejercicioTipoExamen;

import com.opencsv.bean.CsvBindByPosition;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Instituto {
	@CsvBindByPosition(position = 0)
	private String nombre;
	@CsvBindByPosition(position = 1)
	@EqualsAndHashCode.Include
	private String codigoCentro;
	@CsvBindByPosition(position = 2)
	private String numeroTel;
	@CsvBindByPosition(position = 3)
	private float presupuesto;
	
	
	
}
