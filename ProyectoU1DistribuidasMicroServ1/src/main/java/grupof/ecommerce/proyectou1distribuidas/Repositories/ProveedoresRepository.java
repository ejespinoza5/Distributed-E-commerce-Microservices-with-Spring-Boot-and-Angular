package grupof.ecommerce.proyectou1distribuidas.Repositories;

import grupof.ecommerce.proyectou1distribuidas.Models.Proveedores;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProveedoresRepository {
    private List<Proveedores> listProveedores = new ArrayList<>();

    public void add(Proveedores proveedor) {
        listProveedores.add(proveedor);
    }

    public List<Proveedores> list() {
        return listProveedores;
    }

    public Proveedores search(int id) {
        return listProveedores.stream()
                .filter(item -> item.getId() == id)
                .findAny()
                .orElse(null);
    }

    public void update(int id, Proveedores proveedor) {
        Proveedores searchProveedor = search(proveedor.getId());
        if (searchProveedor != null) {
            listProveedores.remove(listProveedores.indexOf(searchProveedor));
            searchProveedor.setNombre(proveedor.getNombre());
            searchProveedor.setDireccion(proveedor.getDireccion());
            searchProveedor.setTelefono(proveedor.getTelefono());
            listProveedores.add(searchProveedor);
        }
    }

    public void delete(int id) {
        Proveedores searchProveedor = search(id);
        if (searchProveedor != null) {
            listProveedores.remove(searchProveedor);
        }
    }
}