package com.nachimban.web.comment.application;

import com.nachimban.web.comment.domain.Comment;
import com.nachimban.web.comment.domain.CommentRepository;
import com.nachimban.web.comment.dto.request.CommentCreationRequest;
import com.nachimban.web.comment.dto.request.CommentUpdateRequest;
import com.nachimban.web.common.security.AuthorizedMember;
import com.nachimban.web.member.domain.Member;
import com.nachimban.web.member.domain.MemberRepository;
import com.nachimban.web.post.domain.Post;
import com.nachimban.web.post.domain.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    public CommentService(
            CommentRepository commentRepository,
            PostRepository postRepository,
            MemberRepository memberRepository
    ) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.memberRepository = memberRepository;
    }

    @Transactional
    public Long createComment(
            AuthorizedMember authorizedMember,
            CommentCreationRequest request,
            Long postId
    ) {
        Member commenter = findMemberById(authorizedMember.memberId());
        Post post = findPostById(postId);

        Comment comment = Comment.of(request.content(), commenter, post);
        commentRepository.save(comment);

        return comment.getId();
    }

    private Member findMemberById(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(IllegalArgumentException::new);
    }

    private Post findPostById(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Transactional
    public void updateComment(
            AuthorizedMember authorizedMember,
            CommentUpdateRequest request,
            Long commentId
    ) {
        Member member = findMemberById(authorizedMember.memberId());
        Comment comment = findCommentById(commentId);

        validateModifying(comment, member);

        comment.changeContent(request.content());

        commentRepository.save(comment);
    }

    private Comment findCommentById(Long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(IllegalArgumentException::new);
    }

    private void validateModifying(Comment comment, Member member) {
        if (comment.isCommenter(member)) {
            return;
        }

        throw new IllegalArgumentException();
    }

    @Transactional
    public void deleteComment(
            AuthorizedMember authorizedMember,
            Long commentId
    ) {
        Member member = findMemberById(authorizedMember.memberId());
        Comment comment = findCommentById(commentId);

        validateModifying(comment, member);

        commentRepository.deleteById(commentId);
    }

}
