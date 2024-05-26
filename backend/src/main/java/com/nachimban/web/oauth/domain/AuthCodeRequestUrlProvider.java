package com.nachimban.web.oauth.domain;

public interface AuthCodeRequestUrlProvider {

    OauthServerType getOauthServerType();

    String getUrl();

}
