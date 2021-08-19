package com.infoshareacademy.kulturalniweb.services;

import com.infoshareacademy.kulturalniweb.models.AppUser;
import com.infoshareacademy.kulturalniweb.models.Token;
import com.infoshareacademy.kulturalniweb.repository.AppUserRepository;
import com.infoshareacademy.kulturalniweb.repository.TokenRepository;
import org.springframework.mail.MailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.UUID;

@Service
public class UserService {

    private MailService mailService;
    private TokenRepository tokenRepository;
    private AppUserRepository appUserRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(MailService mailService, TokenRepository tokenRepository, AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
        this.mailService = mailService;
        this.tokenRepository = tokenRepository;
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void addUser(AppUser appUser) {

        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUser.setRole("ROLE_USER");
        appUserRepository.save(appUser);
        sendToken(appUser);
    }
    private void sendToken(AppUser appUser){
        String tokenValue = UUID.randomUUID().toString();
        Token token = new Token();
        token.setValue(tokenValue);
        token.setAppUser(appUser);
        tokenRepository.save(token);

        String url = "http://localhost:8080/token?value=" + tokenValue;

        try {
            mailService.sendMail(appUser.getUsername(),"Potwierdź swoje konto", url, false);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
