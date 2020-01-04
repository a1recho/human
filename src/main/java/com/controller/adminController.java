package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.domain.Employee;
import com.domain.Recruitment;
import com.service.DeptService;
import com.service.EmployeeService;
import com.service.PostService;
import com.service.RecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/")
public class adminController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    RecruitmentService recruitmentService;
    @Autowired
    PostService postService;
    @Autowired
    DeptService deptService;


    @RequestMapping("listUser")//查看员工信息
    public String listUser(@ModelAttribute Employee employee, HttpServletRequest request){
        List<Employee> employees = employeeService.selectEmployee(employee);
        request.setAttribute("employees", employees);
        return "listuser";
    }

    @RequestMapping("updateUserInformation")//修改员工信息
    public String updateUserInformation(@ModelAttribute Employee employee){
        int i = employeeService.updateEmployee(employee);
        return "forward:/listUser";
    }

    @RequestMapping("delete")//删除员工信息
    public String delete(@RequestParam(value = "idNo") int id){
        employeeService.deleteEmployeeById(id);
        return "forward:/listUser";
    }

    @RequestMapping("addUserInformation")//添加员工信息
    public String addUserInformation(@ModelAttribute Employee employee){
        employee.setDeptId(deptService.selectDeptByDeptName(employee.getDeptName()).getId());
        employee.setPostId(postService.selectPostByPostName(employee.getPostName()).getId());
        employeeService.insertEmployee(employee);
        return "forward:/listUser";
    }

    @RequestMapping("recruitment")//发布招聘信息
    public String recruitment(@ModelAttribute Recruitment recruitment){
       recruitmentService.insertRecruitment(recruitment);
       return "addSuccess";
    }

    @RequestMapping("selectInformation")//模糊查询员工信息
    public String selectInformation(@ModelAttribute Employee employee, HttpServletRequest request) {

        List<Employee> employees = employeeService.selectEmployee(employee);
        request.setAttribute("employees", employees);
        return "result";
    }

}
