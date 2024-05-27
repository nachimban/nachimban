package com.nachimban.web.auth.oauth.domain;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.toMap;

@Component
public class AuthCodeRequestUrlProviderComposite {

    private final Map<OauthServerType, AuthCodeRequestUrlProvider> mapper;

    public AuthCodeRequestUrlProviderComposite(Set<AuthCodeRequestUrlProvider> providers) {
        mapper = providers.stream()
                .collect(toMap(
                        AuthCodeRequestUrlProvider::getOauthServerType,
                        identity()
                ));
    }

    public String getUrl(OauthServerType oauthServerType) {
        return getProvider(oauthServerType).getUrl();
    }

    public AuthCodeRequestUrlProvider getProvider(OauthServerType oauthServerType) {
        if (!mapper.containsKey(oauthServerType)) {
            throw new IllegalArgumentException();
        }

        return mapper.get(oauthServerType);
    }

}
