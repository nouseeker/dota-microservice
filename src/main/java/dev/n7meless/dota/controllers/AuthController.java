package dev.n7meless.dota.controllers;

import dev.n7meless.dota.model.User;
import dev.n7meless.dota.security.UserDetailsServiceImpl;
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
