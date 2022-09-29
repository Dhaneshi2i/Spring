package com.ideas2it.controller;

import com.ideas2it.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/Validate")
    public ModelAndView validateUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        String msg = "";
        boolean isValid = loginService.findUser(username, password);
        System.out.println("Is user valid: " + isValid);
        if (isValid) {
            msg = "Welcome " + username + "!";
        } else {
            msg = "Invalid credentials";
        }
        return new ModelAndView("result","output",msg);
    }

}
