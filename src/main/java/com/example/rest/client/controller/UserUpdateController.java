package com.example.rest.client.controller;


import com.example.rest.client.model.Role;
import com.example.rest.client.model.User;
import com.example.rest.client.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserUpdateController {
    private final
    UserService userService;

    @Autowired
    public UserUpdateController(UserService daoService) {
        this.userService = daoService;
    }

    @GetMapping("/update")
    public String getUpdate(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userService.finUserById(id));
        return "update";
    }

    @PostMapping("/updateUser")
    public String getUserParam(@RequestParam("login") String login,
                               @RequestParam("password") String password,
                               @RequestParam("id") int id,
                               @RequestParam("email") String email,
                               @RequestParam("roles") String[] roles) {
        List<Role> role = new ArrayList<>();
        for (String s : roles)
            role.add(new Role(s));
        User user = new User(id, login, password, email, role);
        userService.updateUser(user);
        return "redirect:/admin";

    }
}
