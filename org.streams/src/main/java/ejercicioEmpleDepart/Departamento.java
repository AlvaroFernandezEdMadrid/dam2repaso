package ejercicioEmpleDepart;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Departamento {
	@EqualsAndHashCode.Include
	private String codigo;
	private String nombre;
	private String ciudad;
	private Set<Empleado> empleados;

	public Departamento(String codigo, String nombre, String ciudad) {

		this.codigo = codigo;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.empleados = new HashSet<Empleado> ();
	}

	
	public boolean addEmple (Empleado empleado)
	{
		return empleados.add(empleado);
	}

	
}
