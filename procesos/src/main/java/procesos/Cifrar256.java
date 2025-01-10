package procesos;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Cifrar256 {
    
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner scanner = new Scanner(System.in);

        // Solicitar las tres cadenas de texto
        System.out.println("Introduce la primera cadena de texto:");
        String cadena1 = scanner.nextLine();
        
        System.out.println("Introduce la segunda cadena de texto:");
        String cadena2 = scanner.nextLine();
        
        System.out.println("Introduce la cadena para cifrar las otras dos (clave):");
        String clave = scanner.nextLine();

        // Cifrar las dos cadenas usando SHA-256 con la clave
        String hash1 = cifrar(cadena1 + clave);
        String hash2 = cifrar(cadena2 + clave);
        
        // Mostrar los resultados
        System.out.println("\nHash de la primera cadena: " + hash1);
        System.out.println("Hash de la segunda cadena: " + hash2);
        
        // Comparar si los hashes son iguales
        if (hash1.equals(hash2)) {
            System.out.println("Los hashes son IGUALES.");
        } else {
            System.out.println("Los hashes son DIFERENTES.");
        }

        scanner.close();
    }
    
    public static String cifrar(String texto) throws NoSuchAlgorithmException {
    	MessageDigest md = MessageDigest.getInstance("SHA-256");
        
        byte[] hash = md.digest(texto.getBytes());
        
        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        
        return sb.toString();
    }
}
