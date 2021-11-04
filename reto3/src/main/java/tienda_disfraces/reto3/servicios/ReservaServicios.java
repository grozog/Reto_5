package tienda_disfraces.reto3.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tienda_disfraces.reto3.Contador.ContadorCliente;
import tienda_disfraces.reto3.Contador.StatusReservas;
import tienda_disfraces.reto3.modelo.Reserva;
import tienda_disfraces.reto3.repositorio.ReservaRepositorio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
/**
 * @author Grupo 6
 */
@Service
public class ReservaServicios {
    /**
     * Creacion variable de Repositorio
     */
    @Autowired
    private ReservaRepositorio reservaRepositorio;
    /**
     * Metodo para Obtener datos de la tabla Reservas
     * @return list de Reservas
     */

    public List<Reserva> getAll() {
        return reservaRepositorio.getAll();
    }
    /**
     *
     * @param reservationId
     * @return
     */

    public Optional<Reserva> getReserva(int reservationId) {
        return reservaRepositorio.getReserva(reservationId);
    }
    /**
     * Metodo para Guardar Reserva
     * @param reservation
     * @return
     */

    public Reserva save(Reserva reservation) {
        if (reservation.getIdReservation() == null) {
            return reservaRepositorio.save(reservation);
        } else {
            Optional<Reserva> raux = reservaRepositorio.getReserva(reservation.getIdReservation());
            if (raux.isEmpty()) {
                return reservaRepositorio.save(reservation);
            } else {
                return reservation;
            }
        }
    }
/**
 *  Metodo para Actualizar Reserva
 * @param reserva
 * @return
 */
    public Reserva update(Reserva reserva) {
        if (reserva.getIdReservation() != null) {
            Optional<Reserva> e = reservaRepositorio.getReserva(reserva.getIdReservation());
            if (!e.isEmpty()) {

                if (reserva.getStartDate() != null) {
                    e.get().setStartDate(reserva.getStartDate());
                }
                if (reserva.getDevolutionDate() != null) {
                    e.get().setDevolutionDate(reserva.getDevolutionDate());
                }
                if (reserva.getStatus() != null) {
                    e.get().setStatus(reserva.getStatus());
                }
                reservaRepositorio.save(e.get());
                return e.get();
            } else {
                return reserva;
            }
        } else {
            return reserva;
        }
    }
/**
 * Metodo para Borrar Reserva
 * @param reservationId
 * @return
 */
    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReserva(reservationId).map(reservation -> {
            reservaRepositorio.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
/**
 * Metodo para Generar status
 * @return Status Reserva
 */
    public StatusReservas getRepStatusRes() {
        List<Reserva> completed = reservaRepositorio.ReservationStatus("completed");
        List<Reserva> cancelled = reservaRepositorio.ReservationStatus("cancelled");
        return new StatusReservas(completed.size(), cancelled.size());
    }
/**
 * Metodo para Reportar Tiempo
 * @param datoA
 * @param datoB
 * @return Lista de Reserva
 */
    public List<Reserva> reporteTiempoServicio(String datoA, String datoB) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");

        Date datoUno = new Date();
        Date datoDos = new Date();

        try {
            datoUno = parser.parse(datoA);
            datoDos = parser.parse(datoB);
        } catch (ParseException evt) {
            evt.printStackTrace();
        }
        if (datoUno.before(datoDos)) {
            return reservaRepositorio.ReservacionTiempoRepositorio(datoUno, datoDos);
        } else {
            return new ArrayList<>();
        }
    }
/**
 * Metodo para reporte de Cliente
 * @return Lista de Clientes
 */
    public List<ContadorCliente> reporteClientesServicio() {
        return reservaRepositorio.getClientesRepositorio();
    }
}
