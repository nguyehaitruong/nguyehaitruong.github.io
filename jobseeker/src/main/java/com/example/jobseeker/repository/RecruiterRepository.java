package com.example.jobseeker.repository;

import com.example.jobseeker.entity.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruiterRepository extends JpaRepository<Recruiter, Long> {
    // Bạn có thể thêm các phương thức tùy chỉnh nếu cần
}
