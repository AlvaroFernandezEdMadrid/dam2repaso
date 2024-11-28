import java.net.*;
import java.io.*;

public class Ejer3Cliente {
    public static void main(String[] args) {
        try {
            String servidorIP = "localhost";
            int puerto = 5000;

            Socket socketCliente = new Socket(servidorIP, puerto);
            System.out.println("Conectado al servidor: " + servidorIP + " en el puerto " + puerto);

            BufferedReader entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            PrintWriter salida = new PrintWriter(socketCliente.getOutputStream(), true);

            String mensajeRecibido = entrada.readLine();
            System.out.println("Mensaje recibido del servidor: " + mensajeRecibido);

            String mensajeEnMinusculas = mensajeRecibido.toLowerCase();

            salida.println(mensajeEnMinusculas);
            System.out.println("Mensaje enviado al servidor: " + mensajeEnMinusculas);

            entrada.close();
            salida.close();
            socketCliente.close();
            
        } catch (IOException e) {
            System.err.println("Error en el cliente: " + e.getMessage());
        }
    }
}
