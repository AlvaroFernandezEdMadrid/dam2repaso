package ejercicioRelacionesJPA;

import java.util.Optional;

import utilidadeshibernate.GenericJPADAO;

public class GrupoDAO {

    private final GenericJPADAO<Grupo, Long> genericDAO;

    public GrupoDAO() {
        this.genericDAO = new GenericJPADAO<>(Grupo.class);
    }

    // Método para guardar un grupo
    public Grupo save(Grupo grupo) {
        return genericDAO.save(grupo);
    }

    // Método para encontrar un grupo por su ID
    public Optional<Grupo> findById(Long id) {
        return genericDAO.findById(id);
    }

    // Método para eliminar un grupo
    public Grupo delete(Grupo grupo) {
        return genericDAO.delete(grupo);
    }

    // Método para obtener todos los grupos
    public Iterable<Grupo> findAll() {
        return genericDAO.findAll();
    }
}

