package com.example.jobseeker.model.request;

import com.example.jobseeker.entity.Recruiter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobRequest {
    private Long userId;
    private String location;
    private String description;
    private String title;
    private String details;
    private Date yoeFrom;
    private Date yoeTo;
    private String literacy;
    private String workType;
    private String benefits;
    private String salary;
    private String status;
    private Date publishDateTime;
    private Date dueDateTime;
    private Date closeDateTime;


}
