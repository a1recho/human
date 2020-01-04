package com.controller;

import com.domain.Resume;
import com.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ResumeController {
    @Autowired
    ResumeService resumeService;


}
