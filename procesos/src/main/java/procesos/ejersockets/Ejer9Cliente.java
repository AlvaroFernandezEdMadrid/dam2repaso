import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Ejer9Cliente {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        Scanner inputScanner = new Scanner(System.in);
        int puertoServidor = 5000;
        String direccionServidor = "localhost";

        try {
            int numeroIngresado = Integer.MAX_VALUE;

            
            socket = new DatagramSocket();
            socket.setSoTimeout(5000);  

            
            while (numeroIngresado > 0) {
                System.out.print("Introduce un número mayor que 0, o 0 para salir: ");
                numeroIngresado = Integer.valueOf(inputScanner.nextLine());

                
                Numeros datosEnviados = new Numeros(numeroIngresado);
                System.out.println("Enviando: " + datosEnviados);

                
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeObject(datosEnviados);
                byte[] bufferEnvio = byteArrayOutputStream.toByteArray();

                
                DatagramPacket packetEnvio = new DatagramPacket(bufferEnvio, bufferEnvio.length,
                        InetAddress.getByName(direccionServidor), puertoServidor);
                socket.send(packetEnvio);

                
                byte[] bufferRecibido = new byte[1024];
                DatagramPacket packetRecibido = new DatagramPacket(bufferRecibido, bufferRecibido.length);
                socket.receive(packetRecibido);

                
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(packetRecibido.getData());
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                Numeros datosRespuesta = (Numeros) objectInputStream.readObject();

                System.out.println("Respuesta: " + datosRespuesta);

                
                objectOutputStream.close();
                objectInputStream.close();
            }

            
            socket.close();
            inputScanner.close();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
