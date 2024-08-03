package ec.edu.espe.proyectou1distribuidas2.Services;

import ec.edu.espe.proyectou1distribuidas2.Models.Pago;
import ec.edu.espe.proyectou1distribuidas2.Repositories.PagoRepository;

import java.util.List;

public class PagoService {
    private PagoRepository pagoRepository = new PagoRepository();

    public Pago save(Pago pago) {
        return pagoRepository.save(pago);
    }

    public Pago update(int id, Pago pago) {
        return pagoRepository.update(id, pago);
    }

    public Pago delete(int id) {
        return pagoRepository.delete(id);
    }

    public List<Pago> getAll() {
        return pagoRepository.getAll();
    }

    public Pago getById(int id) {
        return pagoRepository.getById(id);
    }
}