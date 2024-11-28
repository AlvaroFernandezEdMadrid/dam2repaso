import java.net.*;

public class Ejer6_1_Servidor {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(5000);
            System.out.println("Servidor up...");

            byte[] receiveData = new byte[1024];

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                
                if (message.equals("*")) {
                    System.out.println("Finalizando servidor...");
                    break;
                }

                String uppercaseMessage = message.toUpperCase();

                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                DatagramPacket sendPacket = new DatagramPacket(uppercaseMessage.getBytes(), uppercaseMessage.length(), clientAddress, clientPort);
                socket.send(sendPacket);

                System.out.println("Mensaje recibido: " + message);
                System.out.println("Mensaje enviado: " + uppercaseMessage);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}
