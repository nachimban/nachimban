package com.nachimban.web.auth.oauth.application;

import com.nachimban.web.auth.oauth.domain.OauthMember;
import com.nachimban.web.auth.oauth.domain.OauthMemberClientComposite;
import com.nachimban.web.auth.oauth.domain.OauthServerType;
import com.nachimban.web.member.domain.Member;
import com.nachimban.web.member.domain.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OauthService {
    private final OauthMemberClientComposite oauthMemberClientComposite;
    private final MemberRepository memberRepository;

    public OauthService(
            OauthMemberClientComposite oauthMemberClientComposite,
            MemberRepository memberRepository
    ) {
        this.oauthMemberClientComposite = oauthMemberClientComposite;
        this.memberRepository = memberRepository;
    }

    public Long login(OauthServerType oauthServerType, String authCode) {
        OauthMember oauthMember = oauthMemberClientComposite.fetch(oauthServerType, authCode);

        return memberRepository.findByOauthId(oauthMember.getOauthId())
                .orElseGet(() -> register(oauthMember))
                .getId();
    }

    private Member register(OauthMember oauthMember) {
        Member member = Member.of(
                oauthMember.getOauthId(),
                oauthMember.getNickname(),
                oauthMember.getEmail(),
                oauthMember.getProfileImageUrl()
        );

        return memberRepository.save(member);
    }

}
