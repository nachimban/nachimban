package com.nachimban.web.auth.application;

import com.nachimban.web.auth.domain.RefreshToken;
import com.nachimban.web.auth.domain.RefreshTokenRepository;
import com.nachimban.web.auth.dto.response.LoginResponse;
import com.nachimban.web.auth.support.JwtTokenProvider;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthService {
    private final JwtTokenProvider jwtTokenProvider;

    private final RefreshTokenRepository refreshTokenRepository;

    public AuthService(
            JwtTokenProvider jwtTokenProvider,
            RefreshTokenRepository refreshTokenRepository
    ) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.refreshTokenRepository = refreshTokenRepository;
    }

    public LoginResponse createTokens(Long memberId) {
        String refreshToken = jwtTokenProvider.createRefreshToken();
        String accessToken = jwtTokenProvider.createAccessToken(String.valueOf(memberId));

        RefreshToken token = refreshTokenRepository.findByMemberId(memberId)
                .orElseGet(() -> RefreshToken.of(refreshToken, memberId));
        token.changeToken(refreshToken);

        refreshTokenRepository.save(token);

        return new LoginResponse(refreshToken, accessToken);
    }

    public LoginResponse recreateTokens(String refreshToken, String accessToken) {
        jwtTokenProvider.validateTokensForRecreation(refreshToken, accessToken);

        RefreshToken token = refreshTokenRepository.findById(refreshToken)
                .orElseThrow(IllegalArgumentException::new);

        return createTokens(token.getMemberId());
    }

    public void removeRefreshToken(String refreshToken) {
        refreshTokenRepository.deleteById(refreshToken);
    }

}
