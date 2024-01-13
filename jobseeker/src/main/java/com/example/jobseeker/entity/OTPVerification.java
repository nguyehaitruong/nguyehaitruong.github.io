package com.example.jobseeker.entity;

import javax.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


import java.sql.Timestamp;

@Entity
@Table(name = "otp_verifications")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OTPVerification extends  BaseEntity{



    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;

    @ManyToOne
    @JoinColumn(name = "otp_id", nullable = false)
    OTP otp;

    @Column(name = "success")
    boolean success;

    @Column(name = "times_verification")
    int timesVerification;




}
