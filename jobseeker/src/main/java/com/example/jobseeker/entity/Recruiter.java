package com.example.jobseeker.entity;


import javax.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "recruiters")
public class Recruiter extends BaseEntity {



    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;

    @Column(name = "name", nullable = true, length = 255)
    private String name;

    @Column(name = "address", nullable = true, length = 255)
    private String address;

    @Column(name = "introduce", nullable = true, columnDefinition = "TEXT")
    private String introduce;



    @Column(name = "avatar", nullable = true, length = 255)
    private String avatar;

    @Column (name = "city")
    private  String city;


    @Column(name = "deleted_at", nullable = true)
    private Timestamp deletedAt;
    @Column(name = "company_name")
    private String companyname;

    // Constructors, getters, setters, and other methods

}
