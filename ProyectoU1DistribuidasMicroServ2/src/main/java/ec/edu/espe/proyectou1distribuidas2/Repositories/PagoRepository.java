package ec.edu.espe.proyectou1distribuidas2.Repositories;

import ec.edu.espe.proyectou1distribuidas2.Models.Pago;
import java.util.ArrayList;
import java.util.List;

public class PagoRepository {
    private List<Pago> pagos = new ArrayList<>();
    private int idCounter = 0;

    public Pago save(Pago pago) {
        pago.setId(++idCounter);
        pagos.add(pago);
        return pago;
    }
    public Pago update(int id, Pago pago) {
        for (Pago p : pagos) {
            if (p.getId() == id) {
                p.setPedidoId(pago.getPedidoId());
                p.setNumeroTarjeta(pago.getNumeroTarjeta());
                p.setFechaVencimiento(pago.getFechaVencimiento());
                p.setCodigoSeguridad(pago.getCodigoSeguridad());
                p.setMonto(pago.getMonto());
                return p;
            }
        }
        return null;
    }
    public Pago delete(int id) {
        for (Pago p : pagos) {
            if (p.getId() == id) {
                pagos.remove(p);
                return p;
            }
        }
        return null;
    }

    public List<Pago> getAll() {
        return pagos;
    }

    public Pago getById(int id) {
        for (Pago p : pagos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}