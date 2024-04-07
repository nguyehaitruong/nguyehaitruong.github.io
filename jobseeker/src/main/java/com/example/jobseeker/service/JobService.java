package com.example.jobseeker.service;

import com.example.jobseeker.entity.Application;
import com.example.jobseeker.entity.Job;
import com.example.jobseeker.entity.Recruiter;
import com.example.jobseeker.exception.JobNotFoundException;
import com.example.jobseeker.model.reponse.JobResponse;
import com.example.jobseeker.repository.JobRepository;
import com.example.jobseeker.repository.RecruiterRepository;
import com.example.jobseeker.security.SecurityUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor


public class JobService {

     private JobRepository jobRepository;
    private RecruiterRepository recruiterRepository;
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
        return jobRepository.findByTitleContaining(keyword);
    }
    public List<Job> getJobsByUserId(Long userId) {
        // Tìm người tuyển dụng tương ứng với userId được truyền từ client
        Recruiter recruiter = recruiterRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy người tuyển dụng cho userId đã cung cấp."));

        // Lấy ID của người tuyển dụng
        Long recruiterId = recruiter.getId();

        // Trả về danh sách công việc được liên kết với ID người tuyển dụng
        return jobRepository.findByRecruiterId(recruiterId);
    }


    public Job getJobById(Long job) {
        return jobRepository.findById(job).orElse(null);
    }

}


