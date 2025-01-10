package ejercicioinsti.modelo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Persona {
	@NonNull
	@EqualsAndHashCode.Include
	
	@Id
	@Column(length = 10, unique = true)
	private String nif;
	
	@Column (length=20)
	private String nombre;
	
	private LocalDate fechaNac;
	
	@Column (length=20)
	private String poblacion;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "persona")
	private List<Email> email;
}
