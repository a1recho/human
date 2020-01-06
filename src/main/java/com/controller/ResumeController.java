package com.controller;

import com.domain.Recruitment;
import com.domain.Resume;
import com.domain.R2r;
import com.service.R2rService;
import com.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/")
public class ResumeController {
    @Autowired
    ResumeService resumeService;
    @Autowired
    R2rService r2rService;

    @RequestMapping("listResume")//查看简历信息
    public String listResume(@ModelAttribute Resume resume, HttpServletRequest request){
        List<Resume> resumes = resumeService.selectResume(resume);
        request.setAttribute("resumes", resumes);
        return "listResume";
    }

    @RequestMapping("listResumeForUser")//我的应聘信息
    public String listResumeForUser(@ModelAttribute Resume resume,@ModelAttribute R2r r2r, HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("userId")) {
                resume.setUserId(Integer.parseInt(cookie.getValue()));
            }
        }
        List<Resume> resumes = resumeService.selectResume(resume);
        request.setAttribute("resumes", resumes);
        return "listResume";
    }

    @RequestMapping("listPushedResume")//查看已投递的简历
    public String listPushedResume(HttpServletRequest request){
        List<Resume> resumes = resumeService.getPushedResume();
        request.setAttribute("resumes", resumes);
        return "listPushedResume";
    }

    @RequestMapping("pushResume/{id}")//向招聘投递简历
    public String pushResume(@PathVariable int id, HttpServletRequest request){
        R2r r2r =new R2r();
        Resume resume =new Resume();
        List<Resume> resumeList = resumeService.selectResume(resume);
        Iterator<Resume> resumeIterator = resumeList.iterator();

        r2r.setRecruitmentId(id);
        int userId = 0;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("userId")) {
                userId=(Integer.parseInt(cookie.getValue()));
            }
        }

        while (resumeIterator.hasNext()){
            Resume next = resumeIterator.next();
            if(next.getUserId()==userId){
                int id1 = next.getId();
                List<R2r> r2rs = r2rService.selectR2r(r2r);
                Iterator<R2r> iterator = r2rs.iterator();
                while (iterator.hasNext()){
                    R2r r = iterator.next();

                    if(r.getResumeId()==id1&&!"".equals(r.getRecruitmentId())){
                        return "pushResumeFalse";
                    }
                }
            }

        }

        resume.setUserId(userId);
        List<Resume> resumes =resumeService.selectResume(resume);
        for (Resume resume1 :resumes){
            r2r.setResumeId(resume1.getId());
        }
        r2rService.insertR2r(r2r);
        return "pushResumeSuccess";

    }

    @RequestMapping("addResume")//添加简历信息
    public String addResume(@ModelAttribute Resume resume,HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("userId")) {
                resume.setUserId(Integer.parseInt(cookie.getValue()));
            }
        }
            int i = resumeService.insertResume(resume);
            if (i != 0) {
                return "forward:/listResume";
            } else {
                return "error";
            }
        }

    @RequestMapping("updateResume")//修改简历信息
    public String editResume(@ModelAttribute Resume resume) {
        int i = resumeService.updateResume(resume);
        if (i != 0) {
            return "forward:/listResume";
        } else {
            return "error";
        }
    }

    @RequestMapping("deleteResume/{id}")//删除简历信息
    public String deleteResume(@PathVariable int id){
        resumeService.deleteResumeById(id);
        return "deleteResumeSuccess";
    }

}
