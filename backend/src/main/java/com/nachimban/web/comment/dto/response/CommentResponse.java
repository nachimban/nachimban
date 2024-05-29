package com.nachimban.web.comment.dto.response;

import com.nachimban.web.comment.domain.Comment;

import java.time.LocalDateTime;

public record CommentResponse(
        Long id,
        String commenter,
        String content,
        LocalDateTime updatedAt
) {
    public static CommentResponse from(Comment comment) {
        return new CommentResponse(
                comment.getId(),
                comment.getCommenter().getNickname(),
                comment.getCommentContent(),
                comment.getUpdatedAt()
        );
    }
}
