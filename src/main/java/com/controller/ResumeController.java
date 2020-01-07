package com.controller;

import com.domain.Post;
import com.domain.Recruitment;
import com.domain.Resume;
import com.domain.R2r;
import com.service.PostService;
import com.service.R2rService;
import com.service.RecruitmentService;
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
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/")
public class ResumeController {
    @Autowired
    ResumeService resumeService;
    @Autowired
    R2rService r2rService;
    @Autowired
    PostService postService;
    @Autowired
    RecruitmentService recruitmentService;

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

        while (resumeIterator.hasNext()){/*判断是否有重复投递简历信息
        */
            Resume next = resumeIterator.next();
            if(next.getUserId()==userId){//通过用户Id查找到应聘的Id
                int id1 = next.getId();
                List<R2r> r2rs = r2rService.selectR2r(r2r);
                Iterator<R2r> iterator = r2rs.iterator();
                while (iterator.hasNext()){/*到R2R表中查找是否已经存在*/
                    R2r r = iterator.next();
                    if(r.getResumeId()==id1&&!"".equals(r.getRecruitmentId())){
                        return "pushResumeFalse";
                    }
                }
            }
        }

        Integer[] array = new Integer[1000];/*存放userId*/
        for(int i=0;i<resumeList.size();i++){/*判断是否添加了简历信息*/
            Resume resume1 = resumeList.get(i);
            array[i]=resume1.getUserId();/*将userId存到数组*/
        }
       if(Arrays.asList(array).contains(userId)==false)/*判断简历表是否有该用户的信息*/
           return "pushResumeFalse";


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
        Resume re =new Resume();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("userId")) {
                System.out.println(cookie.getValue());
                List<Resume> resumes = resumeService.selectResume(re);/*添加之前先查询，若已经存在，返回错误*/
                System.out.println(resumes);
                Iterator<Resume> iterator = resumes.iterator();
                while (iterator.hasNext()){
                    Resume next = iterator.next();
                    if(next.getUserId()==Integer.parseInt(cookie.getValue()))
                        return "addResumeError";
                }
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

    @RequestMapping("deletePushResume/{idNo}/{PostName}")//拒绝应聘
    public String deletePushResume(@PathVariable(value = "idNo") int id,@PathVariable(value = "PostName") String postName){
        R2r r2r =new R2r();
        Recruitment recruitment =new Recruitment();
       List<R2r> r2rs = r2rService.selectR2r(r2r);
       List<Recruitment> recruitments= recruitmentService.selectRecruitment(recruitment);
        Iterator<Recruitment> recruitmentIterator = recruitments.iterator();
        Iterator<R2r> r2rIterator = r2rs.iterator();
        /*while(r2rIterator.hasNext()){*//*循环r2r表*//*
            R2r r2r1 = r2rIterator.next();
            if(r2r1.getResumeId()==id){*//*表中的应聘id和传入id相同，记录该id*//*
              int ids  =  r2r1.getId();
                while(recruitmentIterator.hasNext()){*//*循环招聘表，找到招聘职位和传入职位相同，得到该id，再到r2r表通过该id寻找表id，根据表id删除该记录*//*
                    Recruitment recruitment1 = recruitmentIterator.next();
                    if(recruitment1.getPostName().equals(postName)){
                        int id1 = recruitment1.getId();
                        if(r2r1.getRecruitmentId()==id1){
                           int ids2 = r2r1.getId();
                           if(ids==ids2){
                               r2rService.deleteR2rById(r2r1.getId());
                               return "refuseSuccess";
                           }
                        }
                    }
                }
            }
        }*/
        /*拒绝应聘2.0*/
        Integer[] resume_id =new Integer[1000];/*存放r2r表中resune对应的id，也就是传值用户简历id*/
        for(int i=0;i<r2rs.size();i++){
            R2r r = r2rs.get(i);
            resume_id[i]=r.getId();
        }
        Integer[] recruitment_id =new Integer[1000];/*存放招聘表中传过来职位对应的id*/
        int n=0;
        for (int j=0;j<recruitments.size();j++){
            Recruitment recruitment1 = recruitments.get(j);
            if(recruitment1.getPostName().equals(postName)){/*在招聘表中查找职位对应的Id*/
                recruitment_id[n]=recruitment1.getId();
                n++;
                //System.out.println( recruitment_id[n-1]);
            }
        }
        Integer[] recruitment_id2=new Integer[1000];/*存放r2r表中recruitment_id对应的id，也就是传职位值所对应用户的id，再通过该id在r2r表中查找*/
        List<Integer> integers = Arrays.asList(recruitment_id);
        for(int i=0;i<r2rs.size();i++){
            R2r r = r2rs.get(i);
            for(int j=0;j<integers.size();j++){
                Integer integer = integers.get(j);
                if(integers.get(j)==null)
                    break;
               // System.out.println(integers.get(j));
                if(r.getRecruitmentId()==integer){
                     recruitment_id2[j]= r.getId();
                }
            }
        }

        List<Integer> integers1 = Arrays.asList(resume_id);/*对比两个数组是否有相等的值*/
        List<Integer> integers2 = Arrays.asList(recruitment_id2);
        for(int m=0;m<r2rs.size();m++){
            for(int i=0;i<integers1.size();i++){
                Integer integer = integers1.get(i);
                for(int j=0;j<integers2.size();j++){
                    Integer integer1 = integers2.get(j);
                    System.out.println(integers2.get(j));
                    if(integer==integer1){
                        r2rService.deleteR2rById(integer);
                        return "refuseSuccess";
                    }
                }
            }
        }


        //System.out.println(id+postName);
               return "refuseSuccess";
    }
}
