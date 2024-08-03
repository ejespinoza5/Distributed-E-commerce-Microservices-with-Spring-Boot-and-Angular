package ec.edu.espe.proyectou1distribuidas2.Services;

import ec.edu.espe.proyectou1distribuidas2.Models.Producto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductoService {
    private RestTemplate restTemplate = new RestTemplate();

    public Producto obtenerProductoPorId(int id) {
        String url = "http://localhost:8080/productos/" + id;
        return restTemplate.getForObject(url, Producto.class);
    }


    public void consumirStock(int productoId, int cantidad) {
        Producto producto = obtenerProductoPorId(productoId);
        if (producto != null && cantidad <= producto.getStock()) {
            producto.setStock(producto.getStock() - cantidad);
            actualizarStockEnMicroservicio(productoId, producto);
        } else {
            throw new IllegalArgumentException("No hay suficiente stock .");
        }
    }

    private void actualizarStockEnMicroservicio(int productoId, Producto producto) {
        String url = "http://localhost:8080/productos/" + productoId;
        restTemplate.put(url, producto);
    }

    public List<Producto> obtenerTodosLosProductos() {
        String url = "http://localhost:8080/productos/listar";
        Producto[] productos = restTemplate.getForObject(url, Producto[].class);
        return Arrays.asList(productos);
    }

}
