package com.controller;
import com.domain.Dept;
import com.domain.Employee;
import com.domain.Post;
import com.domain.User;
import com.service.DeptService;
import com.service.PostService;
import com.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

}
