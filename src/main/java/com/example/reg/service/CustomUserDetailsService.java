package com.example.reg.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        if(username.equals("test")) {
//            return new SecurityUser(username, Arrays.asList("ROLE_ADMIN"));
//        } else {
//            return null;
//        }
        return null;
    }
}
