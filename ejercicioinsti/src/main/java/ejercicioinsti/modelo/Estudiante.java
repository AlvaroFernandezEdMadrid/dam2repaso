package ejercicioinsti.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Estudiante extends Persona {
	
	@Column(length = 10)
	private String curso;
	
	@Column(length = 10)
	private String grupo;
	
	private boolean delegado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tutor_id")
	private Profesor tutor;
	
	private TipoEstudio tipoEstudio;
	
	@Override
    public String toString() {
        return "Estudiante{" +
                "nif='" + getNif() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", curso='" + curso + '\'' +
                ", grupo='" + grupo + '\'' +
                ", delegado=" + delegado +
                ", tipoEstudi="+ tipoEstudio +
                ", tutorNif='" + (tutor != null ? tutor.getNif() : "No tiene tutor") + '\'' +  // Solo imprime el nif del tutor
                '}';
    }
}
