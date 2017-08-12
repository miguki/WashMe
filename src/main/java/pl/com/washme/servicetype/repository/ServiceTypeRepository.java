package pl.com.washme.servicetype.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.washme.servicetype.entity.ServiceType;

public interface ServiceTypeRepository extends JpaRepository<ServiceType, Long> {
}
