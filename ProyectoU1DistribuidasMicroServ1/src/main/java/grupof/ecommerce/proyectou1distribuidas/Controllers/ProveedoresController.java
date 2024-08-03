package grupof.ecommerce.proyectou1distribuidas.Controllers;

import grupof.ecommerce.proyectou1distribuidas.Models.Proveedores;
import grupof.ecommerce.proyectou1distribuidas.Services.ProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedores")
@CrossOrigin(origins = "http://localhost:4200")

public class ProveedoresController {
    @Autowired
    private ProveedoresService service;

    @PostMapping
    public void add(@RequestBody Proveedores proveedor) {
        service.add(proveedor);
    }

    @GetMapping(value = "/listar")
    public List<Proveedores> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public Proveedores search(@PathVariable int id) {
        return service.search(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Proveedores proveedor) {
        service.update(id, proveedor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}