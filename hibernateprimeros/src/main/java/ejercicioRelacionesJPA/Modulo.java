package ejercicioRelacionesJPA;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

@Entity
public class Modulo {

	@EqualsAndHashCode.Include
	@Id
	@Column(length = 10)
	private String id;

	@Column(length = 30)
	private String nombre;


	//@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER) //actúa sobre profesor
	@ManyToOne(cascade=CascadeType.MERGE,fetch=FetchType.EAGER) 
	@JoinColumn(name="idProfesor")
	private Profesor profesor;

	/*
	@OneToMany
	@JoinColumn(name = "idModulo")
	private Set<Calificacion> calificaciones;
	 */
}
