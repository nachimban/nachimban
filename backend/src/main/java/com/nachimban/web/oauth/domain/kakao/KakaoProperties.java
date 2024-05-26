package com.nachimban.web.oauth.domain.kakao;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "oauth.kakao")
public record KakaoProperties(
        String redirectUri,
        String clientId,
        String clientSecret,
        String[] scope
) {
}
