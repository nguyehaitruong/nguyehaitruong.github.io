package com.example.jobseeker.controller;

import com.example.jobseeker.model.reponse.UserResponse;
import com.example.jobseeker.model.request.UserSaveRequest;
import com.example.jobseeker.model.request.UserSearchRequest;
import com.example.jobseeker.service.UserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {

    UserService userService;

    @PostMapping("/{email}/otp-sending")
    public void sendOtp(@PathVariable String email) {
        userService.sendOtp(email);
    }

    @PostMapping("/{email}/attach-file")
    public void sendAttachedFileMail(@PathVariable String email) throws MessagingException {
        userService.sendAttachedMail(email);
    }

    /**
     * DEMO APIs
     */

    @GetMapping
    public List<UserResponse> getUsers(UserSearchRequest userSearchRequest) {
        return Collections.emptyList();
    }

    @PostMapping
    public UserResponse createUser(@RequestBody @Valid UserSaveRequest userSaveRequest) {
        return new UserResponse();
    }

    @PutMapping("/{id}")
    public UserResponse updateUser(@PathVariable Long id, @RequestBody @Valid UserSaveRequest userSaveRequest) {
        return new UserResponse();
    }

    @DeleteMapping("/{id}")
    public UserResponse deleteUser(@PathVariable Long id) {
        return new UserResponse();
    }





}
