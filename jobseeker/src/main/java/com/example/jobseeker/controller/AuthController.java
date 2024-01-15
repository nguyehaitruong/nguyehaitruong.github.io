package com.example.jobseeker.controller;

import com.example.jobseeker.entity.RefreshToken;
import com.example.jobseeker.entity.Role;
import com.example.jobseeker.entity.User;
import com.example.jobseeker.model.reponse.JwtResponse;
import com.example.jobseeker.model.request.LoginRequest;
import com.example.jobseeker.repository.RefreshTokenRepository;
import com.example.jobseeker.repository.RoleRepository;
import com.example.jobseeker.repository.UserRepository;
import com.example.jobseeker.security.CustomUserDetails;
import com.example.jobseeker.security.JwtUtils;
import com.example.jobseeker.statics.Roles;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
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




    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody User user) {


        // add check for email exists in DB
        if (userRepository.existsByEmail(user.getEmail())) {
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        // Set encoded password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Tìm kiếm Role trong roleRepository với tên là "ROLE_USER"
        Optional<Role> optionalRole = roleRepository.findByName(Roles.USER);

// Kiểm tra xem Role có tồn tại hay không
        if (optionalRole.isPresent()) {
            // Nếu tìm thấy Role, lấy giá trị Role từ Optional
            Role defaultRole = optionalRole.get();

            // Đặt Role cho người dùng
            user.setRoles(Collections.singleton(defaultRole));
        } else {
            // Nếu không tìm thấy, ném ngoại lệ với thông báo lỗi
            throw new RuntimeException("Default role not found");
        }


        userRepository.save(user);

        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }
    @PostMapping("/login")
    public JwtResponse authenticateUser(@Valid @RequestBody LoginRequest request) {
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

        return JwtResponse.builder()
                .jwt(jwt)
                .refreshToken(refreshToken)
                .id(userDetails.getId())
                .email(userDetails.getUsername())
                .roles(roles)
                .build();
    }

}