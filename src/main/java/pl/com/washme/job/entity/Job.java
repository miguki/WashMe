package pl.com.washme.job.entity;

import lombok.Data;
import pl.com.washme.security.entity.User;
import pl.com.washme.servicepackage.entity.ServicePackage;
import pl.com.washme.servicetype.entity.ServiceType;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Job {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private Long price;
    @ManyToOne
    private User user;
    @ManyToOne
    private ServicePackage servicePackage;
    @ManyToMany
    private List<ServiceType> serviceTypes;
}