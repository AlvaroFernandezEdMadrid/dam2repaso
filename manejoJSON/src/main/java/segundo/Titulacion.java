package segundo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import ejemploLeerEscribirJSON.LocalDateAdapter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"id", "mcer","nivel","idAlumno",
		"titulo","horario","inicioImparticion",
		"finImparticion","horas","url","tipoFormacion",
		"ects","categoria","profesorado"})
public class Titulacion {
	@XmlElement(name = "$id")
	private String id;
	@XmlElement(name = "MCER")
	private String mcer;
	@XmlElement(name = "Nivel")
	private String nivel;
	@XmlElement(name = "ID")
	private String idAlumno;
	@XmlElement(name = "Titulo")
	private String titulo;
	@XmlElement(name = "Horario")
	private String horario;
	@XmlJavaTypeAdapter(LocalDateTimeAdapterX.class)
	@XmlElement(name = "InicioImparticion")
	private LocalDateAdapter inicioImparticion;
	@XmlJavaTypeAdapter(LocalDateTimeAdapterX.class)
	@XmlElement(name = "FinImparticion")
	private LocalDateAdapter finImparticion;
	@XmlElement(name = "Horas")
	private int horas;
	@XmlElement(name = "URL")
	private String url;
	@XmlJavaTypeAdapter(TipoFormacionAdapterX.class)
	@XmlElement(name = "TipoFormacion")
	private TipoFormacion tipoFormacion;
	@XmlElement(name = "ECTS")
	private String ects;
	@XmlElement(name = "Categoria")
	private String categoria;
	@XmlElement(name = "Profesorado")
	private List<Profesor> profesorado;
	
}
