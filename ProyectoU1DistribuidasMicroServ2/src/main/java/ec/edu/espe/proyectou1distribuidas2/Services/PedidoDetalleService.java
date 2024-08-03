package ec.edu.espe.proyectou1distribuidas2.Services;

import ec.edu.espe.proyectou1distribuidas2.Models.PedidoDetalle;
import ec.edu.espe.proyectou1distribuidas2.Models.Producto;
import ec.edu.espe.proyectou1distribuidas2.Repositories.PedidoDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PedidoDetalleService {
    @Autowired
    private final PedidoDetalleRepository pedidoDetalleRepository;


    private final RestTemplate restTemplate;


    public PedidoDetalleService(PedidoDetalleRepository pedidoDetalleRepository, RestTemplate restTemplate) {
        this.pedidoDetalleRepository = pedidoDetalleRepository;
        this.restTemplate = restTemplate;
    }

    public List<PedidoDetalle> obtenerTodosLosPedidosDetalles() {
        return pedidoDetalleRepository.findAll();
    }

    public PedidoDetalle obtenerPedidoDetallePorId(int id) {
        return pedidoDetalleRepository.findById(id);
    }

    public PedidoDetalle guardarPedidoDetalle(PedidoDetalle pedidoDetalle) {
        return pedidoDetalleRepository.save(pedidoDetalle);
    }

    public PedidoDetalle actualizarPedidoDetalle(int id, PedidoDetalle pedidoDetalle) {
        return pedidoDetalleRepository.update(id, pedidoDetalle);
    }

    public boolean eliminarPedidoDetalle(int id) {
        return pedidoDetalleRepository.delete(id);
    }



}