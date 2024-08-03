package ec.edu.espe.proyectou1distribuidas2.Repositories;

import ec.edu.espe.proyectou1distribuidas2.Models.PedidoDetalle;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class PedidoDetalleRepository {

    private List<PedidoDetalle> pedidosDetalles = new ArrayList<>();
    private int idCounter = 0;

    public List<PedidoDetalle> findAll() {
        return pedidosDetalles;
    }

    public PedidoDetalle findById(int id) {
        return pedidosDetalles.stream()
                .filter(pedidoDetalle -> pedidoDetalle.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public PedidoDetalle save(PedidoDetalle pedidoDetalle) {
        pedidoDetalle.setId(++idCounter);
        LocalDate now = LocalDate.now();
        Date date = Date.from(now.atStartOfDay(ZoneId.systemDefault()).toInstant());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = formatter.format(date);
        try {
            Date finalDate = formatter.parse(formattedDate);
            pedidoDetalle.setFecha(finalDate); // Set the current date
        } catch (ParseException e) {
            e.printStackTrace();
        }
        pedidosDetalles.add(pedidoDetalle);
        return pedidoDetalle;
    }

    public PedidoDetalle update(int id, PedidoDetalle pedidoDetalle) {
        for (PedidoDetalle detalle : pedidosDetalles) {
            if (detalle.getId() == id) {

                detalle.setTotal(pedidoDetalle.getTotal());
                detalle.setCedulaCliente(pedidoDetalle.getCedulaCliente());
                detalle.setNombreCliente(pedidoDetalle.getNombreCliente());
                detalle.setApellidosCliente(pedidoDetalle.getApellidosCliente());
                detalle.setProductoId(pedidoDetalle.getProductoId());
                detalle.setCantidad(pedidoDetalle.getCantidad());
                detalle.setPrecioUnitario(pedidoDetalle.getPrecioUnitario());

                // Update the date to the current date
                LocalDate now = LocalDate.now();
                Date date = Date.from(now.atStartOfDay(ZoneId.systemDefault()).toInstant());
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String formattedDate = formatter.format(date);
                try {
                    Date finalDate = formatter.parse(formattedDate);
                    detalle.setFecha(finalDate); // Set the current date
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                return detalle;
            }
        }
        return null;
    }

    public boolean delete(int id) {
        return pedidosDetalles.removeIf(pedidoDetalle -> pedidoDetalle.getId() == id);
    }
}