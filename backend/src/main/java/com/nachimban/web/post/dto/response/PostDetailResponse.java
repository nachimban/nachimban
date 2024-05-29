package com.nachimban.web.post.dto.response;

import com.nachimban.web.comment.dto.response.CommentResponse;
import com.nachimban.web.post.domain.Post;

import java.time.LocalDateTime;
import java.util.List;

public record PostDetailResponse(
        Long id,
        String title,
        String writer,
        String content,
        LocalDateTime updatedAt,
        List<CommentResponse> comments
) {

    public static PostDetailResponse from(Post post) {
        List<CommentResponse> comments = post.getComments()
                .stream()
                .map(CommentResponse::from)
                .toList();

        return new PostDetailResponse(
                post.getId(),
                post.getTitle(),
                post.getWriter().getNickname(),
                post.getPostContent(),
                post.getUpdatedAt(),
                comments
        );
    }

}
