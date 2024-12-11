package ejercicioRelacionesJPA;
import javax.persistence.PreRemove;

import utilidadeshibernate.GenericJPADAO;

public class AlumnoListener {
	private final String UNIDADPERSISTENCIA = "gruposalumnosmodulos";
	@PreRemove
	public void borradoAlumno (Alumno alumno)
	{

		GenericJPADAO <Calificacion,Integer> calificacionDAO;
		calificacionDAO = new GenericJPADAO(Calificacion.class,UNIDADPERSISTENCIA);
		/*
		List<Calificacion> calificaciones  = (List<Calificacion>) calificacionDAO.findAll();

		calificaciones.stream().
				filter(c ->c.getAlumno().equals(alumno)).
				forEach(calificacionDAO::delete);
		 */
		String query = "DELETE FROM Calificacion c WHERE c.alumno.dni = ?1";
		calificacionDAO.executeQuery(query, alumno.getDni());
	}

}
