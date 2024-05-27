package com.nachimban.web.auth.dto.response;

public record LoginResponse(
        String refreshToken,
        String accessToken
) {
}
