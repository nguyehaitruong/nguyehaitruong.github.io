package com.example.petshop.repository;

import com.example.petshop.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationJpaRepository extends JpaRepository<Registration,Long> {
}
