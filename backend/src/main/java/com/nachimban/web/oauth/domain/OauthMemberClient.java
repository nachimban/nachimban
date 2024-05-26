package com.nachimban.web.oauth.domain;

public interface OauthMemberClient {

    OauthServerType getOauthServerType();

    OauthMember fetch(String authCode);

}
