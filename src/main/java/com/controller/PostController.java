package com.controller;
import com.domain.Post;
import com.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/")
public class PostController {

    @Autowired
    PostService postService;

    @RequestMapping("listPost")//查看职位信息
    public String listDept(@ModelAttribute Post post, HttpServletRequest request){
        List<Post> posts = postService.selectPost(post);
        request.setAttribute("posts", posts);
        return "";
    }

    @RequestMapping("addPost")//添加职位信息
    public String addPost(@ModelAttribute Post post) {
        int i = postService.insertPost(post);
        if (i != 0) {
            return "forward:/";
        } else {
            return "error";
        }
    }

    @RequestMapping("updatePost")//修改职位信息
    public String editPost(@ModelAttribute Post post) {
        int i = postService.updatePost(post);
        if (i != 0) {
            return "forward:/";
        } else {
            return "error";
        }
    }

    @RequestMapping("deletePost")//删除部门信息
    public String deletePost(@RequestParam(value = "idNo") int id){
        postService.deletePostById(id);
        return "frorward:/";
    }
}
