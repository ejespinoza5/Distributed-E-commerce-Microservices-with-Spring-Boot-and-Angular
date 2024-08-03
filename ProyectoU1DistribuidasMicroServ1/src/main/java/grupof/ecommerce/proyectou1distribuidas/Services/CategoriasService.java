package grupof.ecommerce.proyectou1distribuidas.Services;

import grupof.ecommerce.proyectou1distribuidas.Models.Categorias;
import grupof.ecommerce.proyectou1distribuidas.Repositories.CategoriasRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CategoriasService {
    private final CategoriasRepository repository;
    private static int idCounter = 0;

    public CategoriasService(CategoriasRepository repository) {

        this.repository = repository;
    }

  public void add(Categorias categoria) {
      categoria.setId(++idCounter);
    repository.add(categoria);
}

    public List<Categorias> list() {
        return repository.list();
    }

    public Categorias search(int id) {
        return repository.search(id);
    }

    public void update(int id, Categorias categoria) {
        repository.update(id, categoria);
    }

    public void delete(int id) {
        repository.delete(id);
    }
}