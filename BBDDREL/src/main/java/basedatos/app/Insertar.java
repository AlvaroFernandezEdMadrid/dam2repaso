package basedatos.app;

import basedatos.DepartDAO;
import basedatos.Service;
import basedatos.unidirecional1an.ControladorDepart;

public class Insertar implements Service {

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		ControladorDepart controladorDepart = new ControladorDepart();
		DepartDAO dao = new DepartDAO ();
		
		// Insertar Departamento
		controladorDepart.leerModelo();
		if (dao.save(controladorDepart.getModelo()) > 0)
			System.out.println("Departamento insertado correctamente");
		else
			System.out.println("Error insertando departamento");

	}

}
