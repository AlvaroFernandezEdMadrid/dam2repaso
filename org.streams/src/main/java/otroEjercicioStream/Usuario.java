package otroEjercicioStream;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
@Data
@Setter(AccessLevel.PRIVATE)
public class Usuario {
	private final float CREDITOBASE=50;
	private String nombre;
	private float credito;
	
	public Usuario(String nombre, float credito) {
		this.nombre = nombre;
		try {
			setCredito(credito);
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public Usuario(String nombre) {
		this.nombre=nombre;
		this.credito=CREDITOBASE;
	}
	
	private void setCredito(float credito) throws IllegalArgumentException{
		if (credito<0) {
			throw new IllegalArgumentException("\nNo se permiten valores negativos de credito");
		}
	}
	
	public void incrementarCredito(float cuanto) {
		try {
			setCredito(cuanto);
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public boolean decrementarCredito(float cuanto) {
		boolean exito=false;
		
		if (credito<0&&credito>cuanto) {
			exito=true;
			credito-=cuanto;
		}
		
		return exito;
	}
}
