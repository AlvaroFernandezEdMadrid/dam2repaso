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
        this.nombreProducto = nombreProducto;
        this.propietario = propietario;
        this.abierta = true;
        this.pujas = new ArrayList<Puja>();
    }

    public boolean pujar(Usuario pujador, float cant) {
    
        boolean aceptada = false;
        
        if (isAbierta() 
            && !pujador.getNombre().equalsIgnoreCase(propietario.getNombre()) 
            && pujador.getCredito() >= cant
            && (getPujaMayor() == null || getPujaMayor().getCantidad() < cant)) {
            
        	aceptada = true; 
        	
            Puja nuevaPuja = new Puja(pujador, cant, this);
            pujas.add(nuevaPuja); 
            
        }
        
        return aceptada; 
    }

    
    public boolean pujar(Usuario pujador) {
        float cantidadPuja = (getPujaMayor() == null) ? 1 : getPujaMayor().getCantidad() + 1;
        return pujar(pujador, cantidadPuja);
    }

    private void cerrarSubasta() {
        setAbierta(false);
    }

    public void ejecutar() {
        if (isAbierta()) {
            Puja pujaGanadora = getPujaMayor();
            if (pujaGanadora != null) {
                
                pujaGanadora.getPujador().decrementarCredito(pujaGanadora.getCantidad());
                cerrarSubasta();
            }
        }
    }

    public Puja getPujaMayor() {
        return pujas.stream()
                .max((a, b) -> Float.compare(a.getCantidad(), b.getCantidad()))
                .orElse(null);
    }
}
