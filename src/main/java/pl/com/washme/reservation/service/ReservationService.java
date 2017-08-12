package pl.com.washme.reservation.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.washme.reservation.entity.Reservation;
import pl.com.washme.reservation.repository.ReservationRepository;

import java.util.List;

/**
 * Created by Jasiek on 27.07.2017.
 */
@Data
@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public void addReservation(Reservation reservation){
        reservationRepository.saveAndFlush(reservation);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.getReservations();
    }

//
//    public ResultPage<Reservation> getAllReservations(int pageNumber, int pageSize) {
//        Page<Reservation> reservationsPage = reservationRepository.findAll(new PageRequest(pageNumber, pageSize));
//        return new ResultPage<>(reservationsPage.getContent(), reservationsPage.getNumber(), reservationsPage.getTotalPages());
//    }

}