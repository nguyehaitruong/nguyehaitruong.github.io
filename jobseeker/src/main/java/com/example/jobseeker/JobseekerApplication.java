package com.example.jobseeker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync

public class JobseekerApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobseekerApplication.class, args);
	}

}
