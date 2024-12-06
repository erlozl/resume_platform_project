package com.example.resume_platform.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import com.example.resume_platform.handler.exception.CustomPageException;

@ControllerAdvice
public class PageExceptionHandler {
    public ModelAndView handleRunTimeException(CustomPageException e) {
        ModelAndView mv = new ModelAndView("errorPage");
        mv.addObject("statusCode", HttpStatus.NOT_FOUND.value());
        mv.addObject("message", e.getMessage());
        return mv;
    }

}
