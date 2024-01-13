package com.example.jobseeker.entity;

import javax.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


import java.util.Date;

@Entity
@Table(name = "interview_appointments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InterviewAppointment extends  BaseEntity{



    @ManyToOne
    @JoinColumn(name = "application_id", nullable = false, insertable = false, updatable = false)
    Application application;

    @ManyToOne
    @JoinColumn(name = "application_id", nullable = false)
    Job job;

    @Column(name = "interview_type", length = 20)
    String interviewType;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "interview_date")
    Date interviewDate;

    @Column(name = "interview_link", length = 255)
    String interviewLink;

    @Column(name = "result", length = 20)
    String result;

    @Column(name = "feedback", columnDefinition = "TEXT")
    String feedback;




}
