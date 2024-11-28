import java.net.*;
import java.io.*;

public class Ejer4Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(5000);
            System.out.println("Servidor iniciado...");

            Socket clienteSocket = servidor.accept();
            System.out.println("Cliente conectado desde: " + clienteSocket.getInetAddress().getHostAddress());

            BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
            PrintWriter salida = new PrintWriter(clienteSocket.getOutputStream(), true);

            String mensaje = entrada.readLine();
            int numero = Integer.parseInt(mensaje);
            System.out.println("Numero del cliente: " + numero);

            int cuadrado = numero * numero;

            salida.println(cuadrado);
            System.out.println("Cuadrado enviado al cliente: " + cuadrado);

            entrada.close();
            salida.close();
            clienteSocket.close();
            servidor.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

