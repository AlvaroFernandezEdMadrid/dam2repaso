package ejercicioTipoExamen;

import java.time.LocalDate;
import java.util.List;

import com.opencsv.bean.CsvBindAndSplitByPosition;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Empleado {
	/*
	 * Se desea acceder a los datos de una BBDD de institutos. 
	 * Se conoce que de cada instituto se guarda su nombre, 
	 * su código de centro, su número de teléfono y presupuesto. 
	 * Se distinguen los institutos por su código de centro. 
	 * Además se guarda información sobre las personas que trabajan y estudian en él.


	De cada persona se guarda sus teléfonos de contacto (compañía de telecomunicaciones, 
	número de teléfono y sistema operativo), junto a estos datos también se guarda 
	información sobre su nombre, NIF ,fecha de nacimiento. 
	Se distinguen las personas por su NIF.
	 */
	@CsvBindByPosition(position=0)
	private String nombre;
	@EqualsAndHashCode.Include
	@CsvBindByPosition(position=1)
	private String nif;
	@CsvBindByPosition(position=2)
	@CsvDate("yyyy-MM-dd")
	private LocalDate fechaNac;
	@CsvBindAndSplitByPosition(position = 3, elementType= Telefono.class, splitOn = "@", converter = TextToTelefono.class, writeDelimiter = "@")
	private List<Telefono> telefonos;
	
	
	public boolean isMayorEdad() {
		return LocalDate.now().isAfter(fechaNac.plusYears(18));
	}
}
