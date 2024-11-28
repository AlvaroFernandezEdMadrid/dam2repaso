import java.net.*;
import java.io.*;

public class Ejer8Servidor {
    public static void main(String[] args) {
        DatagramSocket socketServidor = null;
        int puertoServidor = 5000;

        try {
            socketServidor = new DatagramSocket(puertoServidor);
            System.out.println("Servidor UP en :" + puertoServidor);

            byte[] bufferEntrada = new byte[1024];
            DatagramPacket paqueteEntrada = new DatagramPacket(bufferEntrada, bufferEntrada.length);
            socketServidor.receive(paqueteEntrada);

            ByteArrayInputStream byteStreamEntrada = new ByteArrayInputStream(paqueteEntrada.getData());
            ObjectInputStream flujoEntrada = new ObjectInputStream(byteStreamEntrada);
            Usuario usuarioRecibido = (Usuario) flujoEntrada.readObject();
            System.out.println("Servidor: " + usuarioRecibido);

            usuarioRecibido.establecerNombre(usuarioRecibido.obtenerNombre().toUpperCase());
            usuarioRecibido.establecerEdad(usuarioRecibido.obtenerEdad() + 1);
            System.out.println("Datos modificados: " + usuarioRecibido);

            ByteArrayOutputStream byteStreamSalida = new ByteArrayOutputStream();
            ObjectOutputStream flujoSalida = new ObjectOutputStream(byteStreamSalida);
            flujoSalida.writeObject(usuarioRecibido);
            byte[] datosSalida = byteStreamSalida.toByteArray();

            DatagramPacket paqueteRespuesta = new DatagramPacket(datosSalida, datosSalida.length,
                    paqueteEntrada.getAddress(), paqueteEntrada.getPort());
            socketServidor.send(paqueteRespuesta);

            flujoEntrada.close();
            flujoSalida.close();
            socketServidor.close();

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
