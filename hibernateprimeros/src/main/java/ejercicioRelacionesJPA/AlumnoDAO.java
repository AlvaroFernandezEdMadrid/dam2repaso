package ejercicioRelacionesJPA;

import java.util.Optional;

import utilidadeshibernate.GenericJPADAO;

public class AlumnoDAO {

    private final GenericJPADAO<Alumno, Long> genericDAO;

    public AlumnoDAO() {
        this.genericDAO = new GenericJPADAO<>(Alumno.class);
    }

    // Método para guardar un alumno
    public Alumno save(Alumno alumno) {
        return genericDAO.save(alumno);
    }

    // Método para encontrar un alumno por su ID
    public Optional<Alumno> findById(Long id) {
        return genericDAO.findById(id);
    }

    // Método para eliminar un alumno
    public Alumno delete(Alumno alumno) {
        return genericDAO.delete(alumno);
    }

    // Método para obtener todos los alumnos
    public Iterable<Alumno> findAll() {
        return genericDAO.findAll();
    }
}

