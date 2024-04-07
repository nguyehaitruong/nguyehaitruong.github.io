package com.example.jobseeker.controller;

import com.example.jobseeker.entity.RefreshToken;
import com.example.jobseeker.entity.Role;
import com.example.jobseeker.entity.User;
import com.example.jobseeker.exception.*;
import com.example.jobseeker.model.reponse.JobResponse;
import com.example.jobseeker.model.reponse.JwtResponse;
import com.example.jobseeker.model.request.*;
import com.example.jobseeker.repository.RefreshTokenRepository;
import com.example.jobseeker.repository.RoleRepository;
import com.example.jobseeker.repository.UserRepository;
import com.example.jobseeker.security.CustomUserDetails;
import com.example.jobseeker.security.JwtUtils;
import com.example.jobseeker.service.*;
import com.example.jobseeker.statics.Roles;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api/auth")

public class AuthController {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    RefreshTokenRepository refreshTokenRepository;
    private PasswordEncoder passwordEncoder;
    private  JwtUtils jwtUtils;
    private UserService userService;
    private final EmailService emailService;
    private RecruitmentService recruitmentService;
    private OTPService otpService;





        @PostMapping("/signupCandidate")
        public ResponseEntity<?> registerCandidate(@Valid @RequestBody RegistrationRequest request) throws MessagingException {
            Optional<User> userOptional = userRepository.findByEmail(request.getEmail());

            if (userOptional.isPresent()) {
                return new ResponseEntity<>("Username is existed", HttpStatus.BAD_REQUEST);
            } else {
                User newUser = userService.registerUser(request);
                emailService.verifyAccount(newUser.getId(), request.getEmail(), request.getEmail());
                return new ResponseEntity<>(null, HttpStatus.CREATED);
            }
        }
        @PostMapping("/signupRecruiter")
        public ResponseEntity<?> registerRecruiter(@Valid @RequestBody CreateRecruiterRequest request) throws MessagingException, ExistedUserException {
            Optional<User> userOptional = userRepository.findByEmail(request.getEmail());

            if (userOptional.isPresent()) {
                return new ResponseEntity<>("Username is existed", HttpStatus.BAD_REQUEST);
            } else {
                User newUser = recruitmentService.createRecruitment(request);
                emailService.verifyAccount(newUser.getId(), request.getEmail(), request.getEmail());
                return new ResponseEntity<>(null, HttpStatus.CREATED);
            }
        }




    @PostMapping("/login")
    public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        Set<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toSet());

        String refreshToken = UUID.randomUUID().toString();
        RefreshToken refreshTokenEntity = RefreshToken.builder()
                .refreshToken(refreshToken)
                .user(userRepository.findById(userDetails.getId()).get())
                .build();
        refreshTokenRepository.save(refreshTokenEntity);

        JwtResponse response = JwtResponse.builder()
                .jwt(jwt)
                .refreshToken(refreshToken)
                .id(userDetails.getId())
                .email(userDetails.getUsername())
                .build();

        return ResponseEntity.ok(response); // Trả về mã 200 (OK) và dữ liệu phản hồi
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(@RequestBody @Valid RefreshTokenRequest request) {
        try {
            return ResponseEntity.ok(userService.refreshToken(request));
        } catch (RefreshTokenNotFoundException | UsernameNotFoundException ex) {
            return new ResponseEntity<>("Thông tin refreshToken không chính xác", HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        userService.logout();
        return ResponseEntity.ok(null);
    }
    @PostMapping("/forget-password")
    public ResponseEntity<?> forgetPassword(@RequestBody @Valid ForgetPasswordRequest request) throws UserNotFoundException,
            OTPNotMatchedException, PasswordNotMatchedException, OTPNotFoundException, OTPExpiredException {
        userService.forgetPassword(request);
        return ResponseEntity.ok(null);
    }
    @PostMapping("/otp-sending")
    public ResponseEntity<?> otpSending(@RequestBody @Valid MailRequest request) throws MessagingException, UserNotFoundException {
        String otp = otpService.createOTP(request.getEmail());
        String fullName = userService.getUserName(request.getEmail());
        emailService.otpSendingMail(fullName, request.getEmail(), otp);
        return ResponseEntity.ok(null);
    }



}