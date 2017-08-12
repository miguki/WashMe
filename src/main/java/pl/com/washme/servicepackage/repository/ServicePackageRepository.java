package pl.com.washme.servicepackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.washme.servicepackage.entity.ServicePackage;

public interface ServicePackageRepository extends JpaRepository<ServicePackage, Long> {
}
