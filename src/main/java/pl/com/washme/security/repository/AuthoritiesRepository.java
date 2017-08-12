package pl.com.washme.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.washme.security.entity.Authority;

public interface AuthoritiesRepository extends JpaRepository<Authority, Long> {
}
