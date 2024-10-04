package otroEjercicioStream;

public class Main {

	public static void main(String[] args) {
		Usuario u1, u2, u3;
		Subasta subasta;

		u1 = new Usuario("Juan", 100);   
		u2 = new Usuario("Pedro", 150);  
		u3 = new Usuario("Enrique", 300); 

		subasta = new Subasta("Telefono Movil", u1);

		subasta.pujar(u2, 100);
		//subasta.pujar(u1, 101);
		subasta.pujar(u3, 102);
		
		subasta.getPujas().stream().forEach(a->System.out.println(a));

		 

		subasta.ejecutar();

		System.out.println(u1.getNombre() + " tiene " + u1.getCredito() + " euros.");
		System.out.println(u2.getNombre() + " tiene " + u2.getCredito() + " euros.");
		System.out.println(u3.getNombre() + " tiene " + u3.getCredito() + " euros.");

		
	}
}
