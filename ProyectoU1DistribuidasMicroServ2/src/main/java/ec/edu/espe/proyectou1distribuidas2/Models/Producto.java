package ec.edu.espe.proyectou1distribuidas2.Models;

import lombok.Data;
import org.springframework.web.client.RestTemplate;

@Data
public class Producto {
    private int id;
    private String nombre;
    private String descripcion;
    private int stock;
    private double precio;
    private int categoria_id;
    private int proveedor_id;



}