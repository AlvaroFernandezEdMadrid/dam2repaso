package ejercicioEmpleDepart;
import java.time.LocalDate;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Empleado {
	@EqualsAndHashCode.Include
	private String dni;
	private String nombre;
	private boolean mujer;
	private LocalDate fechaNacimiento;
	private LocalDate fechaIncorporacion;
	private float salario,comision;
	private String cargo;
	private Optional<Empleado> jefe;
	
	public Empleado(String dni, String nombre, boolean mujer, LocalDate fechaNacimiento, LocalDate fechaIncorporacion,
			float salario, float comision, String cargo, Empleado jefe) {
		
		this.dni = dni;
		this.nombre = nombre;
		this.mujer = mujer;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaIncorporacion = fechaIncorporacion;
		this.salario = salario;
		this.comision = comision;
		this.cargo = cargo;
		this.jefe = Optional.ofNullable(jefe);
	}

	public Optional<Empleado> getJefe() {
		return jefe;
	}

	public void setJefe(Empleado jefe) {
		this.jefe = Optional.ofNullable(jefe);
	}

	@Override
	public String toString() {
		return "Empleado [dni=" + dni + ", nombre=" + nombre + ", sexo=" + (mujer?"Mujer":"Hombre") + ", fechaNacimiento=" + fechaNacimiento
				+ ", fechaIncorporacion=" + fechaIncorporacion + ", salario=" + salario + ", comision=" + comision
				+ ", cargo=" + cargo + ", jefe=" + jefe.map(Empleado::getNombre).orElse("sin jefe") + "]";
	}
	
}
