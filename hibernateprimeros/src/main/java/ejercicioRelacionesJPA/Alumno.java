package ejercicioRelacionesJPA;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@EntityListeners(AlumnoListener.class)// Trigger para borrar alumno
@Entity
public class Alumno {
	@EqualsAndHashCode.Include
	@Id
	@Column(length = 10)
	private String dni;

	@Column(length = 30)
	private String nombre;

	private LocalDate fechaNacimiento;

	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="idDireccion")
	private Direccion direccion;

	/*
	@OneToMany
	@JoinColumn(name = "idAlumno")
	private Set<Calificacion> calificaciones;
	 */


}
