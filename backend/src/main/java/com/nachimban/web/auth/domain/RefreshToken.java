package com.nachimban.web.auth.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class RefreshToken {
    @Id
    private String token;

    @Column(nullable = false, unique = true)
    private Long memberId;

    private RefreshToken(String token, Long memberId) {
        this.token = token;
        this.memberId = memberId;
    }

    public static RefreshToken of(String token, Long memberId) {
        return new RefreshToken(token, memberId);
    }

    public void changeToken(String token) {
        this.token = token;
    }

}
