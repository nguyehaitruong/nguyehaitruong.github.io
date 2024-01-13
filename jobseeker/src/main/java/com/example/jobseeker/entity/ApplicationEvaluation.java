package com.example.jobseeker.entity;

import javax.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;



@Entity
@Table(name = "application_evaluation")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApplicationEvaluation {

    @Id
    @Column(name = "id")
    Long id;

    @Column(name = "candidate_id")
    Long candidateId;

    @ManyToOne
    @JoinColumn(name = "recruiter_id", nullable = false)
    Recruiter recruiter;


    @Column(name = "feedback", columnDefinition = "TEXT")
    String feedback;

    @Column(name = "hired")
    boolean hired;

    // Constructors, getters, setters, and other methods
}
