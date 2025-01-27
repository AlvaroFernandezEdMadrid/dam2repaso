package com.dam2.primerspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.dam2.primerspring.modelo.Alumno;
import com.dam2.primerspring.servicio.IServicioAlumno;

@Component
@Order(value = 2)
public class MiPrimeraApp implements CommandLineRunner {
	@Autowired
	@Qualifier("principal")
	IServicioAlumno servicioAlumno;
	@Override
	public void run(String... args) throws Exception {
		
		servicioAlumno.buscarPorClave("0055").ifPresentOrElse(System.out::println, ()->System.out.println("o existe"));
		
		servicioAlumno.buscarTodos().forEach(System.out::println);
		
	}

}
