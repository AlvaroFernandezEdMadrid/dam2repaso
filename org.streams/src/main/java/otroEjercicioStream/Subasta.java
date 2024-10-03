package otroEjercicioStream;

import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.PRIVATE)
public class Subasta {
	private String nombreProducto;
	private Usuario propietario;
	private boolean abierta;
	private List<Puja> pujas;
	
	public Subasta(String nombreProducto, Usuario propietario) {
		this.nombreProducto=nombreProducto;
		this.propietario=propietario;
		this.abierta=true;
		this.pujas=new ArrayList<Puja>();
	}
	
	public boolean isAceptada(){
		return false;
	}
	
	public Puja getPujaMayor() {
		
	}
	
}
