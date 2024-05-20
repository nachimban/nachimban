package com.nachimban.web.comment.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Lob;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CommentContent {

    private static final int MAX_DESCRIPTION_LENGTH = 200;

    @Lob
    @Column(nullable = false, length = MAX_DESCRIPTION_LENGTH)
    private String content;

    private CommentContent(String content) {
        this.content = content;
    }

    public static CommentContent from(String content) {
        validate(content);

        return new CommentContent(content);
    }

    private static void validate(String content) {
        if (content == null) {
            throw new IllegalArgumentException("content null일 수 없습니다.");
        }
        if (content.isBlank() || content.length() > MAX_DESCRIPTION_LENGTH) {
            throw new IllegalArgumentException("content의 길이가 올바르지 않습니다.");
        }
    }

}
