package ec.edu.espe.proyectou1distribuidas2.Controllers;

import ec.edu.espe.proyectou1distribuidas2.Models.PedidoDetalle;
import ec.edu.espe.proyectou1distribuidas2.Models.Producto;
import ec.edu.espe.proyectou1distribuidas2.Services.PedidoDetalleService;
import ec.edu.espe.proyectou1distribuidas2.Services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos-detalles")
@CrossOrigin(origins = "http://localhost:4200")
public class PedidoDetalleController {
    @Autowired
    private final PedidoDetalleService pedidoDetalleService;
    @Autowired
    private ProductoService productoDervice;
    @Autowired
    private ProductoService productoService;


    public PedidoDetalleController(PedidoDetalleService pedidoDetalleService) {
        this.pedidoDetalleService = pedidoDetalleService;
    }

    // Endpoint para guardar un nuevo detalle de pedido
    @PostMapping
    public ResponseEntity<PedidoDetalle> guardarPedidoDetalle(@RequestBody PedidoDetalle pedidoDetalle) {
        PedidoDetalle nuevoDetalle = pedidoDetalleService.guardarPedidoDetalle(pedidoDetalle);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoDetalle);
    }
    // Endpoint para listar todos los detalles de pedidos
    @GetMapping
    public ResponseEntity<List<PedidoDetalle>> obtenerTodosLosPedidosDetalles() {
        List<PedidoDetalle> pedidosDetalles = pedidoDetalleService.obtenerTodosLosPedidosDetalles();
        return ResponseEntity.ok(pedidosDetalles);
    }

    // Endpoint para obtener un detalle de pedido por su ID
    @GetMapping("/{id}")
    public ResponseEntity<PedidoDetalle> obtenerPedidoDetallePorId(@PathVariable int id) {
        PedidoDetalle pedidoDetalle = pedidoDetalleService.obtenerPedidoDetallePorId(id);
        if (pedidoDetalle != null) {
            return ResponseEntity.ok(pedidoDetalle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    // Endpoint para actualizar un detalle de pedido por su ID
    @PutMapping("/{id}")
    public ResponseEntity<PedidoDetalle> actualizarPedidoDetalle(@PathVariable int id, @RequestBody PedidoDetalle pedidoDetalle) {
        PedidoDetalle detalleActualizado = pedidoDetalleService.actualizarPedidoDetalle(id, pedidoDetalle);
        if (detalleActualizado != null) {
            return ResponseEntity.ok(detalleActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para eliminar un detalle de pedido por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPedidoDetalle(@PathVariable int id) {
        boolean eliminado = pedidoDetalleService.eliminarPedidoDetalle(id);
        if (eliminado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //consumir
    @GetMapping(value = "/consumir/{id}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable int id) {
        Producto producto = productoService.obtenerProductoPorId(id);
        if (producto != null) {
            return ResponseEntity.ok(producto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/productos")
    public ResponseEntity<List<Producto>> obtenerTodosLosProductos() {
        List<Producto> productos = productoService.obtenerTodosLosProductos();
        return ResponseEntity.ok(productos);
    }

    @PutMapping("/consumir/{id}/{cantidad}")
    public ResponseEntity<Void> consumirStock(@PathVariable int id, @PathVariable int cantidad) {
        try {
            productoService.consumirStock(id, cantidad);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}