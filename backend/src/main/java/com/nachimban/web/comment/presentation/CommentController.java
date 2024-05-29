package com.nachimban.web.comment.presentation;

import com.nachimban.web.comment.application.CommentService;
import com.nachimban.web.comment.dto.request.CommentCreationRequest;
import com.nachimban.web.comment.dto.request.CommentUpdateRequest;
import com.nachimban.web.common.security.AuthorizedMember;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<Void> createComment(
            AuthorizedMember authorizedMember,
            @RequestBody CommentCreationRequest request,
            @PathVariable Long postId
    ) {
        Long savedId = commentService.createComment(authorizedMember, request, postId);

        return ResponseEntity.created(URI.create("/comments/" + savedId)).build();
    }

    @PutMapping("/comments/{id}")
    public ResponseEntity<Void> updateComment(
            AuthorizedMember authorizedMember,
            @RequestBody CommentUpdateRequest request,
            @PathVariable Long id
    ) {
        commentService.updateComment(authorizedMember, request, id);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<Void> deleteComment(
            AuthorizedMember authorizedMember,
            @PathVariable Long id
    ) {
        commentService.deleteComment(authorizedMember, id);

        return ResponseEntity.noContent().build();
    }

}
