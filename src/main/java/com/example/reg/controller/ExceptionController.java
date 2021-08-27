package com.example.reg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {

    @RequestMapping("/exceptions")
    public String exceptions() {
        return "/templates/exceptions";
    }

    @RequestMapping("/error/errorView")
    public void errorView() {

    }
}
