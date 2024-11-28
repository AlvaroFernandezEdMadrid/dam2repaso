import java.net.*;
import java.util.Scanner;

public class Ejer6_1_Cliente {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        Scanner scanner = new Scanner(System.in);
        
        try {
            socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 5000;

            while (true) {
                System.out.print("Introduce un mensaje: ");
                String message = scanner.nextLine();

                if (message.equals("*")) {
                    socket.send(new DatagramPacket(message.getBytes(), message.length(), serverAddress, serverPort));
                    break;
                }

                DatagramPacket sendPacket = new DatagramPacket(message.getBytes(), message.length(), serverAddress, serverPort);
                socket.send(sendPacket);

                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);

                String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Respuesta: " + receivedMessage);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
            scanner.close();
        }
    }
}
