package com.example.reg.controller;

import com.example.reg.dto.Post;
import com.example.reg.repository.PostRepository;
import com.example.reg.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/templates")
public class TemplatesController {

    @RequestMapping("/blog")
    public void blog() {}

    @Autowired
    private PostService postService;

    @RequestMapping("/blog_details")
    public String blogDetails(Model model, HttpServletRequest request) {
//        Long postId = Long.getLong(request.getParameter("postId"));
        model.addAttribute("post", postService.loadPostByPostId(1L));
//        Post post = new Post(1L, "ttiles", "adfasdf", "/static/img/blog/details/blog-details.jpg");
//        model.addAttribute("post", post);
        return "/templates/blog_details";
    }

    @RequestMapping("/index")
    public void index() {}

    @RequestMapping("/sign_in")
    public void signIn() {}

    @RequestMapping("/sign_up")
    public void signUp() {}

    @RequestMapping("/blog_write")
    public void blogWrite() {}

}
