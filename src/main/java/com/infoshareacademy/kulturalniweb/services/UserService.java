package com.infoshareacademy.kulturalniweb.services;

import com.infoshareacademy.kulturalniweb.entities.user.User;
import com.infoshareacademy.kulturalniweb.entities.user.Token;
import com.infoshareacademy.kulturalniweb.repository.UserRepository;
import com.infoshareacademy.kulturalniweb.repository.TokenRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.UUID;

@Service
public class UserService {

    private MailService mailService;
    private TokenRepository tokenRepository;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(MailService mailService, TokenRepository tokenRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.mailService = mailService;
        this.tokenRepository = tokenRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void addUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        userRepository.save(user);
        sendToken(user);
    }
    private void sendToken(User user) {
        String tokenValue = UUID.randomUUID().toString();
        Token token = new Token();
        token.setValue(tokenValue);
        token.setAppUser(user);
        tokenRepository.save(token);

        String url = "http://localhost:8080/token?value=" + tokenValue;

        try {
            mailService.sendMail(user.getUsername(), "Aktywuj swoje konto",
                    "Kliknij w podany link, aby aktywować konto: " + url, false);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
