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

    @GetMapping("/jd-page")
    public String jdPage() {
        return "client/jd-page";
    }
    @GetMapping("/register")
    public String showRegisterPage() {return "client/register-employers";}
    @GetMapping("/login")
    public String login() {
        return "client/login-employers";
    }

}
