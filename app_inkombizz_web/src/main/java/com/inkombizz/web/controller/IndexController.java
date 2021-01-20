package com.inkombizz.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inkombizz.web.config.BaseControllers;

@Controller
public class IndexController extends BaseControllers{
	
    @RequestMapping("/")
    private String redirectIndex(){
        return "redirect:/authenticate";
    }

    @RequestMapping("/dashboard")
    private String dashboard(){
		if(getBaseSession().isSession()) {
			return "dashboard";	
		}
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
		if(getBaseSession().isSession()) {
			return "redirect:/dashboard";	
		}
        return "login";
    }

    @GetMapping("/authenticate")
    public String auth() {
		if(getBaseSession().isSession()) {
			return "redirect:/dashboard";	
		}
        return "redirect:/login";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        System.out.println("Login Error");
        return "login";
    }
}
