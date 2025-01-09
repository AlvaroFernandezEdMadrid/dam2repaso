package ejerciciobanco.acciones;

import ejerciciobanco.modelo.Cliente;
import ejerciciobanco.modelo.Contacto;
import ejerciciobanco.modelo.Cuenta;
import utilidadeshibernate.GenericJPADAO;

public class AccionBanco {

	private final static String UNIDADPERSISTENCIA = "banco";
	protected static GenericJPADAO<Cliente,String> clienteDAO = new GenericJPADAO<Cliente,String> (Cliente.class,UNIDADPERSISTENCIA);
	protected static GenericJPADAO<Cuenta,String> cuentaDAO = new GenericJPADAO<Cuenta,String> (Cuenta.class,UNIDADPERSISTENCIA);
	protected GenericJPADAO<Contacto,String> contactoDAO = new GenericJPADAO<Contacto,String> (Contacto.class,UNIDADPERSISTENCIA);
	
	/*
	public AccionBanco ()
	{
		clienteDAO = new GenericJPADAO<Cliente,String> (Cliente.class,UNIDADPERSISTENCIA);
		cuentaDAO = new GenericJPADAO<Cuenta,String> (Cuenta.class,UNIDADPERSISTENCIA);

	}

	*/
}
