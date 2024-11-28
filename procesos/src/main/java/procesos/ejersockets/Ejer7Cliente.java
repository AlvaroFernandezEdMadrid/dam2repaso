import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Ejer7Cliente {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        Socket conexion = null;
        ObjectOutputStream flujoSalida = null;
        ObjectInputStream flujoEntrada = null;

        try {
            conexion = new Socket("localhost", 5000);
            flujoSalida = new ObjectOutputStream(conexion.getOutputStream());
            flujoSalida.flush();

            flujoEntrada = new ObjectInputStream(conexion.getInputStream());
            while (true) {
                System.out.print("Ingresa un numero: ");
                int numeroIngresado = lector.nextInt();
                if (numeroIngresado == 0) {
                    break;
                }
                NumeroCalculado numeroCalculado = new NumeroCalculado(numeroIngresado);
                flujoSalida.writeObject(numeroCalculado);                
		NumeroCalculado respuestaDelServidor = (NumeroCalculado) flujoEntrada.readObject();
                System.out.println("Respuesta: " + respuestaDelServidor);
            }
            flujoEntrada.close();
            flujoSalida.close();
            conexion.close();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
