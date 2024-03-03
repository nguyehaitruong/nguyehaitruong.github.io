package com.example.jobseeker.controller.anonymous;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "client/index";
    }

    @GetMapping("//register-employer")
    public String showRegisterPage() {return "client/register-employers";}
    @GetMapping("/login")
    public String login() {
        return "client/login-employers";
    }
    @GetMapping("/register-candidate")
    public String showRegisterEmployeesPage() {return "client/register-employees";}
    @GetMapping("/forgot-password")
    public String showForgotPasswordPage() {return "client/otp-forgot-password";}
    @GetMapping("/reset-password")
    public String redirectToExternalPage() {
        return "client/forgot-password";
    }





}
