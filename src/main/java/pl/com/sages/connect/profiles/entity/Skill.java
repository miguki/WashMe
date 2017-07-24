package pl.com.sages.connect.profiles.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "skills")
@Entity
@Data
public class Skill {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name")
    private String name;

}
