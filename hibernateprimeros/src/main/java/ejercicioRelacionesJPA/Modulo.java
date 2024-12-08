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
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "profesor_id")  // Relación con el profesor que imparte el módulo
    private Profesor profesor;

    @ManyToMany(mappedBy = "modulos")  // Relación con los alumnos (muchos a muchos)
    private Set<Alumno> alumnos;

    @OneToMany(mappedBy = "modulo")  // Relación con las notas
    private Set<Nota> notas;
}
