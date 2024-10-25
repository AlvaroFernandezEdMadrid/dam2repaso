package ejercicioSevilla;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="tiempo")

@XmlType(propOrder= {"localizacion", "condicionesActuales", "pronosticoDias", "pronosticoHoras", "datosRegistrados"})
public class Tiempo {
	
	private Localizacion localizacion;
	@XmlElement(name="condiciones_actuales")
	private CondicionesActuales condicionesActuales;
	
	private Alertas alertas;
	@XmlElement(name = "pronostico_dias")
	private List<Dia> pronosticoDias;
	@XmlElement(name = "pronostico_horas")
	private List<Hora> pronosticoHoras;
	@XmlElement(name = "datos_registrados")
	private DatosRegistrados datosRegistrados;
}
