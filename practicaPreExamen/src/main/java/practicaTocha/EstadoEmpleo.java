package practicaTocha;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import com.google.gson.annotations.SerializedName;

@XmlEnum(String.class)
public enum EstadoEmpleo {
	@XmlEnumValue("Activo")
	@SerializedName("Activo")
	ACTIVO,
	@XmlEnumValue("Inactivo")
	@SerializedName("Inactivo")
	INACTIVO,
	@XmlEnumValue("Licencia")
	@SerializedName("Licencia")
	LICENCIA;
	
	public static EstadoEmpleo toEnum(String s) {
		return Arrays.stream(EstadoEmpleo.values())
				.filter(a->a.toString().equalsIgnoreCase(s))
				.findFirst()
				.orElse(ACTIVO);
	}
}
