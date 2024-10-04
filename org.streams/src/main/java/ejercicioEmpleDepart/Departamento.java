package ejercicioEmpleDepart;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Setter(AccessLevel.PRIVATE)
@Data
public class Departamento {
	private String codigo;
	private String nombre;
	private String ciudad;
	private Set<Empleado> empleados;
	
	
	public Departamento(String codigo, String nombre, String ciudad, Set<Empleado> empleados) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.empleados = new HashSet<Empleado>();
	}
	
	
}
