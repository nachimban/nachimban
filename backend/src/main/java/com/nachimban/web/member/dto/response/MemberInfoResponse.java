package com.nachimban.web.member.dto.response;

public record MemberInfoResponse(
        Long id,
        String nickname,
        String email,
        String imageUrl
) {
}
