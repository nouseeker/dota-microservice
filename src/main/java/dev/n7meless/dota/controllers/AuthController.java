package com.example.dota.controllers;

import com.example.dota.model.User;
import com.example.dota.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

//@Controller
@RequestMapping("/auth")
public class AuthController {
    private UserDetailsServiceImpl userDetailsSecurity;

//    @Autowired
    public AuthController(UserDetailsServiceImpl userDetailsSecurity) {
        this.userDetailsSecurity = userDetailsSecurity;
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/registration")
    public String getRegPage(@ModelAttribute("user") @Valid User user) {
        return "registration";
    }


    @PostMapping("/login")
    public String postLoginPage(User user) {
        System.out.println("try to save user....");
        return "redirect:/auth/login";
    }

    @PostMapping("/registration")
    public String postRegistrationPage(@ModelAttribute("user") User user) {
        System.out.println("try to save user....");
        return "redirect:/counterpick";

    }
}
