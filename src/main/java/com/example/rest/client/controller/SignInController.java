package com.example.rest.client.controller;

import com.example.rest.client.model.Role;
import com.example.rest.client.model.User;
import com.example.rest.client.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.stream.Collectors;

@Controller
public class SignInController {
    private final UserService userService;

    @Autowired
    public SignInController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/index")
    public String log() {
        return "index";
    }

    @RequestMapping
    public String redir(Principal principal) {
        String name = principal.getName();
        User userByLogin = userService.getUserByLogin(name);
        boolean b = userByLogin.getRoles().stream().map(Role::getTitle).collect(Collectors.toSet()).contains("ROLE_ADMIN");
        if (b){
            return "redirect:/admin";
        }else {
            return "redirect:/user";
        }
    }
}
