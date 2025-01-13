package practicabanco.modelo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "ClienteCuenta")

@Entity
public class ClienteCuenta {
	@Id
	@EqualsAndHashCode.Include
	@NonNull
	private String id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idCuenta")
	private Cuenta cuentaId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idCliente")
	private Cliente clienteId;
	
	
}
