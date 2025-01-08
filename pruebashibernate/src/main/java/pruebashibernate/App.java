package pruebashibernate;

import utilidadeshibernate.GenericJPADAO;

public class App {
	
	static final String UNIDADPERSISTENCIA = "prueba1";
	private GenericJPADAO <Normal,String> normalDAO ;
	private GenericJPADAO <Tecnologo,String> tecnologoDAO ;
	private GenericJPADAO <Programador,String> programadorDAO ;
	private GenericJPADAO <Tester,String> testerDAO ;
	
	public App() {
		normalDAO = new GenericJPADAO(Normal.class,UNIDADPERSISTENCIA);
		tecnologoDAO = new GenericJPADAO(Tecnologo.class,UNIDADPERSISTENCIA);
		programadorDAO = new GenericJPADAO(Programador.class,UNIDADPERSISTENCIA);
		testerDAO = new GenericJPADAO(Tester.class,UNIDADPERSISTENCIA);
	}
	
	
	public static void main(String[] args) {
		
		App app = new App();
		
		app.cargarDatos();
		
		
	}


	private void cargarDatos() {
		
	}
}
