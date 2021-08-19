package com.infoshareacademy.kulturalniweb;

import com.infoshareacademy.kulturalniweb.models.AppUser;
import com.infoshareacademy.kulturalniweb.repository.AppUserRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Initialization {

    public Initialization(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
        AppUser appAdmin = new AppUser();
        appAdmin.setUsername("Admin");
        appAdmin.setPassword(passwordEncoder.encode("Admin1"));
        appAdmin.setRole("ROLE_ADMIN");
        appAdmin.setEnabled(true);


        AppUser appModerator = new AppUser();
        appModerator.setUsername("Moderator");
        appModerator.setPassword(passwordEncoder.encode("Moderator1"));
        appModerator.setRole("ROLE_USER");
        appModerator.setEnabled(true);

        appUserRepository.save(appAdmin);
        appUserRepository.save(appModerator);

    }
}
