package ejercicioinsti.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
	
	private TipoEstudio tipoEstudio;
	
	public void setCurso(String c){
		if (tipoEstudio.isCursoValido(Integer.valueOf(c))) {
			this.curso=c;
		}else
			this.curso="1";
	}
	
}
