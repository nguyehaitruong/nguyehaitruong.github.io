package com.example.jobseeker.service;

import com.example.jobseeker.Util.FileUtil;
import com.example.jobseeker.entity.Application;
import com.example.jobseeker.entity.Job;
import com.example.jobseeker.entity.User;
import com.example.jobseeker.exception.UnsupportedFormatException;
import com.example.jobseeker.exception.UserNotFoundException;
import com.example.jobseeker.model.request.ApplicationRequest;
import com.example.jobseeker.repository.ApplicationRepository;
import com.example.jobseeker.repository.UserRepository;
import com.example.jobseeker.security.SecurityUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final UserRepository userRepository;
    public List<Application> getCandidatesForJob(Job job) {
        return applicationRepository.findByJob(job);
    }

    public void saveApplication(ApplicationRequest request, MultipartFile cvImage) throws UnsupportedFormatException, IOException {
        // Thư mục chứa hình ảnh CV
        String cvDataPath = "cv_data" + File.separator + "image";
        File cvDataDirectory = new File(cvDataPath);

// Kiểm tra xem thư mục đã tồn tại chưa
        if (!cvDataDirectory.exists()) {
            // Nếu không tồn tại, tạo mới
            if (cvDataDirectory.mkdirs()) {
                System.out.println("Thư mục đã được tạo thành công.");
            } else {
                System.err.println("Không thể tạo thư mục.");
                // Xử lý trường hợp không thể tạo thư mục
            }
        }

        String cvImageDB = null;

        // Check if CV image is provided
        if (cvImage != null && !cvImage.isEmpty()) {
            // Check the format of the uploaded CV image
            if (!FileUtil.isValidImageFormat(cvImage.getOriginalFilename())) {
                throw new UnsupportedFormatException("CV image formats are not supported");
            }
            // Save the CV image to the filesystem
            String cvFileName = StringUtils.cleanPath(cvImage.getOriginalFilename());
            cvImageDB = FileUtil.getFileNameWithTime(cvFileName);
            String cvImagePath = "cv_data" + File.separator + "image" + File.separator + cvImageDB;
            try (InputStream cvImageInputStream = cvImage.getInputStream()) {
                Files.copy(cvImageInputStream, Paths.get(cvImagePath), StandardCopyOption.REPLACE_EXISTING);
            }
        }
        Optional<Long> currentUserIdOptional = SecurityUtils.getCurrentUserLoginId();

        Long currentUserId = currentUserIdOptional.orElse(null); // Cho phép null

        User currentUser;
        if (currentUserId == null) {
            // Nếu không có ID người dùng, gán ID mặc định là 1 của admin
            currentUser = userRepository.findById(1L)
                    .orElseThrow(() -> new RuntimeException("Admin user not found")); // Ném ngoại lệ nếu không tìm thấy admin
        } else {
            currentUser = userRepository.findById(currentUserId)
                    .orElse(new User()); // Sử dụng giá trị mặc định khi không tìm thấy người dùng
        }

// Build Application object
        Application application = Application.builder()
                .user(currentUser)
                .job(request.getJob())
                .cv(cvImageDB) // Set CV image URL
                .build();




        // Check if the request contains ID for updating an existing application
        if (!ObjectUtils.isEmpty(request.getId())) {
            Optional<Application> optionalApplication = applicationRepository.findById(request.getId());
            if (optionalApplication.isPresent()) {
                Application existingApplication = optionalApplication.get();
                existingApplication.setUser(request.getUser());
                existingApplication.setJob(request.getJob());
                existingApplication.setCv(cvImageDB); // Update CV image URL
                applicationRepository.save(existingApplication);
            } else {
                throw new IllegalArgumentException("Application with ID " + request.getId() + " not found");
            }
        } else {
            // Save a new application
            applicationRepository.save(application);
        }
    }
}
