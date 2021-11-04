package tienda_disfraces.reto3.repositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import tienda_disfraces.reto3.Contador.ContadorCliente;
import tienda_disfraces.reto3.modelo.Cliente;
import tienda_disfraces.reto3.modelo.Reserva;
import tienda_disfraces.reto3.repositorio.Crud.ReservaCrudRepositorio;

@Repository
public class ReservaRepositorio {

    @Autowired
    private ReservaCrudRepositorio reservaCrudRepositorio;

    public List<Reserva> getAll() {
        return (List<Reserva>) reservaCrudRepositorio.findAll();
    }

    public Optional<Reserva> getReserva(int id) {
        return reservaCrudRepositorio.findById(id);
    }

    public Reserva save(Reserva reserva) {
        return reservaCrudRepositorio.save(reserva);
    }

    public void delete(Reserva p) {
        reservaCrudRepositorio.delete(p);
    }

    public List<Reserva> ReservationStatus(String status) {
        return reservaCrudRepositorio.findAllByStatus(status);
    }

    public List<Reserva> ReservacionTiempoRepositorio(Date a, Date b) {
        return reservaCrudRepositorio.findAllByStartDateAfterAndStartDateBefore(a, b);
    }

    public List<ContadorCliente> getClientesRepositorio() {
        List<ContadorCliente> res = new ArrayList<>();
        List<Object[]> report = reservaCrudRepositorio.countTotalReservationsByClient();
        for (int i = 0; i < report.size(); i++) {
            res.add(new ContadorCliente((Long) report.get(i)[1], (Cliente) report.get(i)[0]));
        }
        return res;
    }

}
