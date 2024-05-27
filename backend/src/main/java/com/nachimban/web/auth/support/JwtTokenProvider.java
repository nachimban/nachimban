package com.nachimban.web.auth.support;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class JwtTokenProvider {
    private final String secretKey;
    private final long accessExpirationTime;
    private final long refreshExpirationTime;

    public JwtTokenProvider(
            @Value("${security.jwt.token.secret-key}")
            String secretKey,
            @Value("${security.jwt.token.access-expire-length}")
            long accessExpirationTime,
            @Value("${security.jwt.token.refresh-expire-length}")
            long refreshExpirationTime
    ) {
        this.secretKey = secretKey;
        this.accessExpirationTime = accessExpirationTime;
        this.refreshExpirationTime = refreshExpirationTime;
    }

    public String createAccessToken(String payload) {
        return createToken(payload, accessExpirationTime);
    }

    public String createRefreshToken() {
        UUID payload = UUID.randomUUID();

        return createToken(payload.toString(), refreshExpirationTime);
    }

    private String createToken(String payload, Long validityInMilliseconds) {
        Claims claims = Jwts.claims().setSubject(payload);
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public void validateTokensForRecreation(String refreshToken, String accessToken) {
        boolean canReissueAccessToken = !isExpired(refreshToken) && isExpired(accessToken);
        if (canReissueAccessToken) {
            return;
        }
        throw new IllegalStateException();
    }

    public void validateToken(String token) {
        if (isExpired(token)) {
            throw new IllegalStateException();
        }
    }

    private boolean isExpired(String token) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            Date expiration = claims.getBody().getExpiration();

            return expiration.before(new Date());
        } catch (ExpiredJwtException e) {
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

}
