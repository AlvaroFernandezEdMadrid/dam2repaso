package ejercicioinsti.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
public class Direccion {
	@EqualsAndHashCode.Include
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	
	@Column(length = 20)
	private String calle;
	
	@Column(length = 20)
	private String poblacion;
	
	@Column(length = 5)
	private String codPostal;
}
