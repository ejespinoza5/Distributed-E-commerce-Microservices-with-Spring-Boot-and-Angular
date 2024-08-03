package grupof.ecommerce.proyectou1distribuidas.Services;

import grupof.ecommerce.proyectou1distribuidas.Models.Productos;
import grupof.ecommerce.proyectou1distribuidas.Repositories.ProductosRepository;
import grupof.ecommerce.proyectou1distribuidas.exceptions.PublisherNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductosService {
    @Autowired
    ProductosRepository repository;

    private static int idCounter = 0;

    public void add(Productos producto) {
        try {
            repository.add(producto);
            producto.setId(++idCounter);
        } catch (Exception e) {
            throw new PublisherNotFoundException("Error al agregar el producto: " + e.getMessage());
        }
    }

    public List<Productos> list() {
        try {
            return repository.list();
        } catch (Exception e) {
            throw new PublisherNotFoundException("Error al listar los productos: " + e.getMessage());
        }
    }

    public Productos search(int id) {
        try {
            return repository.search(id);
        } catch (Exception e) {
            throw new PublisherNotFoundException("Error al buscar el producto: " + e.getMessage());
        }
    }

    public List<Productos> listByProveedor(int proveedorId) {
        try {
            return repository.listByProveedor(proveedorId);
        } catch (Exception e) {
            throw new PublisherNotFoundException("Error al listar los productos por proveedor: " + e.getMessage());
        }
    }

    public void update(int id, Productos producto) {
        try {
            repository.update(id, producto);
        } catch (Exception e) {
            throw new PublisherNotFoundException("Error al actualizar el producto: " + e.getMessage());
        }
    }

    public void delete(int id) {
        try {
            repository.delete(id);
        } catch (Exception e) {
            throw new PublisherNotFoundException("Error al eliminar el producto: " + e.getMessage());
        }
    }
}