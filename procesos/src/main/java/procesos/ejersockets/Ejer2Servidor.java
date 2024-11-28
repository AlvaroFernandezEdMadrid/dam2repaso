import java.net.*;
import java.io.*;

public class Ejer2Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(5000);
            System.out.println("Servidor iniciado...");

            Socket cliente1 = servidor.accept();
            mostrarInfoCliente(cliente1, 1);

            Socket cliente2 = servidor.accept();
            mostrarInfoCliente(cliente2, 2);

            servidor.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void mostrarInfoCliente(Socket cliente, int clienteNum) {
        try {
            InetAddress direccionRemota = cliente.getInetAddress();
            int puertoLocal = cliente.getLocalPort();
            int puertoRemoto = cliente.getPort();
            String ipRemota = direccionRemota.getHostAddress();
            
            System.out.println("Cliente " + clienteNum + ":");
            System.out.println("Direccion IP remota: " + ipRemota);
            System.out.println("Puerto local: " + puertoLocal);
            System.out.println("Puerto remoto: " + puertoRemoto);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
