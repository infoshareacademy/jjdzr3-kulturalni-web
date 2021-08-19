package com.infoshareacademy.kulturalniweb.controllers;

import com.infoshareacademy.kulturalniweb.models.AppUser;
import com.infoshareacademy.kulturalniweb.models.Token;
import com.infoshareacademy.kulturalniweb.repository.AppUserRepository;
import com.infoshareacademy.kulturalniweb.repository.TokenRepository;
import com.infoshareacademy.kulturalniweb.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private TokenRepository tokenRepository;
    private AppUserRepository appUserRepository;
    private UserService userService;


    public UserController(TokenRepository tokenRepository, AppUserRepository appUserRepository, UserService userService) {
        this.tokenRepository = tokenRepository;
        this.appUserRepository = appUserRepository;
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new AppUser());
        return "register";
    }

    @PostMapping("/register")
    public String signUp(AppUser appUser) {
        userService.addUser(appUser);
        return "sign-in";
    }

    @GetMapping("/sign-in")
    public String signIn(Model model) {
        model.addAttribute("user", new AppUser());
        return "sign-in";
    }

    @GetMapping("/token")
    public String sendToken(@RequestParam String value) {
        Token byValue = tokenRepository.findByValue(value);
        AppUser appUser = byValue.getAppUser();
        appUser.setEnabled(true);
        appUserRepository.save(appUser);
        return "hello";
    }
}
