package com.example.rest.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class ErrorController {
    @RequestMapping("/err")
    public String error(){
        return "err";
    }
}
