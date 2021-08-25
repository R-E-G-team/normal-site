package com.example.reg.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class SecurityAccessDeniedHandler implements AccessDeniedHandler {

    private String defaultUrl;

    public SecurityAccessDeniedHandler() {
        this.defaultUrl = "/exception";
    }

    @Override
    public void handle(HttpServletRequest httpServletRequest,
                       HttpServletResponse httpServletResponse,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
        httpServletResponse.setStatus(HttpStatus.FORBIDDEN.value());
        httpServletRequest.setAttribute("errorMsg", accessDeniedException.getMessage());
        httpServletRequest.getRequestDispatcher(this.defaultUrl).forward(httpServletRequest, httpServletResponse);
    }
}