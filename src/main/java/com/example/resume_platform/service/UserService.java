package com.example.resume_platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.example.resume_platform.dto.SignInFormDTO;
import com.example.resume_platform.dto.SignUpFormDTO;
import com.example.resume_platform.handler.exception.CustomRestException;
import com.example.resume_platform.repository.entity.User;
import com.example.resume_platform.repository.interfaces.UserRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class UserService {

    @Autowired
    HttpSession session;

    @Autowired
    UserRepository userRepository;

    public void signUp(SignUpFormDTO signUpFormDTO) {
        if (!signUpFormDTO.getPassword().equals(signUpFormDTO.getPasswordCheck())) {
            throw new CustomRestException("비밀번호와 비밀번호 확인이 일치하지 않습니다.", HttpStatus.BAD_REQUEST);
        }

        String encPassword = BCrypt.hashpw(signUpFormDTO.getPassword(), BCrypt.gensalt());

        System.err.println("입력한 패스워드 " + signUpFormDTO.getPassword());
        System.err.println("DB에 저장된 패스워드 " + encPassword);

        // User user = User.builder()
        // .username(signUpFormDTO.getUsername())
        // .password(encPassword)
        // .userid(signUpFormDTO.getUserid())
        // .build();
        signUpFormDTO.setPassword(encPassword);
        userRepository.insert(signUpFormDTO);
    }

    public User userIdCheck(String id) {
        User user = userRepository.findById(id);
        return user;
    }

    public User signIn(SignInFormDTO signInFormDTO) {
        User user = userRepository.findByUserId(signInFormDTO);
        return user;
    }

}
