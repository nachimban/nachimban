package com.nachimban.web.post.presentation;

import com.nachimban.web.common.security.AuthorizedMember;
import com.nachimban.web.post.application.PostService;
import com.nachimban.web.post.dto.request.PostCreationRequest;
import com.nachimban.web.post.dto.request.PostUpdateRequest;
import com.nachimban.web.post.dto.response.PostDetailResponse;
import com.nachimban.web.post.dto.response.PostResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/new")
    public ResponseEntity<Void> createPost(
            AuthorizedMember authorizedMember,
            @RequestBody PostCreationRequest request
    ) {
        Long savedId = postService.createPost(authorizedMember, request);

        return ResponseEntity.created(URI.create("/posts/" + savedId)).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(
            AuthorizedMember authorizedMember,
            @PathVariable Long id
    ) {
        postService.deletePost(authorizedMember, id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePost(
            AuthorizedMember authorizedMember,
            @RequestBody PostUpdateRequest request,
            @PathVariable Long id
    ) {
        postService.updatePost(authorizedMember, request, id);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id})")
    public ResponseEntity<PostDetailResponse> getPost(@PathVariable Long id) {
        PostDetailResponse response = postService.getPostDetail(id);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<PostResponse>> getAllPosts() {
        List<PostResponse> responses = postService.getAllPosts();

        return ResponseEntity.ok(responses);
    }

}
