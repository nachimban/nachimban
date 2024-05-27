package com.nachimban.web.auth.oauth.domain.kakao;

import com.nachimban.web.auth.oauth.domain.AuthCodeRequestUrlProvider;
import com.nachimban.web.auth.oauth.domain.OauthServerType;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class KakaoAuthCodeRequestUrlProvider implements AuthCodeRequestUrlProvider {

    private final KakaoProperties kakaoProperties;

    public KakaoAuthCodeRequestUrlProvider(KakaoProperties kakaoProperties) {
        this.kakaoProperties = kakaoProperties;
    }

    @Override
    public OauthServerType getOauthServerType() {
        return OauthServerType.KAKAO;
    }

    @Override
    public String getUrl() {
        return UriComponentsBuilder
                .fromUriString("https://kauth.kakao.com/oauth/authorize")
                .queryParam("response_type", "code")
                .queryParam("client_id", kakaoProperties.clientId())
                .queryParam("redirect_uri", kakaoProperties.redirectUri())
                .queryParam("scope", String.join(",", kakaoProperties.scope()))
                .toUriString();
    }

}
