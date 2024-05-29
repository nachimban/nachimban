package com.nachimban.web.member.presentation;

import com.nachimban.web.common.security.AuthorizedMember;
import com.nachimban.web.member.application.MemberService;
import com.nachimban.web.member.dto.request.MemberInfoUpdateRequest;
import com.nachimban.web.member.dto.response.MemberInfoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/api/members")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/my/profiles")
    public ResponseEntity<MemberInfoResponse> getMyProfile(AuthorizedMember authorizedMember) {
        MemberInfoResponse response = memberService.getMyProfile(authorizedMember);

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/my/profiles")
    public ResponseEntity<Void> changeNickname(
            AuthorizedMember authorizedMember,
            @RequestBody MemberInfoUpdateRequest request
    ) {
        memberService.updateMyProfile(authorizedMember, request);

        return ResponseEntity.ok().build();
    }
}
