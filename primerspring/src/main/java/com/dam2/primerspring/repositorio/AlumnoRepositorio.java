package com.dam2.primerspring.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dam2.primerspring.modelo.Alumno;
import com.dam2.primerspring.modelo.NiaYNombre;

import jakarta.transaction.Transactional;
@Repository
public interface AlumnoRepositorio extends CrudRepository<Alumno, String> {
	
	@Transactional
	@Modifying
	@Query("UPDATE Alumno a set a.nota=a.nota+1 WHERE a.nota >?1 ")
	int subirPunto(int notaCorte);
	
	@Query("SELECT a.nia as nia, a.nombre as nombre FROM Alumno a")
	List<NiaYNombre> listadoAlumnos();
	
	
	
	
	
	@Query("SELECT AVG(a.nota) FROM Alumno a")
	Optional<Float>calcularMedia();
	
	//List<Alumno> findByNota(int nota);
	//List<Alumno> findByNotaNombre(int nota, String nombre);
	//List<Alumno> findByNotaOrNombre(int nota, String nombre);
	
	

}
