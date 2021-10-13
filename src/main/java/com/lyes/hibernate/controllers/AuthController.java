package com.lyes.hibernate.controllers;

import com.lyes.hibernate.entities.User;
import com.lyes.hibernate.models.Authentication;
import com.lyes.hibernate.models.Registration;
import com.lyes.hibernate.services.LyrnerUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AuthController {

    @Autowired
    LyrnerUserDetailsService userDetailsService;

    @GetMapping("/afterLogin")
    public String login(Model model){
        System.out.println("Is authenticated "+SecurityContextHolder.getContext().getAuthentication().isAuthenticated());
        if(SecurityContextHolder.getContext().getAuthentication().isAuthenticated()){
            model.addAttribute("auth", SecurityContextHolder.getContext().getAuthentication());
            return "index";
        }else{
            return "login";
        }
    }

    @PostMapping("/registration")
    public String registration(Registration registration){
        // validation process

        // persist in database
        if(userDetailsService.addUser(new User(registration.getUsername(), registration.getPassword(), registration.getPseudo(), registration.getEmail()))){
            return "validateEmail";
        }else{
            return "registration";
        }

    }
}
