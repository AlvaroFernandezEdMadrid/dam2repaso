package ejercicioinsti;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import ejercicioinsti.modelo.Direccion;
import ejercicioinsti.modelo.Email;
import ejercicioinsti.modelo.Estudiante;
import ejercicioinsti.modelo.Instituto;
import ejercicioinsti.modelo.Persona;
import ejercicioinsti.modelo.Profesor;
import ejercicioinsti.modelo.TipoEstudio;
import utilidadeshibernate.GenericJPADAO;

public class App {
	
	private GenericJPADAO<Instituto, String> institutoDAO;
	private GenericJPADAO<Persona, String> personaDAO;
	private final static String UNIDADPERSISTENCIA="instituto";

	public static void main(String[] args) {
		 App app=new App();
		 
		 app.cargarDatos();
		 

	}

	private void cargarDatos() {
		
		Instituto insti;
		Estudiante e1, e2;
		Set<Estudiante> estudiantes=new HashSet<Estudiante>();
		Email m1, m2, m3, m4;
		Profesor p1, p2;
		Set<Profesor> profesores =new HashSet<Profesor>();
		
		insti=Instituto.builder().
				codCentro("001").
				direccion(new Direccion(001, "C/ Villablanca", "Madrid", "28032")).
				nombre("IES Villablanca").
				telefono("917777777").build();
		
		m1=Email.builder().
				id(001).
				tipo("trabajo").
				direccion("ale@trb.es").build();
		
		m2=Email.builder().
				id(002).
				tipo("trabajo").
				direccion("ped@trb.es").build();
		
		m3=Email.builder().
				id(003).
				tipo("personal").
				direccion("jn@per.es").build();
		
		m4=Email.builder().
				id(004).
				tipo("personal").
				direccion("mig@per.es").build();
		
		e1=Estudiante.builder().
				nombre("Alejandro").
				nif("001").
				fechaNac(LocalDate.of(2004, 03, 11)).
				poblacion("Madrid").
				email(new ArrayList<Email>()).
				curso("2").
				grupo("3").
				delegado(true).
				tipoEstudio(TipoEstudio.ESO).build();
		
		e2=Estudiante.builder().
				nombre("Pedro").
				nif("004").
				fechaNac(LocalDate.of(2001, 02, 13)).
				poblacion("Madrid").
				email(new ArrayList<Email>()).
				curso("2").
				grupo("1").
				delegado(false).
				tipoEstudio(TipoEstudio.FPGS).build();
		
		e1.getEmail().add(m1);
		e2.getEmail().add(m2);
		
		p1=Profesor.builder().
				nombre("Juan").
				nif("054").
				fechaNac(LocalDate.of(1979, 01, 10)).
				poblacion("Segovia").
				email(new ArrayList<Email>()).
				departamento("Informatica").
				despacho("22").build();
		
		p2=Profesor.builder().
				nombre("Miguel").
				nif("0094").
				fechaNac(LocalDate.of(2001, 07, 30)).
				poblacion("Lugo").
				email(new ArrayList<Email>()).
				departamento("Lengua").
				despacho("3").build();
		
		p1.getEmail().add(m3);
		p2.getEmail().add(m4);
		
		e1.setTutor(p2);
		e2.setTutor(p2);
		
		p2.setTutorandos(estudiantes);
		
		profesores.add(p1);
		profesores.add(p2);
		
		estudiantes.add(e1);
		estudiantes.add(e2);
		
		insti.setEstudiantes(estudiantes);
		insti.setProfesores(profesores);
	}

}
