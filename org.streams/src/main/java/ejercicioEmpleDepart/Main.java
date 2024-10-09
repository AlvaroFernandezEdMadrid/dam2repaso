package ejercicioEmpleDepart;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		List<Departamento> departamentos=cargarDatos();
		
		
		
		
	}
	
	public static List<Departamento> cargarDatos(){
		List<Departamento> departamentos;
		Departamento d1, d2, d3;
		Empleado e0, e1, e2, e3, e4, e5, e6, e7, e8, e9;
		
		e0=new Empleado("12345678A","Juan Pérez","M",LocalDate.parse("1985-04-15"),LocalDate.parse("2020-01-10"),3000.00f,500.00f,"Desarrollador",null);
		e1=new Empleado("23456789B","Ana García","F",LocalDate.parse("1990-07-22"),LocalDate.parse("2021-03-15"),2800.00f,450.00f,"Analista",new Empleado("12345678A"));
		e2=new Empleado("34567890C","Luis Rodríguez","M",LocalDate.parse("1980-11-30"),LocalDate.parse("2019-06-01"),3500.00f,600.00f,"Manager",null);
		e3=new Empleado("45678901D","Marta Sánchez","F",LocalDate.parse("1988-12-12"),LocalDate.parse("2022-05-20"),3200.00f,300.00f,"Tester",new Empleado("34567890C"));
		e4=new Empleado("56789012E","Carlos López","M",LocalDate.parse("1992-09-05"),LocalDate.parse("2023-01-15"),2700.00f,400.00f,"Soporte",new Empleado("45678901D"));
		e5=new Empleado("67890123F","Lucía Fernández","F",LocalDate.parse("1983-02-20"),LocalDate.parse("2021-10-30"),3400.00f,550.00f,"Consultor",new Empleado("34567890C"));
		e6=new Empleado("78901234G","Pedro Martín","M",LocalDate.parse("1995-06-18"),LocalDate.parse("2023-07-01"),2600.00f,350.00f,"Interno",new Empleado("67890123F"));
		e7=new Empleado("89012345H","Sofia Torres","F",LocalDate.parse("1984-03-30"),LocalDate.parse("2021-08-15"),3100.00f,450.00f,"Diseñadora",new Empleado("23456789B"));
		e8=new Empleado("90123456I","Javier Morales","M",LocalDate.parse("1989-10-05"),LocalDate.parse("2020-02-20"),2900.00f,500.00f,"Marketing",new Empleado("34567890C"));
		e9=new Empleado("01234567J","Elena Ruiz","F",LocalDate.parse("1982-05-12"),LocalDate.parse("2019-11-01"),3600.00f,600.00f,"Directora",null);
		
		
		d1=new Departamento("001", "Departamento 1", "Madrid");
		d2=new Departamento("002", "Departamento 2", "Barcelona");
		d3=new Departamento("003", "Departamento 3", "Sevilla");
		
		
		d1.addEmple(e0); d1.addEmple(e1); d1.addEmple(e2); d1.addEmple(e3);
		
		d2.addEmple(e4); d2.addEmple(e5); d2.addEmple(e6);

		d3.addEmple(e7); d3.addEmple(e8); d3.addEmple(e9);
		
		departamentos=new ArrayList<Departamento>();
		
		departamentos.add(d1);
		departamentos.add(d2);
		departamentos.add(d3);
		
		return departamentos;
		
	}
}
