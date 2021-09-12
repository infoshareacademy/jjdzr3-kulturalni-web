package com.infoshareacademy.kulturalniweb.controllers;

import com.infoshareacademy.kulturalniweb.entities.user.Token;
import com.infoshareacademy.kulturalniweb.entities.user.User;
import com.infoshareacademy.kulturalniweb.repository.TokenRepository;
import com.infoshareacademy.kulturalniweb.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TokenController {

    private TokenRepository tokenRepository;
    private UserRepository userRepository;


    public TokenController(TokenRepository tokenRepository, UserRepository userRepository) {
        this.tokenRepository = tokenRepository;
        this.userRepository = userRepository;

    }

    @GetMapping("/token")
    public String sendToken(@RequestParam String value) {
        Token byValue = tokenRepository.findByValue(value);
        User user = byValue.getAppUser();
        user.setEnabled(true);
        userRepository.save(user);
        return "sign-in";
    }
}
