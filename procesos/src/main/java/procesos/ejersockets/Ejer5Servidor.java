import java.io.*;
import java.net.*;

public class Ejer5Servidor {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);

		try (ServerSocket serverSocket = new ServerSocket(5000)) {
			System.out.println("Servidor esperando conexiones...");

			for (int i = 1; i <= n; i++) {
				Socket clientSocket = serverSocket.accept();
				System.out.println("Cliente " + i + " conectado");

				new Thread(new ClienteHandler(clientSocket, i)).start();
			}
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}

class ClienteHandler implements Runnable {
	private Socket socket;
	private int clientNumber;

	public ClienteHandler(Socket socket, int clientNumber) {
		this.socket = socket;
		this.clientNumber = clientNumber;
	}

	@Override
	public void run() {
		try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
			out.println("Cliente n: " + clientNumber);
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}