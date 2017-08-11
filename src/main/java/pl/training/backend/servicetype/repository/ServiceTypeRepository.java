package pl.training.backend.servicetype.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.training.backend.servicetype.entity.ServiceType;

public interface ServiceTypeRepository extends JpaRepository<ServiceType, Long> {
}
