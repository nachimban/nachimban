package com.nachimban.web.member.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Nickname {
    private static final int NICKNAME_LEGTH = 20;

    @Column(nullable = false, length = 20, unique = true)
    private String nickName;

    private Nickname(String nickName) {
        this.nickName = nickName;
    }

    public static Nickname from(String nickName) {
        validateNickName(nickName);

        return new Nickname(nickName);
    }

    private static void validateNickName(String nickName) {
        if (nickName == null) {
            throw new IllegalArgumentException();
        }
        if (nickName.isBlank() || nickName.length() > NICKNAME_LEGTH) {
            throw new IllegalArgumentException();
        }
    }

}
