package com.example.reg.security;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class SecurityAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private RequestCache requestCache = new HttpSessionRequestCache();
    private String targetUrlParameter;
    private String defaultUrl;
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    public SecurityAuthenticationSuccessHandler() {
        defaultUrl = "/templates/index";
    }

    public String getTargetUrlParameter() {
        return targetUrlParameter;
    }

    public SecurityAuthenticationSuccessHandler setTargetUrlParameter(String targetUrlParameter) {
        this.targetUrlParameter = targetUrlParameter;
        return this;
    }

    public String getDefaultUrl() {
        return defaultUrl;
    }

    public SecurityAuthenticationSuccessHandler setDefaultUrl(String defaultUrl) {
        this.defaultUrl = defaultUrl;
        return this;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {

        clearAuthenticationAttributes(request);
        useDefaultUrl(request, response);
    }

    private void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }

    private void useDefaultUrl(HttpServletRequest request, HttpServletResponse response) throws IOException {
        redirectStrategy.sendRedirect(request, response, defaultUrl);
    }
}