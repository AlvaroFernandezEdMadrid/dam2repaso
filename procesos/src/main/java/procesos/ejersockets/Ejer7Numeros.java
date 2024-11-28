import java.io.Serializable;

public class Ejer7Numeros implements Serializable {
    private int valor;
    private long cuadradoValor;
    private long cuboValor;

    public NumeroCalculado(int valor) {
        this.valor = valor;
        calcularPoderes();
    }

    public NumeroCalculado() {
        this.valor = 0;
        this.cuadradoValor = 0;
        this.cuboValor = 0;
    }

    private void calcularPoderes() {
        this.cuadradoValor = (long) valor * valor;
        this.cuboValor = (long) valor * valor * valor;
    }

    public int obtenerValor() {
        return valor;
    }

    public void asignarValor(int valor) {
        this.valor = valor;
        calcularPoderes();
    }

    public long obtenerCuadrado() {
        return cuadradoValor;
    }

    public void establecerCuadrado(long cuadrado) {
        this.cuadradoValor = cuadrado;
    }

    public long obtenerCubo() {
        return cuboValor;
    }

    public void establecerCubo(long cubo) {
        this.cuboValor = cubo;
    }

    @Override
    public String toString() {
        return "Valor: " + valor + ", Cuadrado: " + cuadradoValor + ", Cubo: " + cuboValor;
    }
}
