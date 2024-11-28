import java.net.*;

public class Ejer6Servidor {
    public static void main(String[] args) {
        DatagramSocket servidorSocket = null;
        int puertoDeEscucha = 5000;

        try {
            servidorSocket = new DatagramSocket(puertoDeEscucha);
            System.out.println("Servidor en puerto " + puertoDeEscucha);

            byte[] datosRecibidos = new byte[1024];
            DatagramPacket paqueteDeEntrada = new DatagramPacket(datosRecibidos, datosRecibidos.length);

            while (true) {
                servidorSocket.receive(paqueteDeEntrada);
                String mensajeCliente = new String(paqueteDeEntrada.getData(), 0, paqueteDeEntrada.getLength());
                System.out.println("Cliente envió: " + mensajeCliente);

                if ("*".equals(mensajeCliente)) {
                    System.out.println("Byee...");
                    break;
                }

                String respuestaServidor = mensajeCliente.toUpperCase();

                InetAddress direccionCliente = paqueteDeEntrada.getAddress();
                int puertoCliente = paqueteDeEntrada.getPort();
                DatagramPacket paqueteDeSalida = new DatagramPacket(respuestaServidor.getBytes(), respuestaServidor.length(), direccionCliente, puertoCliente);
                servidorSocket.send(paqueteDeSalida);
            }
            servidorSocket.close();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
