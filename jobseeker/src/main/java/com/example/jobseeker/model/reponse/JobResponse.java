package com.example.jobseeker.model.reponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobResponse {
    Long id;
    String location;
    String title;
    Date yoeTo;
    String workType;
    String salary;

}
