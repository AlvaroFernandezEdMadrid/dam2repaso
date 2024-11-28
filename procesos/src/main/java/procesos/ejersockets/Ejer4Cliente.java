import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Ejer4Cliente {
    public static void main(String[] args) {
        try {
            String servidorIP = "localhost";
            int puerto = 5000;

            Socket socketCliente = new Socket(servidorIP, puerto);
            System.out.println("Conectado al servidor: " + servidorIP + " en el puerto " + puerto);

            BufferedReader entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            PrintWriter salida = new PrintWriter(socketCliente.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduce un numero: ");
            int numero = scanner.nextInt();

            salida.println(numero);
            System.out.println("Numero enviado: " + numero);

            String respuesta = entrada.readLine();
            System.out.println("El cuadrado es: " + respuesta);

            entrada.close();
            salida.close();
            socketCliente.close();
            scanner.close();
            
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

