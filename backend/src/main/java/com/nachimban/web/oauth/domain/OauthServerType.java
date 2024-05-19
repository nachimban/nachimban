package com.nachimban.web.oauth.domain;

public enum OauthServerType {
    KAKAO,
    ;

    public static OauthServerType fromName(String name) {
        return OauthServerType.valueOf(name);
    }

}
