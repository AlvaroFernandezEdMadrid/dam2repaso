import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ejer1 
{
	public static void main( String[] args )
	{
		String input = args[0];

		try {
			InetAddress address = InetAddress.getByName(input);

			System.out.println("Información de la máquina: " + input);
			System.out.println("Dirección IP: " + address.getHostAddress());
			System.out.println("Nombre completo de la máquina: " + address.getCanonicalHostName());
			System.out.println("Nombre del host: " + address.getHostName());

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
