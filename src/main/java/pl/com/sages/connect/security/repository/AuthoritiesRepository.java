package pl.com.sages.connect.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.sages.connect.security.entity.Authority;

public interface AuthoritiesRepository extends JpaRepository<Authority, Long> {
}
