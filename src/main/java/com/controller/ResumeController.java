package com.controller;

import com.domain.Resume;
import com.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/")
public class ResumeController {
    @Autowired
    ResumeService resumeService;

    @RequestMapping("listResume")//查看员工信息
    public String listResume(@ModelAttribute Resume resume, HttpServletRequest request){
        List<Resume> resumes = resumeService.selectResume(resume);
        request.setAttribute("employees", resumes);
        return "";
    }

    @RequestMapping("addResume")//发布招聘信息
    public String addResume(@ModelAttribute Resume resume) {
        int i = resumeService.insertResume(resume);
        if (i != 0) {
            return "forward:/";
        } else {
            return "error";
        }
    }

    @RequestMapping("updateResume")//修改员工信息
    public String editResume(@ModelAttribute Resume resume) {
        int i = resumeService.updateResume(resume);
        if (i != 0) {
            return "forward:/listjob";
        } else {
            return "error";
        }
    }

}
