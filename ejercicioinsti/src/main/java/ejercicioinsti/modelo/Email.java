package ejercicioinsti.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Email {
	@EqualsAndHashCode.Include
	
	@Id
	private int id;
	
	@Column(length = 10)
	private String tipo;
	
	@Column(length = 20)
	private String direccion;
}
