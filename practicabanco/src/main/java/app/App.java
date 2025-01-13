package app;

import practicabanco.modelo.Cliente;
import practicabanco.modelo.ClienteCuenta;
import practicabanco.modelo.Cuenta;
import practicabanco.modelo.CuentaEmpresa;
import practicabanco.modelo.CuentaPersonal;
import practicabanco.modelo.Telefono;
import utilidadeshibernate.GenericJPADAO;

public class App {

	private GenericJPADAO<Cuenta, String> cuentaDAO;
	private GenericJPADAO<Cliente, String> clienteDAO;
	private GenericJPADAO<ClienteCuenta, String> clienteCuentaDAO;
	private final static String UNIDADPERSISTENCIA = "banco1";

	private App() {
		cuentaDAO = new GenericJPADAO<Cuenta, String>(Cuenta.class, UNIDADPERSISTENCIA);
		clienteDAO = new GenericJPADAO<Cliente, String>(Cliente.class, UNIDADPERSISTENCIA);
		clienteCuentaDAO = new GenericJPADAO<ClienteCuenta, String>(ClienteCuenta.class, UNIDADPERSISTENCIA);
	}

	public static void main(String[] args) {
		App app = new App();
		app.cargarDatos();
	}

	private void cargarDatos() {
		Cliente cl1, cl2, cl3;

		Cuenta cu1, cu2, cu3, cu4;

		ClienteCuenta clcu1;

		cl1 = Cliente.builder().nif("001").nombre("Paco").aval(100000).telefono(new Telefono("616616616", "Orange"))
				.telefono(new Telefono("666999444", "Vodafone")).telefono(new Telefono("666777888", "DIGI")).build();

		cl2 = Cliente.builder().nif("002").nombre("Francisco").aval(10069002)
				.telefono(new Telefono("616616852", "Movistar")).telefono(new Telefono("666659444", "O2"))
				.telefono(new Telefono("669997888", "Jazztel")).build();

		cl3 = Cliente.builder().nif("003").nombre("Emilio").aval(100000)
				.telefono(new Telefono("616952616", "PepePhone")).telefono(new Telefono("663499444", "MasMovil"))
				.telefono(new Telefono("666766688", "Amena")).build();

		cu1 = CuentaEmpresa.builder().numero("0010").saldo(22002250.56f).nombreEmpresa("Recreativos Franco")
				.cif("00215").localPropio(true).build();

		cu2 = CuentaEmpresa.builder().numero("21325").saldo(565565.69f).nombreEmpresa("Recreativas Pocholo").cif("0105")
				.localPropio(false).build();

		cu3 = CuentaPersonal.builder().numero("223488").saldo(11000.65f).tarjeta(true).build();

		cu4 = CuentaPersonal.builder().numero("545645").saldo(100.01f).tarjeta(false).build();
		
		clcu1= ClienteCuenta.builder().
				id("001").
				clienteId(cl1).
				cuentaId(cu1).build();
		
		clienteDAO.save(cl1);
		clienteDAO.save(cl2);
		clienteDAO.save(cl3);
		
		cuentaDAO.save(cu1);
		cuentaDAO.save(cu2);
		cuentaDAO.save(cu3);
		cuentaDAO.save(cu4);
		
		clienteCuentaDAO.save(clcu1);
	}
}
