package com.infoshareacademy.kulturalniweb;

import com.infoshareacademy.kulturalniweb.entities.user.User;
import com.infoshareacademy.kulturalniweb.repository.UserRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Initialization {

    public Initialization(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        User appAdmin = new User();
        appAdmin.setUsername("Admin");
        appAdmin.setEmail("aplikacjakulturalni@gmail.com");
        appAdmin.setPassword(passwordEncoder.encode("Admin1"));
        appAdmin.setRole("ADMIN");
        appAdmin.setEnabled(true);

        userRepository.save(appAdmin);
    }
}
