package com.nachimban.web.member.domain;

import com.nachimban.web.comment.domain.Comment;
import com.nachimban.web.common.BaseTimeEntity;
import com.nachimban.web.common.image.ImageUrl;
import com.nachimban.web.post.domain.Post;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private OauthId oauthId;

    @Embedded
    private Nickname nickname;

    @Embedded
    private Email email;

    @Embedded
    private ImageUrl imageUrl;

    @OneToMany(mappedBy = "writer")
    private List<Post> writtenPosts = new ArrayList<>();

    @OneToMany(mappedBy = "commenter")
    private List<Comment> writtenComments = new ArrayList<>();

    private Member(
            OauthId oauthId,
            Nickname nickname,
            Email email,
            ImageUrl imageUrl
    ) {
        this.oauthId = oauthId;
        this.nickname = nickname;
        this.email = email;
        this.imageUrl = imageUrl;
    }

    public static Member of(
            OauthId oauthId,
            String nickname,
            String email,
            String imageUrl
    ) {
        return new Member(
                oauthId,
                Nickname.from(nickname),
                Email.from(email),
                ImageUrl.from(imageUrl)
        );
    }

    public String getNickname() {
        return nickname.getNickName();
    }

    public String getEmail() {
        return email.getEmail();
    }

    public String getImageUrl() {
        return imageUrl.getImageUrl();
    }

}
