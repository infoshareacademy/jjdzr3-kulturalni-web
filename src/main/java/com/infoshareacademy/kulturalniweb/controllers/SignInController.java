package com.infoshareacademy.kulturalniweb.controllers;

import com.infoshareacademy.kulturalniweb.entities.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignInController {

    @GetMapping("/sign-in")
    public String signIn(Model model) {
        model.addAttribute("user", new User());
        return "sign-in.html";
    }

    @PostMapping("/sign-in")
    public String signInSubmit() {
        return "index";
    }
}
