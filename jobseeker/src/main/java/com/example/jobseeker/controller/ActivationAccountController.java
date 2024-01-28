package com.example.jobseeker.controller;

import com.example.jobseeker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ActivationAccountController {

    private final UserService userService;

    @Autowired
    public ActivationAccountController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/accounts/{id}/activation")
    public String getAccountActivationPage(@PathVariable Long id, Model model) {
        userService.verifyAccount(id);
        return "redirect:/";
    }
}
