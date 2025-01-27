package com.dam2.primerspring.servicio;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dam2.primerspring.modelo.Alumno;
@Service
@Qualifier(value = "otro")
public class ServicioAlumnoImplOtro implements IServicioAlumno {

	@Override
	public boolean insertar(Alumno a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar(Alumno a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean borrar(String nia) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Optional<Alumno> buscarPorClave(String nia) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Stream<Alumno> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int sumarUnPunto(int nota) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Optional<Float> calcularMedia() {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
