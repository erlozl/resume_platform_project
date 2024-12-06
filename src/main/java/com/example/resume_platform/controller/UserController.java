package com.example.resume_platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.resume_platform.dto.SignInFormDTO;
import com.example.resume_platform.dto.SignUpFormDTO;
import com.example.resume_platform.handler.exception.CustomRestException;
import com.example.resume_platform.repository.entity.User;
import com.example.resume_platform.service.UserService;
import com.example.resume_platform.utils.ApiUtil;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private HttpSession session;

    @GetMapping("/sign_in")
    public String signInForm() {
        return "user/signIn";
    }

    @PostMapping("/sign_in")
    public String signInProc(SignInFormDTO signInFormDTO) {
        // 1. 유효성검사
        if (signInFormDTO.getUserid() == null || signInFormDTO.getUserid().isEmpty()) {
            throw new CustomRestException("userId를 입력하세요", HttpStatus.BAD_REQUEST);
        }

        if (signInFormDTO.getPassword() == null || signInFormDTO.getPassword().isEmpty()) {
            throw new CustomRestException("password를 입력하세요", HttpStatus.BAD_REQUEST);
        }
        User principal = userService.signIn(signInFormDTO);
        boolean isValid = BCrypt.checkpw(signInFormDTO.getPassword(), principal.getPassword());

        if (isValid == true) {
            session.setAttribute("principal", principal);
            return "redirect:/resume/main";
        } else {
            return "redirect:/user/sign_in";
        }
    }

    @GetMapping("/sign_up")
    public String signUpForm() {
        return "user/signUp";
    }

    @PostMapping("/sign_up")
    public String signUpProc(SignUpFormDTO signUpFormDTO) {
        userService.signUp(signUpFormDTO);
        // 1. 유효성검사
        if (signUpFormDTO.getUsername() == null || signUpFormDTO.getUsername().isEmpty()) {
            throw new CustomRestException("userId를 입력하세요", HttpStatus.BAD_REQUEST);
        }

        if (signUpFormDTO.getPassword() == null || signUpFormDTO.getPassword().isEmpty()) {
            throw new CustomRestException("password를 입력하세요", HttpStatus.BAD_REQUEST);
        }

        if (signUpFormDTO.getUsername() == null || signUpFormDTO.getUsername().isEmpty()) {
            throw new CustomRestException("username을 입력하세요", HttpStatus.BAD_REQUEST);
        }
        return "redirect:/user/sign_in";
    }

    @GetMapping("/api/duplicateCheck")
    public @ResponseBody ApiUtil<String> duplicateCheck(String id) {
        User user = userService.userIdCheck(id);
        if (user != null) {
            return new ApiUtil<String>(false, "아이디가 중복되었습니다");
        }
        return new ApiUtil<String>(true, "아이디를 사용하실 수 있습니다");
    }

    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/user/sign-in";
    }

}
