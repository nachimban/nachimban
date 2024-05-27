package com.nachimban.web.auth.oauth.domain.kakao;

import com.nachimban.web.auth.oauth.domain.kakao.dto.KakaoToken;
import com.nachimban.web.auth.oauth.domain.OauthMember;
import com.nachimban.web.auth.oauth.domain.OauthMemberClient;
import com.nachimban.web.auth.oauth.domain.OauthServerType;
import com.nachimban.web.auth.oauth.domain.kakao.dto.KakaoMemberResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Component
public class KakaoMemberClient implements OauthMemberClient {

    private final KakaoApiClient kakaoApiClient;
    private final KakaoProperties kakaoProperties;

    public KakaoMemberClient(KakaoApiClient kakaoApiClient, KakaoProperties kakaoProperties) {
        this.kakaoApiClient = kakaoApiClient;
        this.kakaoProperties = kakaoProperties;
    }

    @Override
    public OauthServerType getOauthServerType() {
        return OauthServerType.KAKAO;
    }

    @Override
    public OauthMember fetch(String authCode) {
        MultiValueMap<String, String> params = createTokenRequestParams(authCode);

        KakaoToken token = kakaoApiClient.fetchToken(params);
        KakaoMemberResponse response = kakaoApiClient.fetchMember(
                token.tokenType() + " " + token.accessToken()
        );

        return response.extract();
    }

    private MultiValueMap<String, String> createTokenRequestParams(String authCode) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

        params.add("grant_type", "authorization_code");
        params.add("client_id", kakaoProperties.clientId());
        params.add("redirect_uri", kakaoProperties.redirectUri());
        params.add("code", authCode);
        params.add("client_secret", kakaoProperties.clientSecret());

        return params;
    }
}
