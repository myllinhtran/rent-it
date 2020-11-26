package com.rentit.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping(path = "/")
    @ResponseBody
    public String index() {
        return "index";
    }


    @RequestMapping(path = "/login")
    public String login() {
        return "You have logged in.";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "Error with logging in.";
    }
}
