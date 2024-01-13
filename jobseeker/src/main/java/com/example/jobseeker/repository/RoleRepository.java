package com.example.jobseeker.repository;



import com.example.jobseeker.entity.Role;
import com.example.jobseeker.statics.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(Roles name);

}
