package com.example.jobseeker.controller.recruiter;

import com.example.jobseeker.entity.Application;
import com.example.jobseeker.entity.Job;
import com.example.jobseeker.exception.UnsupportedFormatException;
import com.example.jobseeker.model.request.ApplicationRequest;
import com.example.jobseeker.service.ApplicationService;
import com.example.jobseeker.service.JobService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping
public class JobController {
    private JobService jobService;
    private ApplicationService applicationService;

    @GetMapping("/jobs/{userId}")
    public String showJobList(@PathVariable Long userId, Model model) {
        List<Job> jobs = jobService.getJobsByUserId(userId);
        model.addAttribute("jobs", jobs);
        return "client/manage-recruitment";
    }

    @GetMapping("/candidates/{jobId}")
    public String getCandidatesForJob(@PathVariable Long jobId, Model model) {
        // Assume you have a method to fetch Job by its ID, let's call it getJobById
        Job jobServiceJobById = jobService.getJobById(jobId);
        List<Application> candidates = applicationService.getCandidatesForJob(jobServiceJobById);
        model.addAttribute("candidates", candidates);
        return "client/candidate-list"; // Return the name of the view to display the candidate list
    }
    @PostMapping("/apply")
    public String saveApplication(@ModelAttribute ApplicationRequest request,
                                  @RequestParam("cvImage") MultipartFile cvImage) {
        try {
            applicationService.saveApplication(request, cvImage);
            return "Application saved successfully";
        } catch (UnsupportedFormatException | IOException e) {
            e.printStackTrace();
            return "Error saving application: " + e.getMessage();
        }
    }
}
