import java.net.*;
import java.io.*;

public class Ejer9Servidor {
    public static void main(String[] args) {
        DatagramSocket socketServidor = null;
        int puertoConexion = 5000; 

        try {
            socketServidor = new DatagramSocket(puertoConexion);
            System.out.println("Servidor UP en puerto " + puertoConexion);

            byte[] bufferDatos = new byte[1024];
            DatagramPacket paqueteDeEntrada = new DatagramPacket(bufferDatos, bufferDatos.length);

            socketServidor.receive(paqueteDeEntrada);
            ByteArrayInputStream flujoEntradaBytes = new ByteArrayInputStream(paqueteDeEntrada.getData());
            ObjectInputStream flujoEntradaObjetos = new ObjectInputStream(flujoEntradaBytes);
            Usuario usuarioRecibido = (Usuario) flujoEntradaObjetos.readObject();
            System.out.println("Servidor: " + usuarioRecibido);

            usuarioRecibido.setNombre(usuarioRecibido.getNombre().toUpperCase());
            usuarioRecibido.setEdad(usuarioRecibido.getEdad() + 1);
            System.out.println("Servidor: " + usuarioRecibido);

            ByteArrayOutputStream flujoSalidaBytes = new ByteArrayOutputStream();
            ObjectOutputStream flujoSalidaObjetos = new ObjectOutputStream(flujoSalidaBytes);
            flujoSalidaObjetos.writeObject(usuarioRecibido);
            byte[] datosParaEnviar = flujoSalidaBytes.toByteArray();

            DatagramPacket paqueteDeSalida = new DatagramPacket(datosParaEnviar, datosParaEnviar.length,
                    paqueteDeEntrada.getAddress(), paqueteDeEntrada.getPort());
            socketServidor.send(paqueteDeSalida);

            flujoEntradaObjetos.close();
            flujoSalidaObjetos.close();
            socketServidor.close();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } 
    }
}
