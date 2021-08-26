package com.example.reg.service;

import com.example.reg.dto.Users;
import com.example.reg.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UsersService {

    @Autowired private UsersRepository usersRepository;

    public void signUp(Users users) {
        users.setRoleName("ROLE_USER");
        usersRepository.save(users);
    }
}
