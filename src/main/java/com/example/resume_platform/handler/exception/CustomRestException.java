package com.example.resume_platform.handler.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class CustomRestException extends RuntimeException {
    private HttpStatus httpStatus;

    public CustomRestException(String message, HttpStatus status) {
        super(message);
        this.httpStatus = status;
    }

}
