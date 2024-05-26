package com.nachimban.web.oauth.domain;

import com.nachimban.web.member.domain.OauthId;
import lombok.Getter;

@Getter
public class OauthMember {

    private String nickname;
    private String email;
    private String profileImageUrl;
    private OauthId oauthId;

    private OauthMember(
            String nickname,
            String email,
            String profileImageUrl,
            OauthId oauthId
    ) {
        this.nickname = nickname;
        this.email = email;
        this.profileImageUrl = profileImageUrl;
        this.oauthId = oauthId;
    }

    public static OauthMember of(
            String nickname,
            String email,
            String profileImageUrl,
            Long oauthServerId,
            OauthServerType oauthServerType
    ) {
        return new OauthMember(
                nickname,
                email,
                profileImageUrl,
                OauthId.of(oauthServerId, oauthServerType)
        );
    }

}
