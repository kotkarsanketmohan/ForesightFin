package com.example.ForesightFin.controller;

import com.example.ForesightFin.entity.User;
import com.example.ForesightFin.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    private final UserRepository userRepository;

    public PageController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, Authentication auth) {

        User user = userRepository
                .findByEmail(auth.getName())
                .orElseThrow();

        model.addAttribute("username", user.getFullName());

        return "dashboard";
    }
}
