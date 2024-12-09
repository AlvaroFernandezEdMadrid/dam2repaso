package ejercicioRelacionesJPA;

import java.io.Serializable;
import java.util.Set;

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
public class Profesor implements Serializable{

	@Id
	@Column(name="ID_PROFESOR")
    @GeneratedValue (strategy = GenerationType.AUTO)
	@EqualsAndHashCode.Include
    private Integer id;
	
    @Column(name = "DNI", length = 9)
    private String dni;
    @Column(name = "NOMBRE", length = 30)
    private String nombre;
    @Column(name = "ESPECIALIDAD", length = 30)
    private String especialidad;

    @OneToMany(mappedBy = "profesor", cascade = CascadeType.PERSIST)  // Relación con los módulos
    private Set<Modulo> modulos;  // Un profesor imparte varios módulos
}
