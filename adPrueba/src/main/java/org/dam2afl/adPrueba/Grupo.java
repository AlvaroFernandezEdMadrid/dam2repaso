package org.dam2afl.adPrueba;

import java.util.HashSet;
import java.util.Set;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Singular;


@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true) 
@Builder
public class Grupo {
	@EqualsAndHashCode.Include
	@NonNull
	private String nombre;
	@Singular //Hace que mas tarde la coleccion sea inmutable, si ponemos (Cambia nombre funcion)
	private Set<Alumno> alumnos;
	
	
	public void addAlumno(Alumno alumno) {
		Set<Alumno> alumnosTemp=new HashSet<Alumno>(alumnos);
		
		alumnosTemp.add(alumno);
		
		alumnos=alumnosTemp;
	}
}


