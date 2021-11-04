package tienda_disfraces.reto3.repositorio.Crud;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tienda_disfraces.reto3.modelo.Reserva;

public interface ReservaCrudRepositorio extends CrudRepository<Reserva, Integer> {

    public List<Reserva> findAllByStatus(String status);
    
    public List<Reserva> findAllByStartDateAfterAndStartDateBefore(Date dateone, Date datetwo);
    
    //SELECT clientid, COUNT(*) AS total FROM reservacion group by clientid order by desc;
    @Query ("SELECT c.client, COUNT(c.client) from Reserva AS c group by c.client order by COUNT(c.client)DESC")
    public List<Object[]> countTotalReservationsByClient();

}
