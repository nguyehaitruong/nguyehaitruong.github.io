package com.example.jobseeker.controller;

import com.example.jobseeker.entity.Role;
import com.example.jobseeker.entity.User;
import com.example.jobseeker.repository.RoleRepository;
import com.example.jobseeker.repository.UserRepository;
import com.example.jobseeker.statics.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository,
                          RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;

    }


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

}