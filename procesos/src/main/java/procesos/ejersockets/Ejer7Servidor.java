import java.io.*;
import java.net.*;

public class Ejer7Servidor {
    public static void main(String[] args) {
        ServerSocket socketServidor = null;
        Socket socketCliente = null;
        ObjectInputStream flujoEntrada = null;
        ObjectOutputStream flujoSalida = null;

        try {
            socketServidor = new ServerSocket(5000);
            System.out.println("Esperando conexion...");

            socketCliente = socketServidor.accept();
            System.out.println("Cliente conectado.");

            flujoEntrada = new ObjectInputStream(socketCliente.getInputStream());
            flujoSalida = new ObjectOutputStream(socketCliente.getOutputStream());
            flujoSalida.flush();  

            while (true) {
               
                Ejer7Numeros datosRecibidos = (Ejer7Numeros) flujoEntrada.readObject();
                int valor = datosRecibidos.obtenerValor();
                if (valor <= 0) {
                    System.out.println("Valor no valido.");
                    break;
                }
                datosRecibidos.asignarCuadrado((long) valor * valor);
                datosRecibidos.asignarCubo((long) valor * valor * valor);

                flujoSalida.writeObject(datosRecibidos);
            }
            flujoEntrada.close();
            flujoSalida.close();
            socketCliente.close();
            socketServidor.close();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
        } 
    }
}
