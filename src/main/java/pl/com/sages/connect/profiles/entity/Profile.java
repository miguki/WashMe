package pl.com.sages.connect.profiles.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Table(name = "profiles")
@Entity
@Data
public class Profile {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @Lob
    private String description;
    @JoinColumn(name = "profile_id")
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Position> positions;
    @JoinColumn(name = "profile_id")
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Skill> skills;

}
