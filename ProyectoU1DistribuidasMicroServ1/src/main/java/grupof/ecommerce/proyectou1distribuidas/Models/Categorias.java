package grupof.ecommerce.proyectou1distribuidas.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categorias {
    private static int count = 0;
    private int id;
    private String nombre;
}