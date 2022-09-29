package com.ideas2it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Spring Web MVC Security Java Config Demo Project
 * Primary controller of the application.
 *
 * @author www.codejava.net
 *
 */
@Controller
public class MainController {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView visitHome() {
        return new ModelAndView("index");
    }

    @RequestMapping(value="/admin", method = RequestMethod.GET)
    public ModelAndView visitAdmin() {
        ModelAndView model = new ModelAndView("admin");
        model.addObject("title", "Admministrator Control Panel");
        model.addObject("message", "This page demonstrates how to use Spring security.");

        return model;
    }
}
