package practicabanco.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Telefono {
	@Id
	@NonNull
	@Column(length = 12)
	@EqualsAndHashCode.Include
	private String numero;
	@Column(length = 20)
	private String compania;
}
