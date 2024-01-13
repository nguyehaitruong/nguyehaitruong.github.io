package com.example.jobseeker.config;

import com.example.jobseeker.entity.Role;
import com.example.jobseeker.entity.User;
import com.example.jobseeker.repository.RoleRepository;
import com.example.jobseeker.repository.UserRepository;
import com.example.jobseeker.statics.Roles;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DatabaseInitializer implements CommandLineRunner {

    UserRepository userRepository;

    RoleRepository roleRepository;
    PasswordEncoder passwordEncoder;


    @Override
    public void run(String... args) throws Exception {

        Optional<Role> roleUserOptional = roleRepository.findByName(Roles.USER);
        if (roleUserOptional.isEmpty()) {
            Role userRole = Role.builder().name(Roles.USER.name()).build();
            roleRepository.save(userRole);
        }

        Optional<Role> userUserOptional = roleRepository.findByName(Roles.ADMIN);
        if (userUserOptional.isEmpty()) {
            Role adminRole = Role.builder().name(Roles.ADMIN.name()).build();
            roleRepository.save(adminRole);

            Optional<User> admin = userRepository.findByEmail("admin");
            if (admin.isEmpty()) {
                User user = new User();
                user.setEmail("admin");
                user.setPassword(passwordEncoder.encode("admin123")); // Encrypt the password
                Set<Role> roles = new HashSet<>();
                roles.add(adminRole);
                user.setRoles(roles);
                userRepository.save(user);
            }

        }

    }

}
