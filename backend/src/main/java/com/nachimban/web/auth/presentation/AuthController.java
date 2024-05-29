package com.nachimban.web.auth.presentation;

import com.nachimban.web.auth.application.AuthService;
import com.nachimban.web.auth.dto.request.AccessTokenRequest;
import com.nachimban.web.auth.dto.response.AccessTokenResponse;
import com.nachimban.web.auth.dto.response.LoginResponse;
import com.nachimban.web.auth.oauth.application.OauthService;
import com.nachimban.web.auth.oauth.domain.OauthServerType;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/api")
public class AuthController {
    public static final int A_WEEK = 7 * 24 * 60 * 60;

    private final OauthService oauthService;
    private final AuthService authService;

    public AuthController(OauthService oauthService, AuthService authService) {
        this.oauthService = oauthService;
        this.authService = authService;
    }

    @GetMapping("/oauth/login/{oauthServerType}")
    public ResponseEntity<AccessTokenResponse> login(
            @PathVariable OauthServerType oauthServerType,
            @RequestParam String authCode,
            HttpServletResponse response
    ) {
        Long memberId = oauthService.login(oauthServerType, authCode);
        LoginResponse loginResponse = authService.createTokens(memberId);

        addRefreshTokenInCookie(loginResponse.refreshToken(), response);

        return ResponseEntity.ok(new AccessTokenResponse(loginResponse.accessToken()));
    }

    private void addRefreshTokenInCookie(String refreshToken, HttpServletResponse response) {
        ResponseCookie cookie = createCookie(refreshToken);

        response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
    }

    private ResponseCookie createCookie(String refreshToken) {
        return ResponseCookie.from("refresh-token", refreshToken)
                .httpOnly(true)
                .maxAge(A_WEEK)
                .sameSite("None")
                .secure(true)
                .path("/")
                .build();
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<AccessTokenResponse> reissueTokens(
            @CookieValue("refresh-token") String refreshToken,
            @RequestBody AccessTokenRequest request,
            HttpServletResponse response
    ) {
        LoginResponse loginResponse = authService.recreateTokens(refreshToken, request.accessToken());

        addRefreshTokenInCookie(refreshToken, response);

        return ResponseEntity.ok(new AccessTokenResponse(loginResponse.accessToken()));
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@CookieValue("refresh-token") String refreshToken) {
        authService.removeRefreshToken(refreshToken);

        return ResponseEntity.noContent().build();
    }

}
