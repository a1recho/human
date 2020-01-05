package com.controller;

import com.domain.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class loginController {
    @Autowired
    UserService userService;
    @RequestMapping("checkLogin")

   public String checkLogin(@ModelAttribute User user, HttpServletResponse response) {
        User u = userService.selectUserByUsername(user.getUsername());
        if (u.getPassword().equals(user.getPassword())) {
            if (u.getRole() == 0) {
                Cookie cookie = new Cookie("userId",Integer.toString(u.getId()));
                cookie.setMaxAge(60);
                response.addCookie(cookie);
                return "manage";
            }
            else {
                Cookie cookie = new Cookie("userId",Integer.toString(u.getId()));
                cookie.setMaxAge(60);
                response.addCookie(cookie);
                return "user";
            }
        }
        return "error";
    }
   @RequestMapping("loginOut")
   public String loginOut(){
       return "index";
    }
   }

