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
public class Nota implements Serializable{

	@Id
    @Column(name="ID_NOTA")
    @GeneratedValue (strategy = GenerationType.AUTO)
	@EqualsAndHashCode.Include
    private Integer id;
	@Column(name = "VALOR")
    private Integer valor;  // Valor de la nota (debe estar entre 1 y 10)

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "alumno_id")  // Relación con el alumno
    private Alumno alumno;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "modulo_id")  // Relación con el módulo
    private Modulo modulo;
}
