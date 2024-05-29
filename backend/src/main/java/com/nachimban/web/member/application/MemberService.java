package com.nachimban.web.member.application;

import com.nachimban.web.common.security.AuthorizedMember;
import com.nachimban.web.member.domain.Member;
import com.nachimban.web.member.domain.MemberRepository;
import com.nachimban.web.member.domain.Nickname;
import com.nachimban.web.member.dto.request.MemberInfoUpdateRequest;
import com.nachimban.web.member.dto.response.MemberInfoResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MemberInfoResponse getMyProfile(AuthorizedMember authorizedMember) {
        Member member = findMemberById(authorizedMember.memberId());

        return new MemberInfoResponse(
                member.getId(),
                member.getNickname(),
                member.getEmail(),
                member.getImageUrl()
        );
    }

    private Member findMemberById(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Transactional
    public void updateMyProfile(AuthorizedMember authorizedMember, MemberInfoUpdateRequest request) {
        Member member = findMemberById(authorizedMember.memberId());

        Nickname nickname = Nickname.from(request.nickname());
        validateNicknameDuplicated(nickname);

        member.changeNickname(nickname);
    }

    private void validateNicknameDuplicated(Nickname nickName) {
        if (memberRepository.existsByNickname(nickName)) {
            throw new IllegalArgumentException();
        }
    }

}
