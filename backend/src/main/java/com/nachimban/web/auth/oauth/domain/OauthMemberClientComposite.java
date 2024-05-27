package com.nachimban.web.auth.oauth.domain;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.toMap;

@Component
public class OauthMemberClientComposite {

    private final Map<OauthServerType, OauthMemberClient> mapper;

    public OauthMemberClientComposite(Set<OauthMemberClient> clients) {
        mapper = clients.stream()
                .collect(toMap(
                        OauthMemberClient::getOauthServerType,
                        identity()
                ));
    }

    public OauthMember fetch(OauthServerType oauthServerType, String authCode) {
        if (!mapper.containsKey(oauthServerType)) {
            throw new IllegalArgumentException();
        }

        return mapper.get(oauthServerType).fetch(authCode);
    }

}
