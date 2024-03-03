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

    @Column(name = "location" ,length = 255)
    String location;

    @Column(name = "title", length = 255)
    String title;

    @Column(name = "description")
    String description ;

    @Column(name = "details",nullable = true, columnDefinition = "TEXT")
    String details;

    @Column(name = "yoe_from",nullable = true)
    Date yoeFrom;

    @Column(name = "yoe_to",nullable = true)
    Date yoeTo;

    @Column(name = "literacy",nullable = true, length = 20)
    String literacy;

    @Column(name = "work_type",nullable = true, length = 20)
    String workType;

    @Column(name = "benefits",nullable = true, length = 255)
    String benefits;

    @Column(name = "salary",nullable = true, length = 255)
    String salary;

    @Column(name = "status",nullable = true, length = 20)
    String status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "publish_date_time",nullable = true)
    Date publishDateTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "due_date_time",nullable = true)
    Date dueDateTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "close_date_time",nullable = true)
    Date closeDateTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "deleted_at")
    Date deletedAt;

    // Constructors, getters, setters, and other methods
}
