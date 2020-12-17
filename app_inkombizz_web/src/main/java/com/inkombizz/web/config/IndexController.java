package com.inkombizz.web.config;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    private String redirectIndex(){
        return "redirect:/login";
    }

    @RequestMapping("/dashboard")
    private String dashboard(){
        return "dashboard";
    }

    @GetMapping("/login")
    public String login(Principal principal) {
        if (principal != null) {
            return "redirect:/dashboard";
        }
        return "login";
    }

    @PostMapping("/authenticate")
    public String auth(Principal principal) {
        if (principal != null) {
            return "redirect:/dashboard";
        }
        return "login";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        System.out.println("Login Error");
        return "login";
    }

    @GetMapping("/logout")
    public String afterLogout(Model model) {
        model.addAttribute("logout", true);
        return "login";
    }
}
