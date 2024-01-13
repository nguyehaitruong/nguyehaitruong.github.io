package com.example.jobseeker.entity;

import javax.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;



@Entity
@Table(name = "job_skills")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JobSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    Job Job;

    @ManyToOne
    @JoinColumn(name = "skill_id", nullable = false)
    Skill skill;



}
