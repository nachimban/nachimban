package com.nachimban.web.auth.support;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.util.Collections;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Component
public class BearerAuthorizationExtractor {

    private static final String BEARER_TYPE = "Bearer";

    public String extract(HttpServletRequest request) {
        return Collections.list(request.getHeaders(AUTHORIZATION))
                .stream()
                .filter(this::isBearerType)
                .map(this::extractAuthHeaderValue)
                .findFirst()
                .orElse(null);
    }

    private boolean isBearerType(String value) {
        return value.toLowerCase().startsWith(BEARER_TYPE.toLowerCase());
    }

    private String extractAuthHeaderValue(String value) {
        return value.substring(BEARER_TYPE.length()).trim();
    }

}
