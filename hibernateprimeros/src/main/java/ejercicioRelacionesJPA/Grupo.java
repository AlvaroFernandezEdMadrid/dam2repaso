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
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String ubicacion;

    @ManyToOne
    @JoinColumn(name = "tutor_id")  // Relación con el tutor (Profesor)
    private Profesor tutor;

    @OneToMany(mappedBy = "grupo")  // Relación con los alumnos
    private Set<Alumno> alumnos;  // Un grupo tiene varios alumnos
}
