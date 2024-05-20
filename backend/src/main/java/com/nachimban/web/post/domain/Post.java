package com.nachimban.web.post.domain;

import com.nachimban.web.comment.domain.Comment;
import com.nachimban.web.common.BaseTimeEntity;
import com.nachimban.web.member.domain.Member;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Title title;

    @Embedded
    private PostContent postContent;

    @ManyToOne
    @JoinColumn(name = "writer_id", nullable = false)
    private Member writer;

    @OneToMany(mappedBy = "post", cascade = CascadeType.PERSIST)
    private List<PostImage> postImages = new ArrayList<>();

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

    private Post(Title title, PostContent postContent, Member writer) {
        this.title = title;
        this.postContent = postContent;
        this.writer = writer;
    }

    public static Post of(String title, String content, Member writer) {
        return new Post(
                Title.from(title),
                PostContent.from(content),
                writer
        );
    }

}
