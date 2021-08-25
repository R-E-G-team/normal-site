package com.example.reg.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import lombok.extern.java.Log;

@Component
@Log
public class SecurityAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private SecurityUserDetailsService securityUserDetailsService;
	
	private AntPathMatcher pathMatcher = new AntPathMatcher();

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String loginId = authentication.getName();
		String password = (String) authentication.getCredentials();
		UserDetails user = null;
		Collection<? extends GrantedAuthority> authorities = null;
		try {
			// 사용자를 조회한다.
			user = securityUserDetailsService.loadUserByUsername(loginId);

			if (user == null || !bCryptPasswordEncoder.matches(password, user.getPassword())){
				throw new BadCredentialsException("Bad credentials");
			}
			authorities = user.getAuthorities();
		} catch(UsernameNotFoundException e) {
			throw new UsernameNotFoundException(e.getMessage());
		} catch(BadCredentialsException e) {
			throw new BadCredentialsException(e.getMessage());
		} catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}

		return new UsernamePasswordAuthenticationToken(user, password, authorities);
	}

	@Override
	public boolean supports(Class<?> auth) {
		return auth.equals(UsernamePasswordAuthenticationToken.class);
	}
}