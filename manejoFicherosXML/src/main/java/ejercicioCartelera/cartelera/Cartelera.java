package ejercicioCartelera.cartelera;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

// usar los atributos de la clase en lugar de los gets
@XmlAccessorType(XmlAccessType.FIELD)
//Elemento raiz xml
@XmlRootElement
public class Cartelera {
	
	@Singular
	// No tiene contenedor
	//@XmlElementWrapper
	// Elementos del contenedor
	@XmlElement(name="pelicula")
	private List<Pelicula> peliculas;
	

}
