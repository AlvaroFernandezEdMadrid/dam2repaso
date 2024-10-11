package ejercicioEmpleDepart;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import daw.com.Teclado;

public class Main {

	final static Consumer<Object> ESCRIBIDOR=System.out::println;

	public static void main(String[] args) {
		List<Departamento> departamentos=cargarDatos();


		//Consultas:

		// Obtener los datos completos de los todos los empleados por orden alfabético.
		System.out.println("\nTodos los empleados por orden alfabético:\n");
		
		departamentos.stream()
		.flatMap(d -> d.getEmpleados().stream())
		.sorted(Comparator.comparing(Empleado::getNombre))
		.collect(Collectors.toList()).forEach(ESCRIBIDOR);
		// Obtener el nombre y cargo de todos los empleados, ordenado por salario.
		System.out.println("\nNombre y cargo de todos los empleados, ordenado por salario:\n");
		
		departamentos.stream()
        .flatMap(departamento -> departamento.getEmpleados().stream())
        .sorted(Comparator.comparingDouble(Empleado::getSalario))
        .map(empleado -> empleado.getNombre() + " - " + empleado.getCargo())
        .collect(Collectors.toList()).forEach(ESCRIBIDOR);
		// Listar los salarios y comisiones de los empleados del departamento introducido por teclado.
		System.out.println("\nSalarios y comisiones de los empleados del departamento introducido:\n");
		System.out.println("\nElige un departamento:\n");
		String cual;
		List<String> nombresDep=departamentos.stream().map(a -> a.getNombre().toUpperCase()).collect(Collectors.toList());
		
		System.out.println(departamentos.stream().map(a -> a.getNombre().toUpperCase()).collect(Collectors.toList()));
		
		do {
			cual=Teclado.leerString("\nEleccion:\n").toUpperCase();
		} while (!nombresDep.contains(cual));
		
		String defCual=cual;
		
		departamentos.stream()
		.filter(a->a.getNombre()
				.equalsIgnoreCase(defCual))
		.flatMap(dp->dp.getEmpleados()
				.stream().map(s->s.getSalario() +" - "+ s.getComision()))
		.forEach(ESCRIBIDOR);
		
		
		/* Obtener el valor total a pagar que resulta de sumar a los empleados del departamento introducido por teclado, 
		 * una bonificación de 500000€, en orden alfabético del empleado.*/
		System.out.println("\n\n");

		// Obtener la lista de los empleados que ganan una comisión superior a su sueldo.
		System.out.println("\nEmpleados que ganan una comisión superior a su sueldo:\n");
		departamentos.stream()
        .flatMap(departamento -> departamento.getEmpleados().stream()
            .filter(empleado -> empleado.getComision() > empleado.getSalario()))
        .collect(Collectors.toList())
        .forEach(ESCRIBIDOR);
		// Obtener los nombres de los departamentos que hay en cada ciudad.
		System.out.println("\n\n");
		// Hallar el salario más alto, el más bajo y la diferencia entre ellos.
		System.out.println("\n\n");
		// Entregar el número de empleados de sexo femenino y de sexo masculino
		System.out.println("\n\n");
		// Entregar el nombre del departamento cuya suma de salarios sea la más alta, indicando el valor de la suma
		System.out.println("\n\n");
		// Obtener la lista de empleados jefes, que tienen al menos un empleado a su cargo
		System.out.println("\n\n");
		// Hallar el salario promedio por departamento.
		System.out.println("\n\n");
		// Obtener información de los empleados cuyo nombre tiene exactamente 11 caracteres.
		System.out.println("\n\n");
		// Entregar el total a pagar por comisiones, y el número de empleados que las reciben.
		System.out.println("\n\n");
		/* Suponer que la empresa va a aplicar un reajuste salarial del 7%. Listar los nombres de los
		 * empleados, su salario actual y su nuevo salario, indicando para cada uno de ellos si tiene o no comisión.*/
		System.out.println("\n\n");
	}

	public static List<Departamento> cargarDatos(){
		final Optional<Empleado> SINJEFE = Optional.empty();
		List <Departamento> departamentos = new ArrayList<>();
		Departamento departamento;
		Empleado empleado1,empleado2,empleado3;


		departamento = new Departamento ("001", "Comercial", "Madrid");
		empleado1 = new Empleado ("00001A","Miguel", false,
				LocalDate.of(1966, 7, 1),
				LocalDate.of(2000, 1, 20),
				34000,10000,"profe",
				SINJEFE);

		empleado2 = new Empleado ("00002B","Ana Rosa", true,
				LocalDate.of(1996, 8, 12),
				LocalDate.of(2004, 12, 20),
				24000,5000,"secretaria",
				empleado1);

		empleado3 = new Empleado ("00003C","Rodolfo", false,
				LocalDate.of(2002, 10, 1),
				LocalDate.of(2019, 9, 20),
				44000,15000,"jefe estudios",
				empleado1);

		departamento.addEmpleado(empleado1);
		departamento.addEmpleado(empleado2);
		departamento.addEmpleado(empleado3);
		departamentos.add(departamento);

		departamento = new Departamento ("002", "Marketing", "Pamplona");
		empleado1 = new Empleado ("00004D","Flora", true,
				LocalDate.of(1986, 4, 1),
				LocalDate.of(2010, 1, 20),
				34000,100000,"profe",
				SINJEFE);

		empleado2 = new Empleado ("00005E","Mary", true,
				LocalDate.of(1999, 4, 1),
				LocalDate.of(2004, 1, 20),
				44000,13000,"profe",
				empleado1);

		empleado3 = new Empleado ("00006F","Alfredo", false,
				LocalDate.of(1998, 7, 1),
				LocalDate.of(2018, 10, 20),
				34500,0,"profe mate",
				empleado1);

		departamento.addEmpleado(empleado1);
		departamento.addEmpleado(empleado2);
		departamento.addEmpleado(empleado3);
		departamentos.add(departamento);

		return departamentos;


	}
}
