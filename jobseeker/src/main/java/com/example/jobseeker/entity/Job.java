package com.example.jobseeker.entity;

import javax.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


import java.util.Date;

@Entity
@Table(name = "jobs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Job  extends  BaseEntity {



    @ManyToOne
    @JoinColumn(name = "recruiter_id", nullable = false)
    Recruiter recruiter;

    @Column(name = "location")
    Integer location;

    @Column(name = "title", length = 255)
    String title;

    @Column(name = "details", columnDefinition = "TEXT")
    String details;

    @Column(name = "yoe_from")
    int yoeFrom;

    @Column(name = "yoe_to")
    int yoeTo;

    @Column(name = "literacy", length = 20)
    String literacy;

    @Column(name = "work_type", length = 20)
    String workType;

    @Column(name = "benefits", length = 255)
    String benefits;

    @Column(name = "salary", length = 255)
    String salary;

    @Column(name = "status", length = 20)
    String status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "publish_date_time")
    Date publishDateTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "due_date_time")
    Date dueDateTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "close_date_time")
    Date closeDateTime;



    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "deleted_at")
    Date deletedAt;

    // Constructors, getters, setters, and other methods
}
