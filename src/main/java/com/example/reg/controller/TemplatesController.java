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

    @Autowired
    private PostService postService;

    @RequestMapping("/index")
    public void index() {}

    @RequestMapping("/sign_in")
    public void signIn() {}

    @RequestMapping("/sign_up")
    public void signUp() {}

    @RequestMapping("/blog_write")
    public void blogWrite() {}

}
