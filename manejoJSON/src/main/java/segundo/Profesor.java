package segundo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"id","nombreCompleto"})
public class Profesor {
	@EqualsAndHashCode.Include
	@XmlElement(name = "$id")
	private String id;
	@XmlElement(name = "NombreCompleto")
	private String nombreCompleto;
}
