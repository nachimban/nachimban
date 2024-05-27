package com.nachimban.web.auth.oauth.domain;

public enum OauthServerType {
    KAKAO,
    ;

    public static OauthServerType fromName(String name) {
        return OauthServerType.valueOf(name);
    }

}
