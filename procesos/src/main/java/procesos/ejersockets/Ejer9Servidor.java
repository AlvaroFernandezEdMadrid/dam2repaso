import java.net.*;
import java.io.*;

public class Ejer9Servidor {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        int puerto = 5000;

        try {
            
            socket = new DatagramSocket(puerto);
            System.out.println("Servidor UDP activo, esperando datos...");

            int numeroRecibido = Integer.MAX_VALUE;

            
            while (numeroRecibido > 0) {
                byte[] buffer = new byte[1024];
                DatagramPacket packetEntrada = new DatagramPacket(buffer, buffer.length);

                
                socket.receive(packetEntrada);
                ByteArrayInputStream entradaBytes = new ByteArrayInputStream(packetEntrada.getData());
                ObjectInputStream flujoEntrada = new ObjectInputStream(entradaBytes);

                
                Numeros datos = (Numeros) flujoEntrada.readObject();
                System.out.println("Datos recibidos: " + datos);

                numeroRecibido = datos.getNumero();

                
                if (numeroRecibido <= 0) {
                    System.out.println("Número no válido recibido, terminando servidor.");
                } else {
                    
                    datos.calcular();
                    System.out.println("Datos modificados: " + datos);

                    
                    ByteArrayOutputStream salidaBytes = new ByteArrayOutputStream();
                    ObjectOutputStream flujoSalida = new ObjectOutputStream(salidaBytes);
                    flujoSalida.writeObject(datos);
                    byte[] datosAEnviar = salidaBytes.toByteArray();

                    
                    DatagramPacket packetSalida = new DatagramPacket(datosAEnviar, datosAEnviar.length,
                            packetEntrada.getAddress(), packetEntrada.getPort());
                    socket.send(packetSalida);

                    flujoEntrada.close();
                    flujoSalida.close();
                }
            }

            
            socket.close();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
