package pl.com.washme.reservation.entity;

import lombok.Data;
import pl.com.washme.carwash.entity.CarWash;
import pl.com.washme.client.entity.Client;

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
