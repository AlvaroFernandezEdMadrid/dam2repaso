package ejercicioRelacionesJPA;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.HashSet;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Alumno implements Serializable {

    @Id
    @Column(name = "ID_ALUMNO")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(name = "DNI", length = 9)
    private String dni;

    @Column(name = "NOMBRE", length = 30)
    private String nombre;

    @Column(name = "FECHA_NACIMIENTO", length = 30)
    private String fechaNacimiento;

    @ManyToOne
    @JoinColumn(name = "grupo_id")  // Relación con el grupo
    private Grupo grupo;

    @OneToOne(mappedBy = "alumno", cascade = CascadeType.PERSIST)  // Relación con la dirección
    private Direccion direccion;

    @OneToMany(mappedBy = "alumno")  // Relación con las notas de los módulos
    private Set<Nota> notas;

    @ManyToMany
    @JoinTable(
        name = "alumno_modulo", 
        joinColumns = @JoinColumn(name = "alumno_id"), 
        inverseJoinColumns = @JoinColumn(name = "modulo_id")
    )
    @Builder.Default  // Asegura que se inicialice con un HashSet vacío
    private Set<Modulo> modulos = new HashSet<Modulo>();  // Un alumno cursa varios módulos
}
