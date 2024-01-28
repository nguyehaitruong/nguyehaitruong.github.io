package com.example.jobseeker.entity;

import javax.persistence.*;

import com.example.jobseeker.statics.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;


import java.util.Date;

@Entity
@Table(name = "applications")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    Job Job;


    @Column(name = "cv", columnDefinition = "VARCHAR(255)")
    String cv;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "application_time")
    Date applicationTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    Status status;

    // Constructors, getters, setters, and other methods
}
