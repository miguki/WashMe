package pl.training.backend.profiles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.training.backend.profiles.entity.Client;

/**
 * Created by Jasiek on 26.07.2017.
 */
public interface ClientRepository extends JpaRepository<Client, Long>{
}
