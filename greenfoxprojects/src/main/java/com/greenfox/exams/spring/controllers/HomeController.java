package com.greenfox.exams.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by regnisalram on 1/11/17.
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping("")
    public String index() {
        return "redirect:/welcome";
    }

}