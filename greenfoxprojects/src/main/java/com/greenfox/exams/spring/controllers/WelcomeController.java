package com.greenfox.exams.spring.controllers;

import com.greenfox.exams.spring.models.Entry;
import com.greenfox.exams.spring.services.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;

/**
 * Created by regnisalram on 1/11/17.
 */
@Controller
@RequestMapping(value = "/welcome")
public class WelcomeController {

    private WelcomeService service;

    @Autowired
    public WelcomeController(WelcomeService service) {
        this.service = service;
    }

    @GetMapping(value={"", "/"})
    public String index(Model model) {
        model.addAttribute("entry", new Entry());
        return "index";
    }

    @PostMapping(value={"", "/"})
        public String addEntry(@RequestParam String experience,
                               @RequestParam Integer scale,
                               @RequestParam String email) {
        if (service.validate(experience, scale, email)) {
            service.create(experience, scale, email);
            return "redirect:/welcome/thanks";
        } else {
            return "redirect:/welcome";
        }
    }

    @GetMapping(value = "/thanks")
    public String thankYou(Model model) {
        model.addAttribute("projects", service.listProjects());
        return "thank_you";
    }
}
