package com.example.reg.config;

import com.example.reg.security.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired private SecurityAuthenticationFailureHandler securityAuthenticationFailureHandler;
    @Autowired private SecurityAuthenticationSuccessHandler securityAuthenticationSuccessHandler;
    @Autowired private SecurityAuthenticationEntryPoint securityAuthenticationEntryPoint;
    @Autowired private SecurityAccessDeniedHandler securityAccessDeniedHandler;
    @Autowired private SecuritySessionExpiredStrategy securitySessionExpiredStrategy;
    @Autowired private SecurityAuthenticationProvider securityAuthenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .anyRequest().permitAll().and();

        http.formLogin()
                .loginPage("/sign_in")
                .usernameParameter("id").passwordParameter("password")
                .successHandler(securityAuthenticationSuccessHandler.setDefaultUrl("/"))
                .failureHandler(securityAuthenticationFailureHandler).and();

        http.exceptionHandling()
                .accessDeniedHandler(securityAccessDeniedHandler)
                .authenticationEntryPoint(securityAuthenticationEntryPoint).and();

        http.sessionManagement()
                .maximumSessions(1)
                .maxSessionsPreventsLogin(false)
                .expiredSessionStrategy(securitySessionExpiredStrategy).and();

        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and();

        http.headers().cacheControl().and()
                .frameOptions().and()
                .contentTypeOptions().and()
                .httpStrictTransportSecurity().maxAgeInSeconds(31536000).includeSubDomains(true).and()
                .contentSecurityPolicy("default-src 'self';").and()
                .contentSecurityPolicy("font-src 'self' https://use.typekit.net;").and()
                .contentSecurityPolicy(" img-src 'self' https://p.typekit.net https://media.vlpt.us;");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(securityAuthenticationProvider);
    }

    @Override
    public void configure(WebSecurity web) {
        //이미지, 자바스크립트, css 디렉토리 보안 설정
    }
}

