package segundo;

import java.util.Arrays;

public enum TipoFormacion {
	NOPRESENCIAL{public String toString() {return "NoPresencial";}},
	PRESENCIAL{public String toString() {return "Presencial";}},
	SEMIPRESENCIAL{public String toString() {return "Semipresencial";}};

	public static TipoFormacion crearFormacion (String valor)
	{
		return Arrays.stream(TipoFormacion.values()).
				filter(g -> g.toString().equalsIgnoreCase(valor)).
				findFirst().
				orElse(PRESENCIAL);
	}
}
