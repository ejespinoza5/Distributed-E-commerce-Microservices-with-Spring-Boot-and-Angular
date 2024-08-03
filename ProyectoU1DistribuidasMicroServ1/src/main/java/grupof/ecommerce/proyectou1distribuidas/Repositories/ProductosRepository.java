package grupof.ecommerce.proyectou1distribuidas.Repositories;

import grupof.ecommerce.proyectou1distribuidas.Models.Productos;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductosRepository {
    private List<Productos> listProductos = new ArrayList<>();

    public void add(Productos producto) {
        listProductos.add(producto);
    }

    public List<Productos> list() {
        return listProductos;
    }

    public Productos search(int id) {
        return listProductos.stream()
                .filter(item -> item.getId() == id)
                .findAny()
                .orElse(null);
    }

    public List<Productos> listByProveedor(int proveedorId) {
        return listProductos.stream()
                .filter(item -> item.getProveedor_id() == proveedorId)
                .collect(Collectors.toList());
    }

    public void update(int id, Productos producto) {
        Productos searchProducto = search(id);
        if (searchProducto != null) {
            listProductos.remove(listProductos.indexOf(searchProducto));
            searchProducto.setNombre(producto.getNombre());
            searchProducto.setDescripcion(producto.getDescripcion());
            searchProducto.setPrecio(producto.getPrecio());
            searchProducto.setStock(producto.getStock());
            searchProducto.setCategoria_id(producto.getCategoria_id());
            searchProducto.setProveedor_id(producto.getProveedor_id());
            listProductos.add(searchProducto);
        }
    }

    public void delete(int id) {
        Productos searchProducto = search(id);
        if (searchProducto != null) {
            listProductos.remove(searchProducto);
        }
    }
}