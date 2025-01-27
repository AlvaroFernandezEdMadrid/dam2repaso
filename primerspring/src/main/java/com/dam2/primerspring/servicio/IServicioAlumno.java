package com.dam2.primerspring.servicio;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.dam2.primerspring.modelo.Alumno;

public interface IServicioAlumno {
	
	boolean insertar(Alumno a);
	
	boolean actualizar (Alumno a);
	
	boolean borrar (String nia);
	
	Optional<Alumno> buscarPorClave(String nia);
	
	Stream<Alumno> buscarTodos ();
	
	int sumarUnPunto (int nota);
	
	Optional<Float> calcularMedia();
	
	
}
