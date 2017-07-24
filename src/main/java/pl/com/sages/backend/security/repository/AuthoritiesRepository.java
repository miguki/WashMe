package pl.com.sages.backend.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.sages.backend.security.entity.Authority;

public interface AuthoritiesRepository extends JpaRepository<Authority, Long> {
}
