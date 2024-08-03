package grupof.ecommerce.proyectou1distribuidas.Controllers;

import grupof.ecommerce.proyectou1distribuidas.Models.Categorias;
import grupof.ecommerce.proyectou1distribuidas.Services.CategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoriasController {
    @Autowired
    private CategoriasService service;

    @PostMapping
    public void add(@RequestBody Categorias categoria) {
        service.add(categoria);
    }

    @GetMapping(value = "/listar")
    public List<Categorias> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public Categorias search(@PathVariable int id) {
        return service.search(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Categorias categoria) {
        service.update(id, categoria);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}