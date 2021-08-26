package com.example.reg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/templates")
public class TemplatesController {

    @RequestMapping("/blog")
    public void blog() {}

    @RequestMapping("/blog_details")
    public void blogDetails() {}

    @RequestMapping("/index")
    public void index() {}

    @RequestMapping("/sign_in")
    public void signIn() {}

    @RequestMapping("/sign_up")
    public void signUp() {}

    @RequestMapping("/blog_write")
    public void blogWrite() {}

}
