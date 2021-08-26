package com.example.reg.security;

import com.example.reg.dto.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class SecurityUserDetailsController {

    @Autowired
    private SecurityUserDetailsService securityUserDetailsService;

    @RequestMapping("/sign_in")
    public void signIn() {}

    @RequestMapping("/sign_in_action")
    public void signInAction() {}

    @RequestMapping("/sign_up")
    public void signUp() {}

    @RequestMapping("/sign_up_action")
    public String signUpAction(String id, String password) {
        Users users = new Users();
        users.setUserId(id);
        users.setUserPassword(password);
        securityUserDetailsService.insertUser(users);
        return "sign_in";
    }
}
