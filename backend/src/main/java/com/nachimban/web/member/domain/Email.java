package com.nachimban.web.member.domain;

import com.nachimban.web.common.util.RegexUtil;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Email {
    private static final String VALID_EMAIL_URL_REGEX = "^[a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-Z]{2,}$";

    @Column(nullable = false)
    private String email;

    private Email(String email) {
        this.email = email;
    }

    public static Email from(String email) {
        validateEmail(email);

        return new Email(email);
    }

    private static void validateEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException();
        }

        if (!RegexUtil.matches(VALID_EMAIL_URL_REGEX, email)) {
            throw new IllegalArgumentException();
        }
    }

}
