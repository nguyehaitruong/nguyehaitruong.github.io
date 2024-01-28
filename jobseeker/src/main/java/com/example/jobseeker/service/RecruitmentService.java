package com.example.jobseeker.service;

import com.example.jobseeker.entity.Job;
import com.example.jobseeker.entity.Recruiter;
import com.example.jobseeker.entity.Role;
import com.example.jobseeker.entity.User;
import com.example.jobseeker.exception.ExistedUserException;
import com.example.jobseeker.model.request.CreateRecruiterRequest;
import com.example.jobseeker.model.request.JobRequest;
import com.example.jobseeker.repository.JobRepository;
import com.example.jobseeker.repository.RecruiterRepository;
import com.example.jobseeker.repository.RoleRepository;
import com.example.jobseeker.repository.UserRepository;
import com.example.jobseeker.statics.Roles;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.validation.Valid;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class RecruitmentService {

    private final JobRepository jobRepository;
    private UserRepository userRepository;
    private RecruiterRepository recruiterRepository;
    private RoleRepository roleRepository;
    final PasswordEncoder passwordEncoder;

    @Transactional
    public User createRecruitment(CreateRecruiterRequest request) throws ExistedUserException {
        Optional<User> userOptional = userRepository.findByEmail(request.getEmail());
        if (!userOptional.isEmpty()) {
            throw new ExistedUserException();
        }

        Set<Role> roles = roleRepository.findByName(Roles.RECTUITER).stream().collect(Collectors.toSet());

        User user = User.builder()
                .email(request.getEmail())
                .phone(request.getPhone())
                .name(request.getName())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(roles)
                .build();
       userRepository.save(user);

       Recruiter recruiter=Recruiter.builder()
               .user(user)
               .address(request.getAddress())
               .companyname((request.getCompanyname()))
               .city(request.getCity())
               .build();

       recruiterRepository.save(recruiter);
       return user;
    }

    public void createJob(@Valid JobRequest jobRequest) {
        Recruiter recruiter = null;

        if (jobRequest.getRecruiterId() != null) {
            recruiter = recruiterRepository.findById(jobRequest.getRecruiterId()).get();
        }


        Job job = Job.builder()
                .recruiter(recruiter)
                .title(jobRequest.getTitle())
                .workType(jobRequest.getWorkType())
                .location(jobRequest.getLocation())
                .literacy(jobRequest.getLiteracy())
                .benefits(jobRequest.getBenefits())
                .closeDateTime(jobRequest.getCloseDateTime())
                .details(jobRequest.getDetails())
                .yoeFrom(jobRequest.getYoeFrom())
                .salary(jobRequest.getSalary())
                .publishDateTime(jobRequest.getPublishDateTime())
                .yoeTo(jobRequest.getPublishDateTime())
                .dueDateTime(jobRequest.getDueDateTime())
                .status(jobRequest.getStatus())
                .build();

        //create a new course

        jobRepository.save(job);
    }

}


