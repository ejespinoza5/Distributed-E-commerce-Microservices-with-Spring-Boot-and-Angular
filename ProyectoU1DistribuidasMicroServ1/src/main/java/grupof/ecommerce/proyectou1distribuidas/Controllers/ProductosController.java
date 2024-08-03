package grupof.ecommerce.proyectou1distribuidas.Controllers;

import grupof.ecommerce.proyectou1distribuidas.Models.Productos;
import grupof.ecommerce.proyectou1distribuidas.Services.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductosController {
    @Autowired
    private ProductosService service;

    @PostMapping(value = "/agregar")
    public Productos add(@RequestBody Productos producto) {
        service.add(producto);
        return producto;
    }

    @GetMapping(value = "/listar")
    public List<Productos> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public Productos search(@PathVariable int id) {
        return service.search(id);
    }

    @PutMapping("/{id}")
    public Productos update(@PathVariable int id, @RequestBody Productos producto) {
        service.update(id, producto);
        return producto;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}