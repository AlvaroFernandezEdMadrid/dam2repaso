package ejercicioRelacionesJPA;

import java.util.Optional;

import utilidadeshibernate.GenericJPADAO;

public class ModuloDAO {

    private final GenericJPADAO<Modulo, Long> genericDAO;

    public ModuloDAO() {
        this.genericDAO = new GenericJPADAO<>(Modulo.class);
    }

    // Método para guardar un módulo
    public Modulo save(Modulo modulo) {
        return genericDAO.save(modulo);
    }

    // Método para encontrar un módulo por su ID
    public Optional<Modulo> findById(Long id) {
        return genericDAO.findById(id);
    }

    // Método para eliminar un módulo
    public Modulo delete(Modulo modulo) {
        return genericDAO.delete(modulo);
    }

    // Método para obtener todos los módulos
    public Iterable<Modulo> findAll() {
        return genericDAO.findAll();
    }
}

