package pl.com.washme.client.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Jasiek on 26.07.2017.
 */
@Entity
@Data
public class Client {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;

}
