package com.example.rest.client.controller;

import com.example.rest.client.model.User;
import com.example.rest.client.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserDeleteController {
    private final UserService daoService;

    @Autowired
    public UserDeleteController(UserService daoService) {
        this.daoService = daoService;
    }

    @GetMapping("/delete")
    public String getLogin(@RequestParam("id") int id){

        User userByLogin = daoService.finUserById(id);
        daoService.deleteUser(userByLogin);
        return "redirect:/admin";
    }
}
