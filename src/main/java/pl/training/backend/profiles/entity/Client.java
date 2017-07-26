package pl.training.backend.profiles.entity;

import lombok.Data;
import pl.training.backend.security.entity.Authority;
import pl.training.backend.security.entity.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User user;

}
