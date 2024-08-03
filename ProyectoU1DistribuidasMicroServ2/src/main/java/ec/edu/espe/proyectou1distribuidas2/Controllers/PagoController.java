package ec.edu.espe.proyectou1distribuidas2.Controllers;

import ec.edu.espe.proyectou1distribuidas2.Models.Pago;
import ec.edu.espe.proyectou1distribuidas2.Models.Producto;
import ec.edu.espe.proyectou1distribuidas2.Services.PagoService;
import ec.edu.espe.proyectou1distribuidas2.Services.PedidoDetalleService;
import ec.edu.espe.proyectou1distribuidas2.Services.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagos")
@CrossOrigin(origins = "http://localhost:4200")
public class PagoController {
    private final PedidoDetalleService pedidoDetalleService;
    private final ProductoService productoService;
    private PagoService pagoService = new PagoService();

    public PagoController(PedidoDetalleService pedidoDetalleService, ProductoService productoService) {
        this.pedidoDetalleService = pedidoDetalleService;
        this.productoService = productoService;
    }

    @PostMapping
    public Pago save(@RequestBody Pago pago) {
        return pagoService.save(pago);
    }

    @PutMapping("/{id}")
    public Pago update(@PathVariable int id, @RequestBody Pago pago) {
        return pagoService.update(id, pago);
    }

    @DeleteMapping("/{id}")
    public Pago delete(@PathVariable int id) {
        return pagoService.delete(id);
    }

    @GetMapping
    public List<Pago> getAll() {
        return pagoService.getAll();
    }

    @GetMapping("/{id}")
    public Pago getById(@PathVariable int id) {
        return pagoService.getById(id);
    }

    @GetMapping( value = "/productos")
    public ResponseEntity<List<Producto>> obtenerTodosLosProductos() {
        List<Producto> productos = productoService.obtenerTodosLosProductos();
        return ResponseEntity.ok(productos);
    }

}