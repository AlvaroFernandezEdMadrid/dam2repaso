import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Ejer6Cliente {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        Scanner entradaUsuario = new Scanner(System.in);
        int puertoDeServidor = 5000;

        try {
            socket = new DatagramSocket();
            socket.setSoTimeout(5000);
            while (true) {
                System.out.print("Mensaje: ");
                String mensajeUsuario = entradaUsuario.nextLine();
                if ("*".equals(mensajeUsuario)) {
                    break; //                }

                byte[] datos = mensajeUsuario.getBytes();
                InetAddress direccionServidor = InetAddress.getByName("localhost");
                DatagramPacket paqueteEnvio = new DatagramPacket(datos, datos.length, direccionServidor, puertoDeServidor);
                socket.send(paqueteEnvio);

                byte[] respuestaBytes = new byte[1024];
                DatagramPacket paqueteRecibido = new DatagramPacket(respuestaBytes, respuestaBytes.length);

                try {
                    socket.receive(paqueteRecibido);
                    String respuestaServidor = new String(paqueteRecibido.getData(), 0, paqueteRecibido.getLength());
                    System.out.println("Respuesta: " + respuestaServidor);
                } catch (SocketTimeoutException ex) {
                    System.out.println("Timeout.");
                }
            }
            socket.close();
            entradaUsuario.close();

        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
