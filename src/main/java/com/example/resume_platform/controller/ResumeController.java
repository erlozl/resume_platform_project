package com.example.resume_platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("resume")
public class ResumeController {

    @GetMapping("/save")
    public String resumeSaveForm() {
        return "resume/resumeSave";
    }

    @GetMapping("/update")
    public String resumeUpdateForm() {
        return "resume/resumeUpdate";
    }

    @GetMapping("/list")
    public String resumeListForm() {
        return "resume/resumeList";
    }

    @GetMapping("/main")
    public String resumeMainForm() {
        return "main";
    }
}
