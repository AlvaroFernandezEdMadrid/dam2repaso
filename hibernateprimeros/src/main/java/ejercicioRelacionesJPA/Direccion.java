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
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String calle;
    private String portal;
    private String poblacion;

    @OneToOne
    @JoinColumn(name = "alumno_id")  // Relación con el alumno (una dirección tiene un solo alumno)
    private Alumno alumno;
}
