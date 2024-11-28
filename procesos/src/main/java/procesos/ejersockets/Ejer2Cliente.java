import java.net.*;
import java.io.*;

public class Ejer2Cliente {
    public static void main(String[] args) {
        try {
            String servidorIP = "localhost";
            int puerto = 5000;
            
            Socket socketCliente = new Socket(servidorIP, puerto);
            
            InetAddress direccionLocal = socketCliente.getLocalAddress();
            int puertoLocal = socketCliente.getLocalPort();
            InetAddress direccionRemota = socketCliente.getInetAddress();
            int puertoRemoto = socketCliente.getPort();
            
            System.out.println("Cliente conectado:");
            System.out.println("Direccion IP local: " + direccionLocal.getHostAddress());
            System.out.println("Puerto local: " + puertoLocal);
            System.out.println("Direccion IP remota: " + direccionRemota.getHostAddress());
            System.out.println("Puerto remoto: " + puertoRemoto);
            
            socketCliente.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
