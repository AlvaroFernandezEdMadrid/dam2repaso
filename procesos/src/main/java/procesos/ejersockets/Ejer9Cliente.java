import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Ejer9Cliente {
    public static void main(String[] args) {
        DatagramSocket socketCliente = null;
        Scanner lector = new Scanner(System.in);
        int puertoDestino = 5000;
        String hostServidor = "localhost"; 

        try {
            socketCliente = new DatagramSocket();
            System.out.print("Introduce el nombre: ");
            String nombreCompleto = lector.nextLine();
            System.out.print("Introduce la edad: ");
            int edad = lector.nextInt();
            lector.nextLine();  // Limpiar el buffer de entrada
            Usuario usuario = new Usuario(nombreCompleto, edad);
            System.out.println("Cliente: " + usuario);

            ByteArrayOutputStream flujoSalidaBytes = new ByteArrayOutputStream();
            ObjectOutputStream flujoSalidaObjetos = new ObjectOutputStream(flujoSalidaBytes);
            flujoSalidaObjetos.writeObject(usuario);
            byte[] datosParaEnvio = flujoSalidaBytes.toByteArray();

            DatagramPacket paqueteEnvio = new DatagramPacket(datosParaEnvio, datosParaEnvio.length,
                    InetAddress.getByName(hostServidor), puertoDestino);
            socketCliente.send(paqueteEnvio);

            byte[] bufferRecibido = new byte[1024];
            DatagramPacket paqueteRespuesta = new DatagramPacket(bufferRecibido, bufferRecibido.length);
            socketCliente.receive(paqueteRespuesta);

            ByteArrayInputStream flujoEntradaBytes = new ByteArrayInputStream(paqueteRespuesta.getData());
            ObjectInputStream flujoEntradaObjetos = new ObjectInputStream(flujoEntradaBytes);
            Usuario usuarioModificado = (Usuario) flujoEntradaObjetos.readObject();

            System.out.println("Cliente: " + usuarioModificado);

            flujoSalidaObjetos.close();
            flujoEntradaObjetos.close();
            socketCliente.close();
            lector.close();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
