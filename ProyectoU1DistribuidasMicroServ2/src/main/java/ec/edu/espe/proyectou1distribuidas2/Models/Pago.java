package ec.edu.espe.proyectou1distribuidas2.Models;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pago {

    private static int count = 0;

    private int id;
    private int pedidoId;
    private String nombreCliente;
    private String apellidosCliente;
    private String numeroTarjeta;
    private String fechaVencimiento;
    private String codigoSeguridad;
    private BigDecimal monto;
}