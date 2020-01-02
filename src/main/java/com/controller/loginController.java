package com.controller;

import com.domain.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class loginController {
    @Autowired
    UserService userService;
    @RequestMapping("checkLogin")

   public String checkLogin(@ModelAttribute User user){
        User u = userService.selectUserByUsername(user.getUsername());
        if(u.getPassword().equals(user.getPassword())){
            System.out.println(u.getRole());
            System.out.println(u.getId());
            if(u.getRole()==0)
                return "manage";
            else
                return "user";
        }
        return "error";
   }
}
