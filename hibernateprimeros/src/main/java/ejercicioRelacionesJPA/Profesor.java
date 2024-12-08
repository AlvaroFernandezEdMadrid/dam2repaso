package ejercicioRelacionesJPA;

import java.util.Set;

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
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dni;
    private String nombre;
    private String especialidad;

    @OneToMany(mappedBy = "profesor")  // Relación con los módulos
    private Set<Modulo> modulos;  // Un profesor imparte varios módulos
}
