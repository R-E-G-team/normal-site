package com.example.reg.controller;

import com.example.reg.util.SeparateHangul;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class InitialController {

    @RequestMapping("/index")
    public void index(Model model) { }

    @RequestMapping("sign_in")
    public void signIn() {}

    @RequestMapping("/success")
    public void success() {}

    @PostMapping("/auth")
    public String postAuth() {
        return "auth";
    }

    @GetMapping("/auth")
    public String getAuth() {
        return "auth";
    }

    @RequestMapping("testa")
    public void testa() {}

    @RequestMapping("testb")
    public void testb() {}
}
