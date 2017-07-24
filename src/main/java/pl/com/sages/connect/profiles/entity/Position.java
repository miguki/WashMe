package pl.com.sages.connect.profiles.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "positions")
@Entity
@Data
public class Position {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name")
    private String name;
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private Date endDate;
    private String company;
    private String location;
    private String description;

}
