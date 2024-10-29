package segundo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import ejemploLeerEscribirJSON.LocalDateAdapter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@XmlAccessorType(XmlAccessType.FIELD)
public class Titulacion {
	@XmlElement(name = "$id")
	private String id;
	private String mcer;
	private String nivel;
	@XmlElement(name = "ID")
	private String idAlumno;
	private String titulo;
	private String horario;
	@XmlJavaTypeAdapter(LocalDateTimeAdapterX.class)
	private LocalDateAdapter inicioImparticion;
	@XmlJavaTypeAdapter(LocalDateTimeAdapterX.class)
	private LocalDateAdapter finImparticion;
	private int horas;
	private String url;
	@XmlJavaTypeAdapter(TipoFormacionAdapterX.class)
	private TipoFormacion tipoFormacion;
	private String ects;
	private String categoria;
	private List<Profesor> profesorado;
	
}
