package com.nachimban.web.member.domain;

import com.nachimban.web.oauth.domain.OauthServerType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class OauthId {

    @Column(nullable = false)
    private Long oauthServerId;

    @Enumerated(EnumType.STRING)
    private OauthServerType oauthServerType;

    public OauthId(
            Long oauthServerId,
            OauthServerType oauthServerType
    ) {
        this.oauthServerId = oauthServerId;
        this.oauthServerType = oauthServerType;
    }

}
