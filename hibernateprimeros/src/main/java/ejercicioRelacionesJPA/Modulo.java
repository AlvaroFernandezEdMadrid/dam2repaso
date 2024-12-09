package ejercicioRelacionesJPA;

import java.io.Serializable;
import java.util.HashSet;  // Asegúrate de importar HashSet
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
public class Modulo implements Serializable {

    @Id
    @Column(name = "ID_MODULO")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(name = "NOMBRE", length = 30)
    private String nombre;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "profesor_id")  // Relación con el profesor que imparte el módulo
    private Profesor profesor;

    @ManyToMany(mappedBy = "modulos")  // Relación con los alumnos (muchos a muchos)
    @Builder.Default  // Inicializa la colección de alumnos con un HashSet vacío
    private Set<Alumno> alumnos = new HashSet<>();  // Un módulo tiene varios alumnos

    @OneToMany(mappedBy = "modulo")  // Relación con las notas
    private Set<Nota> notas;
}
