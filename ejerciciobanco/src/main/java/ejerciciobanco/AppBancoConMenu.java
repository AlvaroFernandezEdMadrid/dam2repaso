package ejerciciobanco;


import ejerciciobanco.acciones.CargarDatos;
import ejerciciobanco.acciones.CrearCuenta;
import ejerciciobanco.acciones.HacerTransferencia;
import ejerciciobanco.acciones.IngresarDinero;
import ejerciciobanco.acciones.ListarDatos;
import ejerciciobanco.acciones.RealizarQuerys;
import utilidadesmenu.*;

public class AppBancoConMenu extends AppMenu{

	public AppBancoConMenu ()
	{
		// Cargar opciones de menú
		addOpcion (new MenuItem("Crear Cuenta", 1, new CrearCuenta()));
		addOpcion (new MenuItem("Ingresar dinero", 2, new IngresarDinero()));
		addOpcion (new MenuItem("Realizar transferencia", 4, new HacerTransferencia()));
		addOpcion (new MenuItem("Realizar consultas", 6, new RealizarQuerys()));
		addOpcion (new MenuItem("Cargar datos de prueba", 7, new CargarDatos()));
		addOpcion (new MenuItem("Listar datos de prueba", 8, new ListarDatos()));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppBancoConMenu app = new AppBancoConMenu ();
		app.run();

	}

}
