package com.lyes.hibernate.controllers;

import com.lyes.hibernate.models.Authentication;
import com.lyes.hibernate.models.Registration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;

@Controller
public class ViewController {



    @GetMapping("/")
    public String index(Model model) {

        Principal principal =  null;
        // add `message` attribute
        model.addAttribute("message", "Thank you for visiting.");

        // return view name
        return "index" ;
    }

    @GetMapping("/courses")
    public String courses(Model model) {
        return "courses" ;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String registration(Model model) {
        Registration registration = new Registration();
        model.addAttribute("registration", registration);
        return "registration";
    }


}
