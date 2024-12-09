package ejercicioRelacionesJPA;

import java.io.Serializable;
import java.util.HashSet;
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
public class Grupo implements Serializable {

    @Id
    @Column(name="ID_GRUPO")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(name = "NOMBRE", length = 30)
    private String nombre;

    @Column(name = "UBICACION", length = 30)
    private String ubicacion;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "tutor_id", nullable = true)  // Relación con el tutor (Profesor), opcional
    private Profesor tutor;

    @OneToMany(mappedBy = "grupo", fetch = FetchType.EAGER)  // Relación con los alumnos
    @Builder.Default  // Esto asegura que el campo se inicializa con un HashSet vacío
    private Set<Alumno> alumnos = new HashSet<>();  // Un grupo tiene varios alumnos

}
