package com.example.jobseeker.repository;

import com.example.jobseeker.entity.OTP;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OTPJpaRepository extends JpaRepository<OTP, Long> {

    OTP findByOtp(String otp);


}
