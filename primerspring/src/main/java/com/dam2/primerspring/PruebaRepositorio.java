package com.dam2.primerspring;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.dam2.primerspring.modelo.Alumno;
import com.dam2.primerspring.repositorio.AlumnoRepositorio;


public class PruebaRepositorio implements CommandLineRunner {

	@Autowired
	private AlumnoRepositorio alumnoDAO;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Hola Mundo");
		Alumno a = Alumno.builder()
				.nia("001")
				.nombre("Paco")
				.nota(4)
				.fecha(LocalDate.now())
				.build();
		
		alumnoDAO.save(a);
		
		alumnoDAO.subirPunto(4);
		
		//alumnoDAO.listadoAlumnos().forEach(ar -> System.out::println(ar));
		//alumnoDAO.findAll().forEach(System.out::println);
		//alumnoDAO.findByNota(10).forEach(System.out::println);
		
		//alumnoDAO.calcularMedia().ifPresentOrElse(System.out::println, null);;
	}

}
