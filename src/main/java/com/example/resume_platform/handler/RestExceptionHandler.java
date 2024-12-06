package com.example.resume_platform.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.resume_platform.handler.exception.CustomRestException;
import com.example.resume_platform.handler.exception.UnAuthorizedException;
import com.example.resume_platform.utils.Script;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(CustomRestException.class)
    public String error(CustomRestException e) {
        return Script.back(e.getMessage());
    }

    @ExceptionHandler(UnAuthorizedException.class)
    public String AuthError(UnAuthorizedException e) {
        return Script.href(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public void exception(Exception e) {
        System.out.println("------------");
        System.out.println(e.getClass().getName());
        System.out.println(e.getMessage());
        System.out.println("------------");
    }
}
