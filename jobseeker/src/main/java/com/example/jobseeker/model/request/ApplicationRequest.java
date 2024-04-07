package com.example.jobseeker.model.request;

import com.example.jobseeker.entity.Job;
import com.example.jobseeker.entity.User;
import com.example.jobseeker.statics.Status;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PROTECTED)
public class ApplicationRequest {
    Long id;

    User user;

    Job job;

    String cv;

    Date applicationTime;

    Status status;

}
