package ejercicioRelacionesJPA;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer valor;  // Valor de la nota (debe estar entre 1 y 10)

    @ManyToOne
    @JoinColumn(name = "alumno_id")  // Relación con el alumno
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "modulo_id")  // Relación con el módulo
    private Modulo modulo;
}
