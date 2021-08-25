package com.example.reg.security;

import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SecuritySessionExpiredStrategy implements SessionInformationExpiredStrategy {

    private String defaultUrl;

    public SecuritySessionExpiredStrategy() {
        this.defaultUrl = "/exception";
    }

    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent sessionInformationExpiredEvent) throws IOException {
        HttpServletResponse response = sessionInformationExpiredEvent.getResponse();
        response.sendRedirect(defaultUrl);
    }

}
