package com.nachimban.web.auth.oauth.domain;

public interface AuthCodeRequestUrlProvider {

    OauthServerType getOauthServerType();

    String getUrl();

}
