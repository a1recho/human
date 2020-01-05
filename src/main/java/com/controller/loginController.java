package com.controller;

import com.domain.Dept;
import com.domain.Post;
import com.domain.User;
import com.service.DeptService;
import com.service.PostService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/")
public class loginController {
    @Autowired
    UserService userService;
    @RequestMapping("checkLogin")

   public String checkLogin(@ModelAttribute User user){
        User u = userService.selectUserByUsername(user.getUsername());
        if(u.getPassword().equals(user.getPassword())){
            if(u.getRole()==0) {
                return "manage";
            }else
                return "user";
        }
        return "error";
   }
}
