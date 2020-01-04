package com.controller;
import com.domain.Post;
import com.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PostController {

    @Autowired
    PostService postService;
}
