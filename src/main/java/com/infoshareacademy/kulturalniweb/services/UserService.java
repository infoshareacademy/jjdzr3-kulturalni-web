package com.infoshareacademy.kulturalniweb.services;

import com.infoshareacademy.kulturalniweb.repository.AppUserRepository;
import org.springframework.mail.MailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private MailService mailService;

    private AppUserRepository appUserRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(MailService mailService, AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
        this.mailService = mailService;
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }


}
