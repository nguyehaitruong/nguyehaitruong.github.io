package com.example.jobseeker.entity;

import javax.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


import java.util.Date;

@Entity
@Table(name = "candidates")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Candidate extends  BaseEntity{



    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;



    @Column(name = "experience", columnDefinition = "TEXT")
    String experience;

    @Column(name = "skill", columnDefinition = "TEXT")
    String skill;

    @Column(name = "address", length = 20)
    String address;

    @Column(name = "deleted_at")
    Date deletedAt;

    // Constructors, getters, setters, and other methods
}
