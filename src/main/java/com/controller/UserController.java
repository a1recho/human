package com.controller;
import com.domain.*;
import com.service.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired UserService userService;
    @Autowired
    PostService postService;
    @Autowired
    DeptService deptService;
    @Autowired
    ResumeService resumeService;
    @Autowired
    RecruitmentService recruitmentService;
    @Autowired
    R2rService r2rService;

    @RequestMapping("userList")
    public String selectUser(User user,Model model){
        List<User> list = userService.selectUser(user);
        model.addAttribute("list",list);
        return "user";
    }

    @RequestMapping("addUser")
    public String addUser(User user){
        if(userService.insertUser(user) != 0){
            return "user";
        }else{
            return "error";
        }
    }

    @RequestMapping("updateUser")
    public String updateUser(User user){
        if(userService.updateUser(user) != 0){
            return "user";
        }else{
            return "error";
        }
    }

    @RequestMapping("deleteUser")
    public String deleteUser(int id){
        if(userService.deleteUserById(id) != 0){
            return "user";
        }else{
            return "error";
        }
    }

    @RequestMapping("selectPd")//select下拉框,添加信息用
    public String selectPd(@ModelAttribute Post post, @ModelAttribute Dept dept, HttpServletRequest request){
        List<Post> posts = postService.selectPost(post);
        request.setAttribute("posts",posts);
        List<Dept> depts = deptService.selectDept(dept);
        request.setAttribute("depts",depts);
        return "adduser";
    }

    @RequestMapping("myPush")/*查看已经投的简历*/
    public String myPush(HttpServletRequest request, @ModelAttribute Resume resume,@ModelAttribute R2r r2r,@ModelAttribute Recruitment recruitment){
        Integer[] no =new Integer[1000];
        int n=0;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {/*通过用户id获取到简历的id*/
            if (cookie.getName().equals("userId")) {
                int value = Integer.parseInt(cookie.getValue());
                List<Resume> resumes = resumeService.selectResume(resume);
                Iterator<Resume> iterator = resumes.iterator();
                while (iterator.hasNext()){
                    Resume next = iterator.next();
                    if(next.getUserId()==value){
                        int id = next.getId();/*获得的简历id*/
                        List<R2r> r2rs = r2rService.selectR2r(r2r);
                        Iterator<R2r> iterator1 = r2rs.iterator();/*再去r2r表里查找已经投过简历的id*/
                        while (iterator1.hasNext()){
                            R2r next1 = iterator1.next();
                            if(next1.getResumeId()==id){
                                no[n]=  next1.getRecruitmentId();/*把找到的id存到数组里*/
                                n++;
                            }
                        }
                    }
                }
            }

    }
        List<Integer> integers = Arrays.asList(no);/*把数组转化为list集合*/
        List<Recruitment> recruitments = recruitmentService.selectRecruitment(recruitment);
       // Recruitment[] recruitments1=new Recruitment[1000];
        List<Recruitment> recruitmentList =new ArrayList<>();/*这个集合用来存放在招聘表里和上面在r2r找到id所对应的id*/
        int m=0;
        for(int i=0;i<recruitments.size();i++){/*然后就在招聘表里去对比*/
            Recruitment recruitment1 = recruitments.get(i);
           for(int j=0;j<integers.size();j++){
               if(integers.get(j)==null)
                   break;
               if(recruitment1.getId()==integers.get(j)){
                 //  System.out.println("haha"+integers.get(j));
                   recruitmentList.add(m, recruitments.get(j));/*拿到这个id对应的一条信息，存到集合*/
                   m++;
               }
           }
        }
        request.setAttribute("recruitmentList",recruitmentList);
        return "myPushList";
    }
}
