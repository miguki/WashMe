package pl.training.backend.reservation.repository;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.training.backend.reservation.entity.Reservation;

import java.util.List;

/**
 * Created by Jasiek on 27.07.2017.
 */
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("SELECT r FROM Reservation r left join fetch r.carWash left join fetch r.client")
    List<Reservation> getReservations();

}