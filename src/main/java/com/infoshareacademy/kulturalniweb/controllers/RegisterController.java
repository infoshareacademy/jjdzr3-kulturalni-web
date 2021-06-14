package com.infoshareacademy.kulturalniweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @GetMapping("/register")
    public String register (Model model) {
        return "register";
    }

    @PostMapping("/registerSubmit")
    public String registerSubmit() {

        return "main";
    }
}
