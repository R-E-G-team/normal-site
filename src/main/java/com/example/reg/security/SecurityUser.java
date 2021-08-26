package com.example.reg.security;

import com.example.reg.dto.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class SecurityUser implements UserDetails {
    private ArrayList<Users> users;

    public SecurityUser(ArrayList<Users> userAuthes) {
        this.users = userAuthes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (int x = 0; x < users.size(); x++) {
            authorities.add(new SimpleGrantedAuthority(users.get(x).getRoleName()));
        }
        return authorities;
    }

    @Override
    public String getPassword() { //유저 비밀번호
        return users.get(0).getUserPassword();
    }

    @Override
    public String getUsername() {// 유저 이름 혹은 아이디
        return users.get(0).getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {// 유저 아이디가 만료 되었는지
        return true;
    }

    @Override
    public boolean isAccountNonLocked() { // 유저 아이디가 Lock 걸렸는지
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { //비밀번호가 만료 되었는지
        return true;
    }

    @Override
    public boolean isEnabled() { // 계정이 활성화 되었는지
        return true;
    }
}