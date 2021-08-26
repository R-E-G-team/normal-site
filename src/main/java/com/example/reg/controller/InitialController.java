package com.example.reg.controller;

import com.example.reg.dto.Users;
import com.example.reg.repository.UsersRepository;
import com.example.reg.util.SeparateHangul;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/main")
public class InitialController {

    @Autowired
    private UsersRepository usersRepository;

    @RequestMapping("/index")
    public void index(HttpSession session, Model model) {
        ServletContext application = session.getServletContext();
        String path = application.getRealPath("/resources");
        System.out.println(path);
    }

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

    @RequestMapping("/hi")
    public String ttest() {
        return "hi";
    }
}
