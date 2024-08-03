package grupof.ecommerce.proyectou1distribuidas.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Productos {
    private static int count = 0;
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    private int categoria_id;
    private int proveedor_id;
}