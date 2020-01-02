package com.controller;

import com.domain.Employee;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/")
public class adminController {
    @Autowired
    EmployeeService employeeService;
    @RequestMapping("listUser")
    public String listUser(@ModelAttribute Employee employee, HttpServletRequest request){
        List<Employee> employees = employeeService.selectEmployee(employee);
        request.setAttribute("employees", employees);
        return "listuser";
    }
}
