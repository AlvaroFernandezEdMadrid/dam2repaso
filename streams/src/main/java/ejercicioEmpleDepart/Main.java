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


		//CONSULTAS:

		// Consulta 1.
		System.out.println("\nTodos los empleados por orden alfabético:\n");
		
		departamentos.stream()
		.flatMap(d -> d.getEmpleados().stream())
		.sorted(Comparator.comparing(Empleado::getNombre))
		.collect(Collectors.toList()).forEach(ESCRIBIDOR);
		
		// Consulta 2.
		
		System.out.println("\nNombre y cargo de todos los empleados, ordenado por salario:\n");
		
		departamentos.stream()
        .flatMap(departamento -> departamento.getEmpleados().stream())
        .sorted(Comparator.comparingDouble(Empleado::getSalario))
        .map(empleado -> empleado.getNombre() + " - " + empleado.getCargo())
        .collect(Collectors.toList()).forEach(ESCRIBIDOR);
		
		// Consulta 3.
		
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
		
		
		// Consulta 4.
		
		System.out.println("\nTotal de sumar 500.000€ como bonificacion al sueldo de los empleados del departamento:\n");

		// Consulta 5.
		
		System.out.println("\nEmpleados que ganan una comisión superior a su sueldo:\n");
		departamentos.stream()
        .flatMap(departamento -> departamento.getEmpleados().stream()
            .filter(empleado -> empleado.getComision() > empleado.getSalario()))
        .collect(Collectors.toList())
        .forEach(ESCRIBIDOR);
		
		// Consulta 6.
		
		System.out.println("\nNombres de los departamentos que hay en cada ciudad:\n");
		
		// Consulta 7.
		
		System.out.println("\nEl salario más alto, el más bajo y la diferencia entre ellos:\n");
		
		// Consulta 8.
		
		System.out.println("\nNúmero de empleados de sexo femenino y de sexo masculino:\n");
		
		// Consulta 9.	
		
		System.out.println("\nNombre del departamento cuya suma de salarios sea la más alta, cantidad:\n");
		
		// Consulta 10.
		
		System.out.println("\nLista de empleados jefes, que tienen al menos un empleado:\n");
		
		// Consulta 11.
		
		System.out.println("\nSalario promedio por departamento\n");
		
		// Consulta 12.
		
		System.out.println("\nInformación de los empleados cuyo nombre tiene exactamente 11 caracteres:\n");
		
		// Consulta 13.
		
		System.out.println("\nTotal a pagar por comisiones, y el número de empleados que las reciben:\n");
		
		// Consulta 14.
		
		System.out.println("\nReajuste del 7%. Listar empleados con su nuevo salario. Indicar si tienen o no comision:\n");
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
