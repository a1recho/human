package com.controller;

import com.domain.Recruitment;
import com.service.RecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/")
public class RecruitmentController {
    @Autowired
    RecruitmentService recruitmentService;

    @RequestMapping("listRecruitment")//查看已发布的招聘信息
    public String listRecruitment(@ModelAttribute Recruitment recruitment, HttpServletRequest request){
        List<Recruitment> recruitments = recruitmentService.selectRecruitment(recruitment);
        request.setAttribute("employees", recruitments);
        return "listjob";
    }

    @RequestMapping("recruitment")//发布招聘信息
    public String addRecruitment(@ModelAttribute Recruitment recruitment) {
        int i = recruitmentService.insertRecruitment(recruitment);
        if (i != 0) {
            return "forward:/listjob";
        } else {
            return "error";
        }
    }

    @RequestMapping("updateRecruitment")//修改招聘信息
    public String editRecruitment(@ModelAttribute Recruitment recruitment) {
        int i = recruitmentService.updateRecruitment(recruitment);
        if (i != 0) {
            return "forward:/listjob";
        } else {
            return "error";
        }
    }

    @RequestMapping("deleteRecruitment")//删除招聘信息
    public String deleteRecruitment(@RequestParam(value = "idNo") int id){
        int i = recruitmentService.deleteRecruitmentById(id);
        if (i != 0) {
            return "forward:/listjob";
        } else {
            return "error";
        }
    }

}
