package ejercicioTipoExamen;

import java.util.Set;

import com.opencsv.bean.CsvBindAndSplitByPosition;
import com.opencsv.bean.CsvBindByPosition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
	@CsvBindAndSplitByPosition(position = 4, elementType= Empleado.class, splitOn = ";", converter = TextToEmpleado.class, writeDelimiter = ";")
	private Set<Empleado> empleados;
	
	public void setPresupuesto(float pres) throws IllegalArgumentException{
		if (pres<0) {
			throw new IllegalArgumentException("\nNo se admiten presupuestos negativos");
		}else {
			this.presupuesto=pres;
		}
	}
}
