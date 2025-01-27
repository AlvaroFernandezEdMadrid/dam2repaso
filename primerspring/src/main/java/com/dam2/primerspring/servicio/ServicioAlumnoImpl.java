package com.dam2.primerspring.servicio;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dam2.primerspring.modelo.Alumno;
import com.dam2.primerspring.repositorio.AlumnoRepositorio;
@Service
@Qualifier(value = "principal")
public class ServicioAlumnoImpl implements IServicioAlumno{

	@Autowired
	AlumnoRepositorio alumnoDAO;
	@Override
	public boolean insertar(Alumno a) {
		boolean exito=false;
		
		if (!alumnoDAO.existsById(a.getNia())) {
			alumnoDAO.save(a);
			exito=true;
		}
		
		return exito;
	}

	@Override
	public boolean actualizar(Alumno a) {
		boolean exito=false;
		
		if (alumnoDAO.existsById(a.getNia())) {
			alumnoDAO.save(a);
			exito=true;
		}
		
		return exito;
	}

	@Override
	public boolean borrar(String nia) {
		boolean exito=false;
		
		if (alumnoDAO.findById(nia) != null) {
			alumnoDAO.deleteById(nia);
			exito=true;
		}
		
		return exito;
	}

	@Override
	public Optional<Alumno> buscarPorClave(String nia) {
		
		return alumnoDAO.findById(nia);
	}

	@Override
	public Stream<Alumno> buscarTodos() {
		
		List<Alumno> alumnos = (List<Alumno>) alumnoDAO.findAll();
		
		return alumnos.stream();
	}

	@Override
	public int sumarUnPunto(int nota) {
		
		return alumnoDAO.subirPunto(nota);
	}

	@Override
	public Optional<Float> calcularMedia() {
		// TODO Auto-generated method stub
		return alumnoDAO.calcularMedia();
	}

}
