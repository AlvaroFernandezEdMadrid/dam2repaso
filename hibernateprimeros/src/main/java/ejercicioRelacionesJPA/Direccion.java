package ejercicioRelacionesJPA;

import java.io.Serializable;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Direccion implements Serializable{

	@Id
    @Column(name="ID_DIRECCION")
    @GeneratedValue (strategy = GenerationType.AUTO)
	@EqualsAndHashCode.Include
    private Integer id;
	@Column(name = "CALLE", length = 30)
    private String calle;
	@Column(name = "PORTAL", length = 10)
    private String portal;
	@Column(name = "POBLACION", length = 30)
    private String poblacion;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "alumno_id")  // Relación con el alumno (una dirección tiene un solo alumno)
	private Alumno alumno;
}
