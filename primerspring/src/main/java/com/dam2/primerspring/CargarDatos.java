package com.dam2.primerspring;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.dam2.primerspring.modelo.Alumno;
import com.dam2.primerspring.servicio.IServicioAlumno;
@Component
@Order(value = 1)
public class CargarDatos implements CommandLineRunner{
	@Autowired
	@Qualifier("otro")
	IServicioAlumno servicioAlumno;
	@Override
	public void run(String... args) throws Exception {
		Alumno a1 = Alumno.builder()
				.nia("0055")
				.nombre("Alberto")
				.nota(6)
				.fecha(LocalDate.now())
				.build();
		
		Alumno a2 = Alumno.builder()
				.nia("00322")
				.nombre("Ana")
				.nota(9)
				.fecha(LocalDate.now())
				.build();
		
		servicioAlumno.insertar(a1);
		servicioAlumno.insertar(a2);
		
	}

}
