package com.example.reg.security;

import com.example.reg.dto.Users;
import com.example.reg.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


@Service
public class SecurityUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository memberRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        ArrayList<Users> userAuthes = memberRepository.findByUserId(id);
        if (userAuthes.size() == 0) {
            throw new UsernameNotFoundException("User " + id + " Not Found!");
        }
        return new SecurityUser(userAuthes);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public void insertUser(Users users) {
        users.setUserPassword(bCryptPasswordEncoder.encode(users.getUserPassword()));
        memberRepository.save(users);
    }
}