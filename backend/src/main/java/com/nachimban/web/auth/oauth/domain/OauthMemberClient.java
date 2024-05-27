package com.nachimban.web.auth.oauth.domain;

public interface OauthMemberClient {

    OauthServerType getOauthServerType();

    OauthMember fetch(String authCode);

}
