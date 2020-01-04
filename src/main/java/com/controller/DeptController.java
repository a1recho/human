package com.controller;
import com.domain.Dept;
import com.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DeptController {

    @Autowired
    DeptService deptService;
}
