package com.example.jobseeker.controller.recruiter;

import com.example.jobseeker.entity.Job;
import com.example.jobseeker.exception.JobCreationException;
import com.example.jobseeker.model.request.JobRequest;
import com.example.jobseeker.service.RecruitmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping
public class PublishedRecruitmentController {
    private final RecruitmentService recruitmentService;
    @GetMapping("/published-recruitments")
    public String getPublishedRecruitments(Model model) {

        return "client/published-recruitment";
    }
    @PostMapping("/published-recruitments/create")
    public String createJob(@ModelAttribute("jobRequest") JobRequest jobRequest) {
        recruitmentService.createJob(jobRequest);
        return "client/published-recruitment";
    }






}
