package ejercicioinsti.modelo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class Instituto {
	@EqualsAndHashCode.Include
	@NonNull
	
	@Id
	@Column(length = 10, unique = true)
	private String codCentro;
	
	@Column(length = 30)
	private String nombre;
	
	@Column(length = 12)
	private String telefono;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Direccion direccion;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Estudiante> estudiantes;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Profesor> profesores;
}
