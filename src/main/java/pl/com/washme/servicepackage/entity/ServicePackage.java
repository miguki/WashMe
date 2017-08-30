package pl.com.washme.servicepackage.entity;

import lombok.Data;
import pl.com.washme.servicetype.entity.ServiceType;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class ServicePackage {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Long price;
//    @Column(nullable = false)
    private String description;
    @ManyToMany
    private List<ServiceType> serviceTypes;

}
