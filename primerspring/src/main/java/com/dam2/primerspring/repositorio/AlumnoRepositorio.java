package com.dam2.primerspring.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dam2.primerspring.modelo.Alumno;
@Repository
public interface AlumnoRepositorio extends CrudRepository<Alumno, String> {
	@Query("SELECT AVG(a.nota) FROM Alumno a")
	Optional<Float>calcularMedia();
	
	List<Alumno> findByNota(int nota);
	List<Alumno> findByNotaNombre(int nota, String nombre);
	List<Alumno> findByNotaOrNombre(int nota, String nombre);
	
	

}
