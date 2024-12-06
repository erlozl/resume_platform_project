package com.example.resume_platform.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpFormDTO {
    private String username;
    private String password;
    private String passwordCheck;
    private String userid;
}
