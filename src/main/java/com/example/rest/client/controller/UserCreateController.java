package com.example.rest.client.controller;

import com.example.rest.client.model.Role;
import com.example.rest.client.model.User;
import com.example.rest.client.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserCreateController {
    private final
    UserService userService;

    @Autowired
    public UserCreateController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/create")
    public String getString() {
        return "create";
    }

    @PostMapping("/addUser")
    public String saveUser(@RequestParam("login") String login,
                           @RequestParam("password") String password,
                           @RequestParam("roles") String[] role,
                           @RequestParam("email") String email) {
        List<Role> roles = new ArrayList<>();
        for (String s : role)
            roles.add(new Role(s));
        User u = new User(login, password, email, roles);
        userService.save(u);
        return "redirect:/admin";

    }
}
