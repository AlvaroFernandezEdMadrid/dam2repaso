package ejercicioRelacionesJPA;

import utilidadeshibernate.GenericJPADAO;

import java.util.Optional;

public class NotaDAO {

    private final GenericJPADAO<Nota, Long> genericDAO;

    public NotaDAO() {
        this.genericDAO = new GenericJPADAO<>(Nota.class);
    }

    // Método para guardar una nota
    public Nota save(Nota nota) {
        return genericDAO.save(nota);
    }

    // Método para encontrar una nota por su ID
    public Optional<Nota> findById(Long id) {
        return genericDAO.findById(id);
    }

    // Método para eliminar una nota
    public Nota delete(Nota nota) {
        return genericDAO.delete(nota);
    }

    // Método para obtener todas las notas
    public Iterable<Nota> findAll() {
        return genericDAO.findAll();
    }
}
