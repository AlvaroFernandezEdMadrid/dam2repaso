package practicabanco.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Cliente {
	
	@Id
	@NonNull
	@Column(length = 10, name = "idCliente")
	@EqualsAndHashCode.Include
	private String nif;
	
	@Column(length = 20)
	private String nombre;
	
	private float aval;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Singular
	private Set<Telefono> telefonos;
	
	public void addTelefono(Telefono t) {
		
		if (telefonos==null) {
			telefonos=new HashSet<Telefono>();
		}
		
			telefonos.add(t);
	}
}
