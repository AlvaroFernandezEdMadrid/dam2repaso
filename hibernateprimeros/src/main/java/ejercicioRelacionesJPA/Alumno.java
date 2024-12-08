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
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dni;
    private String nombre;
    private String fechaNacimiento;

    @ManyToOne
    @JoinColumn(name = "grupo_id")  // Relación con el grupo
    private Grupo grupo;

    @OneToOne(mappedBy = "alumno")  // Relación con la dirección (un alumno tiene una dirección)
    private Direccion direccion;

    @OneToMany(mappedBy = "alumno")  // Relación con las notas de los módulos
    private Set<Nota> notas;

    @ManyToMany
    @JoinTable(
        name = "alumno_modulo", 
        joinColumns = @JoinColumn(name = "alumno_id"), 
        inverseJoinColumns = @JoinColumn(name = "modulo_id")
    )
    private Set<Modulo> modulos;  // Un alumno cursa varios módulos
}
