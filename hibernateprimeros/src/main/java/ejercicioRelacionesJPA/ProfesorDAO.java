package ejercicioRelacionesJPA;

import java.util.Optional;

import utilidadeshibernate.GenericJPADAO;

public class ProfesorDAO {
    
    private final GenericJPADAO<Profesor, Long> genericDAO;

    public ProfesorDAO() {
        this.genericDAO = new GenericJPADAO<>(Profesor.class);
    }

    // Método para guardar un profesor
    public Profesor save(Profesor profesor) {
        return genericDAO.save(profesor);
    }

    // Método para encontrar un profesor por su ID
    public Optional<Profesor> findById(Long id) {
        return genericDAO.findById(id);
    }

    // Método para eliminar un profesor
    public Profesor delete(Profesor profesor) {
        return genericDAO.delete(profesor);
    }

    // Método para obtener todos los profesores
    public Iterable<Profesor> findAll() {
        return genericDAO.findAll();
    }
}
