import java.io.Serializable;

public class Ejer8Persona implements Serializable {
    private String nombreCompleto;
    private int edad;

    public Usuario(String nombreCompleto, int edad) {
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
    }

    public String obtenerNombre() {
        return nombreCompleto;
    }

    public void establecerNombre(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int obtenerEdad() {
        return edad;
    }

    public void establecerEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Usuario{nombre='" + nombreCompleto + "', edad=" + edad + "}";
    }
}
