package ejercicioinsti.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

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
public class Profesor extends Persona {
	@Column(length = 20)
	private String departamento;
	@Column(length = 20)
	private String despacho;

	@OneToMany(mappedBy = "tutor", fetch = FetchType.LAZY)
	private Set<Estudiante> tutorandos;

	@Override
	public String toString() {
		List<String> tutorandosNif;

		if (tutorandos != null && tutorandos.size() > 0) {

			tutorandosNif = tutorandos.stream().map(e -> e.getNif()).toList();
		}else
			tutorandosNif=new ArrayList<String>();

		return "Profesor{" + "nif='" + getNif() + '\'' + ", departamento='" + departamento + '\'' + ", despacho='"
				+ despacho + '\'' + ", tutorandos='" + tutorandosNif;
	}
}
