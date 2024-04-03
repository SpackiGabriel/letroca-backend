package com.letroca.services;

import com.letroca.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    /**
     * This method is responsible for loading a user by their email address.
     *
     * @param email The email address of the user to be loaded.
     * @return UserDetails The UserDetails object representing the user with the specified email address.
     * @throws UsernameNotFoundException Thrown if no user with the specified email address is found.
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email);
    }
}
