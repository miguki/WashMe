package pl.com.washme.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.washme.client.entity.Client;

/**
 * Created by Jasiek on 26.07.2017.
 */
public interface ClientRepository extends JpaRepository<Client, Long>{
}
