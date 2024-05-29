package com.nachimban.web.post.application;

import com.nachimban.web.common.security.AuthorizedMember;
import com.nachimban.web.member.domain.Member;
import com.nachimban.web.member.domain.MemberRepository;
import com.nachimban.web.post.domain.Post;
import com.nachimban.web.post.domain.PostRepository;
import com.nachimban.web.post.dto.request.PostCreationRequest;
import com.nachimban.web.post.dto.request.PostUpdateRequest;
import com.nachimban.web.post.dto.response.PostDetailResponse;
import com.nachimban.web.post.dto.response.PostResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PostService {
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    public PostService(MemberRepository memberRepository, PostRepository postRepository) {
        this.memberRepository = memberRepository;
        this.postRepository = postRepository;
    }

    @Transactional
    public Long createPost(AuthorizedMember authorizedMember, PostCreationRequest request) {
        Member creator = findMemberById(authorizedMember.memberId());
        Post post = Post.of(
                request.title(),
                request.content(),
                creator
        );

        postRepository.save(post);

        return post.getId();
    }

    private Member findMemberById(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Transactional
    public void deletePost(AuthorizedMember authorizedMember, Long postId) {
        Member member = findMemberById(authorizedMember.memberId());
        Post post = findPostById(postId);

        validateModifying(member, post);

        postRepository.deleteById(postId);
    }

    private Post findPostById(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(IllegalArgumentException::new);
    }

    private void validateModifying(Member member, Post post) {
        if (post.isWriter(member)) {
            return;
        }
        throw new IllegalArgumentException();
    }

    @Transactional
    public void updatePost(
            AuthorizedMember authorizedMember,
            PostUpdateRequest request,
            Long postId
    ) {
        Member member = findMemberById(authorizedMember.memberId());
        Post post = findPostById(postId);

        validateModifying(member, post);

        post.changeTitle(request.title());
        post.changeContent(request.content());

        postRepository.save(post);
    }

    public PostDetailResponse getPostDetail(Long id) {
        Post post = findPostById(id);

        return PostDetailResponse.from(post);
    }

    public List<PostResponse> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(PostResponse::from)
                .toList();
    }

}
