package com.example.jobseeker.entity;

import javax.persistence.*;
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
    @ManyToOne
    @JoinColumn(name = "status", nullable = false)
    ApplicationStatus applicationStatus;

    // Constructors, getters, setters, and other methods
}
