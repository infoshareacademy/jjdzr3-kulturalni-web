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
        appAdmin.setEmail("email@buziaczek.pl");
        appAdmin.setPassword(passwordEncoder.encode("Admin1"));
        appAdmin.setRole("ADMIN");
        appAdmin.setEnabled(true);

        userRepository.save(appAdmin);

        User testUser = new User();
        testUser.setUsername("user");
        testUser.setEmail("costam@costam.pl");
        testUser.setPassword(passwordEncoder.encode("user"));
        testUser.setRole("USER");
        testUser.setEnabled(true);


        userRepository.save(testUser);
    }
}
