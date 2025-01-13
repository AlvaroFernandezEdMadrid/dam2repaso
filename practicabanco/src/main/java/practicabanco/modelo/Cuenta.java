package practicabanco.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Cuenta {
	@Column(length = 50, name = "idCuenta")
	@Id
	@EqualsAndHashCode.Include
	@NonNull
	private String numero;
	
	private float saldo;
	
	public boolean aumentarSaldo(float cuanto) {
		boolean exito=false;
		if (cuanto>0) {
			saldo+=cuanto;
			exito=true;
		}
		return exito;
	}
}
