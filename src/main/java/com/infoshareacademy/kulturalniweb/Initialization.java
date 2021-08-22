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
        appAdmin.setPassword(passwordEncoder.encode("Admin1"));
        appAdmin.setRole("ADMIN");
        appAdmin.setEnabled(true);


        User appModerator = new User();
        appModerator.setUsername("Moderator");
        appModerator.setPassword(passwordEncoder.encode("Moderator1"));
        appModerator.setRole("MODERATOR");
        appModerator.setEnabled(true);

        userRepository.save(appAdmin);
        userRepository.save(appModerator);

    }
}
