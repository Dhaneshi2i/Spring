package com.ideas2it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @GetMapping("/")
    public ModelAndView welComePage() {
        return new ModelAndView("welcomePage");
    }

    @GetMapping("/homePage")
    public ModelAndView homePage() {
        return new ModelAndView("homePage");
    }

    @GetMapping("/loginPage")
    public ModelAndView loginPage(@RequestParam(value = "error",required = false) String error,
                                  @RequestParam(value = "logout",required = false) String logout) {
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error","Invalid Credentials");
            //return new ModelAndView("loginPage","error","Invalid credentials");
        }

        if (logout != null) {
            model.addObject("message","logged out");
            //return new ModelAndView("loginPage","message","logged out");
        }
        model.setViewName("loginPage");
        return model;
    }
}
