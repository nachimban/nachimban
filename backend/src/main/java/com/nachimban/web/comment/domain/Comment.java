package com.nachimban.web.comment.domain;

import com.nachimban.web.common.BaseTimeEntity;
import com.nachimban.web.member.domain.Member;
import com.nachimban.web.post.domain.Post;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private CommentContent commentContent;

    @ManyToOne
    @JoinColumn(name = "commenter_id")
    private Member commenter;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    private Comment(CommentContent commentContent, Member commenter, Post post) {
        this.commentContent = commentContent;
        this.commenter = commenter;
        this.post = post;
    }

    public static Comment of(String content, Member commenter, Post post) {
        return new Comment(
                CommentContent.from(content),
                commenter,
                post
        );
    }

}
