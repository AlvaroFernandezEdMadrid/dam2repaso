package ejercicioCartelera;

import java.time.LocalDate;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import ejemploJAXB.LocalDateAdapter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@XmlType (propOrder = { "codigo", "duracion", "fecha", "titulo", "tituloOriginal","nacionalidad","edad","sinopsis","director","reparto","web","cartel"}) 
@XmlAccessorType(XmlAccessType.FIELD)
public class Pelicula {
	@EqualsAndHashCode.Include
	@NonNull
	@XmlAttribute
	private String codigo;
	@XmlAttribute
	private int duracion;
	@XmlAttribute
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	private LocalDate fecha;
	private String titulo;
	private String tituloOriginal;
	private String nacionalidad;
	private Clasificacion edad;
	private String sinopsis;
	private String director;
	private Set<String> reparto;
	private String web;
	private String cartel;
}
