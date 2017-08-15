package pl.com.washme.job.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.washme.job.entity.Job;
import pl.com.washme.job.repository.JobRepository;

@Data
@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public void addJob(Job job){
        jobRepository.saveAndFlush(job);
    }

}
