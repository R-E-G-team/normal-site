package com.example.reg.repository;

import com.example.reg.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface MemberRepository extends JpaRepository<Users, Long> {

    ArrayList<Users> findByUserId(String id);

    Long findByRoleName(String roleName);
}
