package com.onlineshop.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {


    @GetMapping("/")
    public ModelAndView homePage(){
        return new ModelAndView("index.html");
    }

}
