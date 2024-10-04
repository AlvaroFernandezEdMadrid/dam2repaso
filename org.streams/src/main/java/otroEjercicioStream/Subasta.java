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
        this.pujas = new ArrayList<>();
    }

    public boolean pujar(Usuario pujador, float cantidad) {
    
        boolean aceptada = false;
        
        if (isAbierta() 
            && !pujador.getNombre().equalsIgnoreCase(propietario.getNombre()) 
            && pujador.getCredito() >= cantidad 
            && (getPujaMayor() == null || getPujaMayor().getCantidad() < cantidad)) {
            
            
            Puja nuevaPuja = new Puja(pujador, cantidad, this);
            pujas.add(nuevaPuja); 
            pujador.decrementarCredito(cantidad); 
            aceptada = true; 
        }
        
        return aceptada; 
    }

    
    public void pujar(Usuario pujador) {
        float cantidadPuja = (getPujaMayor() == null) ? 1 : getPujaMayor().getCantidad() + 1;
        pujar(pujador, cantidadPuja);
    }

    public void cerrarSubasta() {
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
