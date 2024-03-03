package com.example.jobseeker.service;

import com.example.jobseeker.entity.OTP;
import com.example.jobseeker.entity.Role;
import com.example.jobseeker.entity.User;
import com.example.jobseeker.exception.*;
import com.example.jobseeker.model.reponse.CommonResponse;
import com.example.jobseeker.model.reponse.JwtResponse;
import com.example.jobseeker.model.reponse.UserResponse;
import com.example.jobseeker.model.reponse.UserSearchResponse;
import com.example.jobseeker.model.request.ForgetPasswordRequest;
import com.example.jobseeker.model.request.RefreshTokenRequest;
import com.example.jobseeker.model.request.RegistrationRequest;
import com.example.jobseeker.model.request.UserSearchRequest;
import com.example.jobseeker.repository.OTPJpaRepository;
import com.example.jobseeker.repository.RefreshTokenRepository;
import com.example.jobseeker.repository.RoleRepository;
import com.example.jobseeker.repository.UserRepository;
import com.example.jobseeker.repository.custom.UserCustomRepository;
import com.example.jobseeker.security.CustomUserDetails;
import com.example.jobseeker.security.JwtUtils;
import com.example.jobseeker.security.SecurityUtils;
import com.example.jobseeker.statics.Roles;
import com.example.jobseeker.statics.UserStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.mail.MessagingException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserService {
    EmailService emailService;
    final PasswordEncoder passwordEncoder;

    final UserRepository userRepository;

    final RoleRepository roleRepository;

    final ObjectMapper objectMapper;

    final RefreshTokenRepository refreshTokenRepository;

    final UserCustomRepository userCustomRepository;
     OTPJpaRepository otpJpaRepository;

    @Value("${application.security.refreshToken.tokenValidityMilliseconds}")
    long refreshTokenValidityMilliseconds;

    final JwtUtils jwtUtils;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository,
                       RoleRepository roleRepository, ObjectMapper objectMapper, OTPJpaRepository otpJpaRepository,
                       RefreshTokenRepository refreshTokenRepository, UserCustomRepository userCustomRepository, JwtUtils jwtUtils) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.objectMapper = objectMapper;
        this.refreshTokenRepository = refreshTokenRepository;
        this.userCustomRepository = userCustomRepository;
        this.jwtUtils = jwtUtils;
        this.otpJpaRepository=otpJpaRepository;

    }

    public User registerUser(RegistrationRequest registrationRequest) {
        Optional<Role> optionalRole = roleRepository.findByName(Roles.USER);
        Set<Role> roles = new HashSet<>();
        roles.add(optionalRole.get());
        User user = User.builder()
                .name(registrationRequest.getName())
                .email(registrationRequest.getEmail())
                .password(passwordEncoder.encode(registrationRequest.getPassword()))
                .phone(registrationRequest.getPhone())
                .roles(roles)
                .build();
        userRepository.save(user);
        return user;
    }
    public void sendOtp(String email) {
        emailService.sendSimpleMail(email);
    }
    public void sendAttachedMail(String email) throws MessagingException {
        emailService.sendMailWithAttachment(email);
    }

    public List<UserResponse> getAll() {
        List<User> users = userRepository.findAll();
        if (!CollectionUtils.isEmpty(users)) {
            return users.stream().map(u -> objectMapper.convertValue(u, UserResponse.class)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    public UserResponse getDetail(Long id) throws ClassNotFoundException {
        return userRepository.findById(id).map(u -> objectMapper.convertValue(u, UserResponse.class)).orElseThrow(ClassNotFoundException::new);
    }

    public JwtResponse refreshToken(RefreshTokenRequest request) throws RefreshTokenNotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        String newToken = userRepository.findById(userDetails.getId())
                .flatMap(user -> refreshTokenRepository.findByUserAndRefreshTokenAndInvalidated(user, request.getRefreshToken(), false)
                        .map(refreshToken -> {
                            LocalDateTime createdDateTime = refreshToken.getCreatedDateTime();
                            LocalDateTime expiryTime = createdDateTime.plusSeconds(refreshTokenValidityMilliseconds / 1000);
                            if (expiryTime.isBefore(LocalDateTime.now())) {
                                refreshToken.setInvalidated(true);
                                refreshTokenRepository.save(refreshToken);
                                return null;
                            }
                            return jwtUtils.generateJwtToken(authentication);
                        }))
                .orElseThrow(() -> new UsernameNotFoundException("Tài khoản không tồn tại"));


        if (newToken == null) {
            throw new RefreshTokenNotFoundException();
        }
        return JwtResponse.builder()
                .jwt(newToken)
                .build();
    }

    @Transactional
    public void logout() {
        Optional<Long> userIdOptional = SecurityUtils.getCurrentUserLoginId();
        if (userIdOptional.isEmpty()) {
            throw new UsernameNotFoundException("Tài khoản không tồn tại");
        }
        refreshTokenRepository.logOut(userIdOptional.get());
        SecurityContextHolder.clearContext();
    }

    @Transactional
    public void forgetPassword(ForgetPasswordRequest request) throws UserNotFoundException, OTPNotMatchedException,
            PasswordNotMatchedException, OTPNotFoundException, OTPExpiredException {
        OTP otp = otpJpaRepository.findByOtp(request.getOtp());
        if (ObjectUtils.isEmpty(otp)) {
            throw new OTPNotFoundException("OTP "+ request.getOtp() + " could not be found" );
        }
//        if (!request.getNewPassword().equals(request.getRenewPassword())) {
//            throw new PasswordNotMatchedException("Password don't matched");
//        }
        //kiểm tra otp còn trong thời gian sống hay không
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime expirationTime = otpJpaRepository.findByOtp(request.getOtp()).getLiveTime();
        if (currentTime.isAfter(expirationTime)) {
            throw new OTPExpiredException("OTP " + request.getOtp() + " has already expired");
        }
        User user = otp.getUser();
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        userRepository.save(user);
    }
    public String getUserName(String email) throws UserNotFoundException {
        Optional<User> userOptional = userRepository.findByEmail(email);

        if (!userOptional.isPresent()) {
            throw new UserNotFoundException("User not found for email: " );
        }

        User user = userOptional.get();
        return user.getName();
    }





    public CommonResponse<?> searchUser(UserSearchRequest request) {
        List<UserSearchResponse> users = userCustomRepository.searchUser(request);

        Integer pageIndex = request.getPageIndex();
        Integer pageSize = request.getPageSize();
        double pageNumber = Math.ceil((float) users.size() / pageSize);

        users = users.subList((pageIndex - 1) * pageSize + 1, pageIndex * pageSize + 1);

        return CommonResponse.builder()
                .pageNumber((int) pageNumber)
                .data(users)
                .build();
    }
    public void verifyAccount(Long id) {
        System.out.println(id);
        Optional<User> user = userRepository.findById(id);
        user.get().setUserStatus(UserStatus.ACTIVATED);
        userRepository.save(user.get());
    }

}
