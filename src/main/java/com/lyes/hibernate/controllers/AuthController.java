package com.lyes.hibernate.controllers;

import com.lyes.hibernate.models.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @PostMapping("/login")
    public String login(Authentication auth){
        System.out.println(auth.getEmail());
        System.out.println(auth.getPassword());
        return "login";
    }
}
