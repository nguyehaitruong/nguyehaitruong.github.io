package com.example.jobseeker.controller;

import com.example.jobseeker.entity.Job;
import com.example.jobseeker.exception.JobNotFoundException;
import com.example.jobseeker.model.reponse.JobResponse;
import com.example.jobseeker.service.JobService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping

public class SearchCotroller {
    private JobService jobService;

    @GetMapping("/search")
    public String searchJobs(@RequestParam(required = false) String keyword, Model model){
        List<Job> jobs = jobService.searchJobs(keyword);
        model.addAttribute("jobs", jobs);
        return  "client/search";
    }

    @GetMapping("/job/{id}")
    public String getJobDetails(@PathVariable Long id, Model model) {
        try {
                JobResponse jobResponse = jobService.getJobDetails(id);
                model.addAttribute("job", jobResponse);
                return "client/jd-page"; // Trả về tên của trang chi tiết công việc
        } catch (JobNotFoundException e) {
                return "errorPage";
        }
        }
}
