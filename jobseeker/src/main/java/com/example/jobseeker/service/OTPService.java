package com.example.jobseeker.service;


import com.example.jobseeker.entity.OTP;
import com.example.jobseeker.entity.User;
import com.example.jobseeker.exception.UserNotFoundException;
import com.example.jobseeker.repository.OTPJpaRepository;
import com.example.jobseeker.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class OTPService {
    private final OTPJpaRepository otpJpaRepository;
    private final UserRepository userRepository;

    private static final long OTP_EXPIRATION_MILLISECOND = 900000; //15 minutes

    public String createOTP(String email) throws UserNotFoundException {
        Random random = new Random();
        int newOTP = 10000 + random.nextInt(90000);
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (!userOptional.isPresent()) {
            throw new UserNotFoundException("User not found for email: ");



        }  User user = userOptional.get();

        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime expirationTime = currentTime.plus(OTP_EXPIRATION_MILLISECOND, ChronoUnit.MILLIS);
        OTP otpData = OTP.builder()
                .otp(String.valueOf(newOTP))
                .liveTime(expirationTime)
                .user(user)
                .build();
        otpJpaRepository.save(otpData);
        return String.valueOf(newOTP);
    }


}
