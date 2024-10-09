package ejercicioEmpleDepart;

import java.time.LocalDate;
import java.util.Optional;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter(AccessLevel.PRIVATE)
@Data
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Empleado{
	@EqualsAndHashCode.Include
	@NonNull
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
			Empleado jefe) {

		this.dni=dni;
		this.nombre=nombre;
		this.sexo=sexo;
		setFechaNacimiento(fechaNacimiento);
		setFechaIncorporacion(fechaIncorporacion);
		setSalario(salario);
		setComision(comision);
		this.cargo=cargo;
		this.jefe = Optional.ofNullable(jefe);

	}

	private void setFechaIncorporacion(LocalDate fecha) throws IllegalArgumentException{
		try {
			if (fechaIncorporacion.isAfter(LocalDate.now())) {
				throw new IllegalArgumentException("\nNo puede haber incorporaciones posteriores a hoy.");
			}
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
	}

	private void setFechaNacimiento(LocalDate fecha) throws IllegalArgumentException{
		try {
			if (fecha.plusYears(18).isBefore(LocalDate.now())) {
				throw new IllegalArgumentException("\nNo se admiten menores de edad");
			}else {
				fechaNacimiento=fecha;
			}
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
	}

	private void setSalario(float salario) throws IllegalArgumentException{
		if (salario<=0) {
			throw new IllegalArgumentException("\nNo se admiten salarios negativos");
		}else {
			this.salario=salario;
		}
	}
	
	private void setComision(float comision) {
		if (comision<=0) {
			throw new IllegalArgumentException("\nNo se admiten comisiones negativas");
		}else {
			this.comision=comision;
		}
	}
	
	public void setJefe(Empleado jefe) {
		this.jefe = Optional.ofNullable(jefe);
	}
	
	public float getSalarioTotal() {
		return salario+comision;
	}

	@Override
	public String toString() {
		return "Empleado [dni=" + dni + ", nombre=" + nombre + ", sexo=" + sexo + ", fechaNacimiento=" + fechaNacimiento
				+ ", fechaIncorporacion=" + fechaIncorporacion + ", salario=" + salario + ", comision=" + comision
				+ ", cargo=" + cargo + (jefe.map(Empleado::getNombre).orElse("SIN JEFE")) + "]";
	}
	
	/*public void fromCsv(String linea) {
		String[] campos=linea.split(";");
		
		setDni(campos[0]);
		setNombre(campos[1]);
		setSexo(campos[2]);
		setFechaNacimiento(LocalDate.parse(campos[3]));
		setFechaIncorporacion(LocalDate.parse(campos[4]));
		setSalario(Float.parseFloat(campos[5]));
		setComision(Float.parseFloat(campos[6]));
		setCargo(campos[7]);
		this.jefe=(Optional.of(new Empleado(campos[8])));
		
	}*/
	
	
}



