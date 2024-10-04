package ejercicioEmpleDepart;

import java.time.LocalDate;
import java.util.Optional;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Setter(AccessLevel.PRIVATE)
@Data
public class Empleado implements Comparable<Empleado>{
	private String dni;
	private String nombre;
	private String sexo;
	private LocalDate fechaNacimiento;
	private LocalDate fechaIncorporacion;
	private float salario;
	private float comision;
	private String cargo;
	private Optional<Empleado> jefe;

	public Empleado(String dni, String nombre, 
			String sexo, LocalDate fechaNacimiento, 
			LocalDate fechaIncorporacion, float salario, 
			float comision, String cargo, 
			Optional<Empleado> jefe) {

		this.dni=dni;
		this.nombre=nombre;
		this.sexo=sexo;
		setFechaNacimiento(fechaNacimiento);
		setFechaIncorporacion(fechaIncorporacion);
		setSalario(salario);
		setComision(comision);
		this.cargo=cargo;
		setJefe(jefe);

	}

	@Override
	public int compareTo(Empleado o) {		
		return this.dni.compareTo(o.getDni());
	}
	
	private void setFechaIncorporacion(LocalDate fecha) throws IllegalArgumentException{
		try {
			if (true) {
				
			}
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
	}

	private void setFechaNacimiento(LocalDate fecha) throws IllegalArgumentException{
		try {
			if (fecha.plusYears(18).isAfter(LocalDate.now())) {
				throw new IllegalArgumentException("\nNo se admiten menores de edad");
			}else {
				fechaNacimiento=fecha;
			}
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
	}
}



