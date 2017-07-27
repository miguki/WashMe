package pl.training.backend.reservation.entity;

import lombok.Data;
import pl.training.backend.carwash.entity.CarWash;
import pl.training.backend.client.entity.Client;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Jasiek on 27.07.2017.
 */
@Entity
@Data
public class Reservation {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private Date startHour;
    @Column(nullable = false)
    private Date endHour;
    @ManyToOne
    private CarWash carWash;
    @ManyToOne
    private Client client;

}
