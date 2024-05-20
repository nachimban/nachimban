package com.nachimban.web.post.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Title {
    private static int MAX_TITLE_LENGTH = 20;

    @Column(nullable = false, length = 20)
    private String title;

    private Title(String title) {
        this.title = title;
    }

    public static Title from(String title) {
        validate(title);

        return new Title(title);
    }

    private static void validate(String title) {
        if (title == null) {
            throw new IllegalArgumentException("title null일 수 없습니다.");
        }
        if (title.isBlank() || title.length() > MAX_TITLE_LENGTH) {
            throw new IllegalArgumentException("title의 길이가 올바르지 않습니다.");
        }
    }

}
