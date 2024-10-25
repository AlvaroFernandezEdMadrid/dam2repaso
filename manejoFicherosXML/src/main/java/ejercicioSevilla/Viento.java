package ejercicioSevilla;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"direccion", "value"})
public class Viento {
	@XmlAttribute
	private String direccion;
	private int value;
}
