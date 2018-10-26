package com.example.rest.client.controller;


import com.example.rest.client.model.User;
import com.example.rest.client.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class UserShowController {
    private final UserService userService;

    @Autowired
    public UserShowController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String getString(Model model) {
        List<User> users = userService.loadAllUsers();
        model.addAttribute("users", users);
        return "show";
    }

}
