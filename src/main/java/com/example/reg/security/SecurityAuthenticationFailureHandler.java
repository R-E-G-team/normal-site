package com.example.reg.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;

@Log
@Component
public class SecurityAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private String id;
    private String password;
    private String exceptionMsg;
    private String defaultFailureUrl;

    public SecurityAuthenticationFailureHandler(){
        this.id = "id";
        this.password = "password";
        this.exceptionMsg = "exceptionMsg";
        this.defaultFailureUrl = "/templates/sign_in";
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException authenticationException)
            throws IOException, ServletException {
        String loginid = request.getParameter(id);
        String loginpasswd = request.getParameter(password);

        request.setAttribute(id, loginid);
        request.setAttribute(password, loginpasswd);
        request.setAttribute(exceptionMsg, authenticationException.getMessage());
        request.setAttribute("errorMsg", "아이디 또는 비밀번호가 일치하지 않습니다.");
        request.getRequestDispatcher(defaultFailureUrl).forward(request, response);
    }
}
