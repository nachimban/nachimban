package com.nachimban.web.post.dto.response;

import com.nachimban.web.post.domain.Post;

import java.time.LocalDateTime;

public record PostResponse(
        Long id,
        String title,
        String writer,
        LocalDateTime updatedAt
) {
    public static PostResponse from(Post post) {
        return new PostResponse(
                post.getId(),
                post.getTitle(),
                post.getWriter().getNickname(),
                post.getUpdatedAt()
        );
    }

}
