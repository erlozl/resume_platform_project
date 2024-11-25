package com.example.resume_platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/sign-in")
    public String signInForm() {
        return "user/signIn";
    }

    @GetMapping("/sign-up")
    public String signUpForm() {
        return "user/signUp";
    }
}
