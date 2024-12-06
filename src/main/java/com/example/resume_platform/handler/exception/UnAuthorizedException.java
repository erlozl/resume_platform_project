package com.example.resume_platform.handler.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class UnAuthorizedException extends RuntimeException {
    private HttpStatus httpStatus;

    public UnAuthorizedException(String message, HttpStatus status) {
        super(message);
        this.httpStatus = status;
    }

}
