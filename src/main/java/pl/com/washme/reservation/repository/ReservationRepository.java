package pl.com.washme.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.com.washme.reservation.entity.Reservation;

import java.util.List;

/**
 * Created by Jasiek on 27.07.2017.
 */
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("SELECT r FROM Reservation r left join fetch r.carWash left join fetch r.client")
    List<Reservation> getReservations();

}