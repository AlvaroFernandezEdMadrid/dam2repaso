import java.net.*;
import java.io.*;

public class Ejer3Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(5000);
            System.out.println("Servidor iniciado...");

            Socket clienteSocket = servidor.accept();
            System.out.println("Cliente conectado desde: " + clienteSocket.getInetAddress().getHostAddress());

            BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
            PrintWriter salida = new PrintWriter(clienteSocket.getOutputStream(), true);

            String mensaje = "SOY EL MENSAJE";
            salida.println(mensaje);
            System.out.println("Mensaje enviado al cliente: " + mensaje);

            String respuesta = entrada.readLine();
            System.out.println("Respuesta del cliente: " + respuesta);

            entrada.close();
            salida.close();
            clienteSocket.close();
            servidor.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

