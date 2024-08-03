package ec.edu.espe.proyectou1distribuidas2.Models;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDetalle {

    private static int count = 0;
    private int id;
    private Date fecha;
    private BigDecimal total;
    private String cedulaCliente;
    private String nombreCliente;
    private String apellidosCliente;
    private int productoId;
    private int cantidad;
    private BigDecimal precioUnitario;
    private Date fecha_entrega;

}
