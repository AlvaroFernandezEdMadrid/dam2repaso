import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Ejer8Cliente {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        Scanner entradaUsuario = new Scanner(System.in);
        int puertoServidor = 5000;
        String direccionServidor = "localhost";

        try {
            socket = new DatagramSocket();
            System.out.print("Nombre: ");
            String nombreCompleto = entradaUsuario.nextLine();
            System.out.print("Edad: ");
            int edad = entradaUsuario.nextInt();
            entradaUsuario.nextLine(); 
            Usuario usuario = new Usuario(nombreCompleto, edad);
            System.out.println("Enviando: " + usuario);

            ByteArrayOutputStream salidaBytes = new ByteArrayOutputStream();
            ObjectOutputStream flujoSalida = new ObjectOutputStream(salidaBytes);
            flujoSalida.writeObject(usuario);
            byte[] datosParaEnvio = salidaBytes.toByteArray();

            DatagramPacket paqueteEnvio = new DatagramPacket(datosParaEnvio, datosParaEnvio.length,
                    InetAddress.getByName(direccionServidor), puertoServidor);
            socket.send(paqueteEnvio);

            byte[] bufferRespuesta = new byte[1024];
            DatagramPacket paqueteRecibido = new DatagramPacket(bufferRespuesta, bufferRespuesta.length);
            socket.receive(paqueteRecibido);

            ByteArrayInputStream entradaBytes = new ByteArrayInputStream(paqueteRecibido.getData());
            ObjectInputStream flujoEntrada = new ObjectInputStream(entradaBytes);
            Usuario usuarioModificado = (Usuario) flujoEntrada.readObject();

            System.out.println("Respuesta: " + usuarioModificado);

            flujoSalida.close();
            flujoEntrada.close();
            socket.close();
            entradaUsuario.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } 
    }
}
