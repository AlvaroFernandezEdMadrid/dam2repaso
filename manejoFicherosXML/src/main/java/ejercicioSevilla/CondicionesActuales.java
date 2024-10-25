package ejercicioSevilla;

import java.time.LocalTime;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"ultimaObservacion","temperatura","sensacionTermica","condiciones",
		"icono","viento","precipitacion","presion",
		"humedad","visibilidad","indice_ultravioleta","punto_rocio"})
public class CondicionesActuales {
	@XmlJavaTypeAdapter(LocalTimeAdapter.class)
	private LocalTime ultimaObservacion;
	private int temperatura;
	@XmlElement(name = "sensacion_termica")
	private int sensacionTermica;
	private String condiciones;
	private String icono;
	private Viento viento;
	private float precipitacion;
	private int presion;
	private int humedad;
	private float visibilidad;
	@XmlElement(name = "indice_ultravioleta")
	private int indiceUltravioleta;
	@XmlElement(name = "punto_rocio")
	private int puntoRocio;
}
