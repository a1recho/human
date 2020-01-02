package com.controller;
import com.domain.User;
import com.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired UserService userService;

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

}
