package pl.com.sages.connect.profiles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.sages.connect.profiles.entity.Position;
import pl.com.sages.connect.profiles.entity.Skill;

public interface PositionsRepository extends JpaRepository<Position, Long> {
}
