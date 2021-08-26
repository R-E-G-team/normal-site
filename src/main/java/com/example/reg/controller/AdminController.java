package com.example.reg.controller;

import com.example.reg.dto.Users;
import com.example.reg.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @Autowired
    private UsersRepository usersRepository;

    @RequestMapping("/templates/admin")
    public void admin(Model model) {
        model.addAttribute("users", usersRepository.findAll());
    }

    @RequestMapping("/main/modify")
    public void modify(Model model, String usersNo) {
        Users users = usersRepository.findById(Long.parseLong(usersNo)).orElse(null);
        model.addAttribute("users", users);
    }

    @RequestMapping("/modify_action")
    public String modifyAction(Model model, String usersNo, String usersName) {
        Users users = usersRepository.findById(Long.parseLong(usersNo)).orElse(null);
        users.setUserName(usersName);
        usersRepository.save(users);
        return "main/exit";
    }
}