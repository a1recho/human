package com.controller;

import com.domain.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class loginUpController {
    @Autowired
    UserService userService;
    @RequestMapping("loginUp")
    public String loginUp(@ModelAttribute User user){
       if(!"".equals(user.getUsername())&&!"".equals(user.getPassword())&&!"".equals(user.getRePassword())){
           if(user.getPassword().equals(user.getRePassword())) {
               User u = userService.selectUserByUsername(user.getUsername());
               if (u == null) {
                   int i = userService.insertUser(user);
                   if (i == 1)
                       return "index";
               } else
                   return "loginUpError";
           }else{
               return "loginUpError";
           }
       }
       return "loginUpError";
    }
}
