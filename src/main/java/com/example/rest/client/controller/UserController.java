package com.example.rest.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class UserController {
    @GetMapping("/user")
    public String getAdmin(Principal principal, Model model){
        model.addAttribute("name",principal.getName());
        return "user";
    }
}
