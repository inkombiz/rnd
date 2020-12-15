package com.inkombizz.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("")
    private String redirectIndex(){
        return "redirect:page";
    }
    
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/dashboard")
    private String dashboard(){
        return "dashboard";
    }
}
