package com.controller;
import com.domain.Dept;
import com.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/")
public class DeptController {

    @Autowired
    DeptService deptService;

    @RequestMapping("listDept")//查看部门信息
    public String listDept(@ModelAttribute Dept dept, HttpServletRequest request){
        List<Dept> depts = deptService.selectDept(dept);
        request.setAttribute("depts", depts);
        return "";
    }

    @RequestMapping("addDept")//添加部门信息
    public String addDept(@ModelAttribute Dept dept) {
        int i = deptService.insertDept(dept);
        if (i != 0) {
            return "forward:/";
        } else {
            return "error";
        }
    }

    @RequestMapping("updateDept")//修改部门信息
    public String editDept(@ModelAttribute Dept dept) {
        int i = deptService.updateDept(dept);
        if (i != 0) {
            return "forward:/";
        } else {
            return "error";
        }
    }

    @RequestMapping("deleteDept")//删除部门信息
    public String deleteDept(@RequestParam(value = "idNo") int id){
        deptService.deleteDeptById(id);
        return "frorward:/";
    }
}
