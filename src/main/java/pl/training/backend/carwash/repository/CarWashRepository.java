package pl.training.backend.carwash.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.training.backend.carwash.entity.CarWash;

/**
 * Created by Jasiek on 27.07.2017.
 */
public interface CarWashRepository extends JpaRepository<CarWash, Long> {
}
