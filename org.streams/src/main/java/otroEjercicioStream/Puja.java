package otroEjercicioStream;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.PRIVATE)
public class Puja {
	private Usuario pujador;
	private float cantidad;
	private Subasta subasta;
	
	public Puja(Usuario pujador, float cantidad, Subasta subasta) {
		this.pujador=pujador;
		try {
			setCantidad(cantidad);
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
		this.subasta=subasta;
	}
	
	public void setCantidad(float cantidad) throws IllegalArgumentException{
		if (cantidad<0) {
			throw new IllegalArgumentException("\nNo se permiten valores negativos");
		}
	}
}
