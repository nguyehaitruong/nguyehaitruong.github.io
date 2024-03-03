package com.example.jobseeker.repository;


import com.example.jobseeker.entity.Job;
import com.example.jobseeker.entity.Recruiter;
import com.example.jobseeker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    // Các phương thức truy vấn tùy chọn có thể được thêm vào đây nếu cần
    Optional<Recruiter> findByRecruiterId(Long userId);

    List<Job> findByTitleContainingOrDescriptionContainingOrLocationContaining(String title, String description, String location);

}
