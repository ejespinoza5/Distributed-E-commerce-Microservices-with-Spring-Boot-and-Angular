package grupof.ecommerce.proyectou1distribuidas.Services;

import grupof.ecommerce.proyectou1distribuidas.Models.Proveedores;
import grupof.ecommerce.proyectou1distribuidas.Repositories.ProveedoresRepository;
import grupof.ecommerce.proyectou1distribuidas.exceptions.PublisherNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedoresService {
    @Autowired
    private ProveedoresRepository repository;

    private static int idCounter = 0;
    public void add(Proveedores proveedor) {
        try {
            repository.add(proveedor);
            proveedor.setId(++idCounter);
        } catch (Exception e) {
            throw new PublisherNotFoundException("Error al agregar el proveedor: " + e.getMessage());
        }
    }

    public List<Proveedores> list() {
        try {
            return repository.list();
        } catch (Exception e) {
            throw new PublisherNotFoundException("Error al listar los proveedores: " + e.getMessage());
        }
    }

    public Proveedores search(int id) {
        try {
            return repository.search(id);
        } catch (Exception e) {
            throw new PublisherNotFoundException("Error al buscar el proveedor: " + e.getMessage());
        }
    }

    public void update(int id, Proveedores proveedor) {
        try {
            repository.update(id, proveedor);
        } catch (Exception e) {
            throw new PublisherNotFoundException("Error al actualizar el proveedor: " + e.getMessage());
        }
    }

    public void delete(int id) {
        try {
            repository.delete(id);
        } catch (Exception e) {
            throw new PublisherNotFoundException("Error al eliminar el proveedor: " + e.getMessage());
        }
    }
}