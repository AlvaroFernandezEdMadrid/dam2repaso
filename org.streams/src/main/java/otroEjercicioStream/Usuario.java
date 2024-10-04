package otroEjercicioStream;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.PRIVATE)
public class Usuario {
	private final float CREDITOBASE = 50;
	private String nombre;
	private float credito;

	public Usuario(String nombre, float credito) {
		this.nombre = nombre;
		setCredito(credito);
	}

	public Usuario(String nombre) {
		this.nombre = nombre;
		this.credito = CREDITOBASE;
	}

	private void setCredito(float credito) {
		if (credito < 0) {
			throw new IllegalArgumentException("\nNo se permiten valores negativos de credito");
		}
		this.credito = credito;
	}

	public void incrementarCredito(float cuanto) {
		if (cuanto >= 0) {
			this.credito += cuanto;
		}
	}

	public boolean decrementarCredito(float cuanto) {
		boolean exito = false; 

		if (cuanto >= 0) {
			if (credito >= cuanto) {
				credito -= cuanto; 
				exito = true;
			}
		}

		return exito;
	}
}
