package com.infoshareacademy.kulturalniweb.controllers;

import com.infoshareacademy.kulturalniweb.entities.user.User;
import com.infoshareacademy.kulturalniweb.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterUserController {

    private UserService userService;

    public RegisterUserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerSubmit(User user) {
        userService.addUser(user);
        return "sign-in.html";
    }
}
