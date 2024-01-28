package com.example.jobseeker.entity;

import javax.persistence.*;

import com.example.jobseeker.statics.UserStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends BaseEntity {

    @Column(name = "name")
    private  String name;

    @Column(name = "email", nullable = true, length = 255)
    private String email;

    @Column(name = "password", nullable = true, length = 255)
    private String password;
    @Column(name = "avatar", columnDefinition = "TEXT")
    String avatar;



    @Column(name = "gender", length = 10)
    String gender; // Sử dụng String thay vì Enum

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth")
    Date dateOfBirth;

    @Column(name = "phone")
    String phone;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @Column
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;


    @Column(name = "deleted_at", nullable = true)
    private Timestamp deletedAt;



}
