package manejoJSON.primero;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name="personas")
@XmlType (propOrder = { "personas"})
@XmlAccessorType(XmlAccessType.FIELD) 
public class PersonaWrapper {
	
	@XmlElement(name="persona")
	private List<Persona> personas;
}
