import java.io.*;
import java.net.*;

public class Ejer5Cliente {
	public static void main(String[] args) {
		String serverAddress = "localhost";
		int serverPort = 5000;

		try (Socket socket = new Socket(serverAddress, serverPort);
				BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
			String message = input.readLine();
			System.out.println("Mensaje recibido: " + message);
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}


