package com.example.ForesightFin.controller;

import com.example.ForesightFin.entity.User;
import com.example.ForesightFin.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user) {

        userService.registerUser(user);

        return "login";
    }
}
