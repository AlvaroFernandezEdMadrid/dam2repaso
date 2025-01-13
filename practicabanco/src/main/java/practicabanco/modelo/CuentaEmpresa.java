package practicabanco.modelo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)

@Entity
@DiscriminatorValue("Empresa")
public class CuentaEmpresa extends Cuenta {
	@Column(length = 25)
	private String nombreEmpresa;
	@Column(length = 20)
	private String cif;
	
	private boolean localPropio;
}
