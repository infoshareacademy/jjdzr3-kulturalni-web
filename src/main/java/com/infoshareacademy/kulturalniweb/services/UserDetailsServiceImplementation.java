package com.infoshareacademy.kulturalniweb.services;

import com.infoshareacademy.kulturalniweb.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).get();

        /*map(this::map)
                .orElseThrow(() -> new UsernameNotFoundException("User: " + username + "does not exist"));*/
    }
}
