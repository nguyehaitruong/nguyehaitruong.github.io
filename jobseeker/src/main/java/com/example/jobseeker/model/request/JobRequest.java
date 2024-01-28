package com.example.jobseeker.model.request;

import com.example.jobseeker.entity.Recruiter;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@Data
@AllArgsConstructor
public class JobRequest {
    private Long recruiterId;
    private Integer location;
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
