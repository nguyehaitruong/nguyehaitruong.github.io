package com.example.jobseeker.service;

import com.example.jobseeker.entity.Job;
import com.example.jobseeker.exception.JobNotFoundException;
import com.example.jobseeker.model.reponse.JobResponse;
import com.example.jobseeker.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service

public class JobService {
    @Autowired
     private JobRepository jobRepository;
    public List<JobResponse> getJob() {
        List<JobResponse> result = new ArrayList<>();
        List<Job> jobs=jobRepository.findAll();
        for (int i = 0; i < jobs.size(); i++) {
            Job job = jobs.get(i);

            JobResponse jobResponse = JobResponse.builder()
                    .id(job.getId())
                    .title(job.getTitle())
                    .location(job.getLocation())
                    .yoeTo(job.getYoeTo())
                    .workType(job.getWorkType())
                    .salary(job.getSalary())
                    .build();
            result.add(jobResponse);
        }
        return result;
    }
    public JobResponse getJobDetails(Long id) throws JobNotFoundException {
        Optional<Job> jobOptional = jobRepository.findById(id);
        return jobOptional.map(job -> JobResponse.builder()
                        .id(job.getId())
                        .title(job.getTitle())
                        .location(job.getLocation())
                        .yoeTo(job.getYoeTo())
                        .workType(job.getWorkType())
                        .salary(job.getSalary())
                        .build())
                .orElseThrow(() -> new JobNotFoundException("Job with id " + id + " could not be found"));
    }
    public List<Job> searchJobs(String keyword) {
        return jobRepository.findByTitleContainingOrDescriptionContainingOrLocationContaining(keyword, keyword, keyword);
    }

}
