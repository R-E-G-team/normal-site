package com.example.reg.service;

import com.example.reg.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private MemberRepository memberRepository;

    public void test() {
        memberRepository.findAll();
    }
}
