package ejercicioRelacionesJPA;

import utilidadeshibernate.GenericJPADAO;

import java.util.Optional;

public class DireccionDAO {

    private final GenericJPADAO<Direccion, Long> genericDAO;

    public DireccionDAO() {
        this.genericDAO = new GenericJPADAO<>(Direccion.class);
    }

    // Método para guardar una dirección
    public Direccion save(Direccion direccion) {
        return genericDAO.save(direccion);
    }

    // Método para encontrar una dirección por su ID
    public Optional<Direccion> findById(Long id) {
        return genericDAO.findById(id);
    }

    // Método para eliminar una dirección
    public Direccion delete(Direccion direccion) {
        return genericDAO.delete(direccion);
    }

    // Método para obtener todas las direcciones
    public Iterable<Direccion> findAll() {
        return genericDAO.findAll();
    }
}
