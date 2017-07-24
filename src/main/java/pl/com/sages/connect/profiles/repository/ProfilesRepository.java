package pl.com.sages.connect.profiles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.sages.connect.profiles.entity.Profile;
import pl.com.sages.connect.profiles.entity.Skill;

public interface ProfilesRepository extends JpaRepository<Profile, Long> {
}
