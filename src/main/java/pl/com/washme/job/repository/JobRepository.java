package pl.com.washme.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.washme.job.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long> {
}
