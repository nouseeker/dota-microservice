package com.example.dota.controllers;

import com.example.dota.model.User;
import com.example.dota.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private UserDetailsServiceImpl userDetailsSecurity;

    @Autowired
    public AuthController(UserDetailsServiceImpl userDetailsSecurity) {
        this.userDetailsSecurity = userDetailsSecurity;
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/registration")
    public String getRegistrPage() {
        return "registration";
    }

    @PostMapping("/registration")
    public String postRegistrationPage(User user) {
        System.out.println("try to save user....");
        userDetailsSecurity.saveUser(user);
        return "redirect:/auth/login";
    }
}
