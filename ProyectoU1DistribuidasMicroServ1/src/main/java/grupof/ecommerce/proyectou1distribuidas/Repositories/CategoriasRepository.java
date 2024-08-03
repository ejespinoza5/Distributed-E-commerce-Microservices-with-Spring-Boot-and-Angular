package grupof.ecommerce.proyectou1distribuidas.Repositories;

import grupof.ecommerce.proyectou1distribuidas.Models.Categorias;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoriasRepository {
    private List<Categorias> listCategorias = new ArrayList<>();

    public void add(Categorias categoria) {
        listCategorias.add(categoria);
    }

    public List<Categorias> list() {
        return listCategorias;
    }

    public Categorias search(int id) {
        return listCategorias.stream()
                .filter(item -> item.getId() == id)
                .findAny()
                .orElse(null);
    }

    public void update(int id, Categorias categoria) {
        Categorias searchCategoria = search(categoria.getId());
        if (searchCategoria != null) {
            listCategorias.remove(listCategorias.indexOf(searchCategoria));
            searchCategoria.setNombre(categoria.getNombre());
            listCategorias.add(searchCategoria);
        }
    }

    public void delete(int id) {
        Categorias searchCategoria = search(id);
        if (searchCategoria != null) {
            listCategorias.remove(searchCategoria);
        }
    }
}