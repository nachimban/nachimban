package com.nachimban.web.post.domain;

import com.nachimban.web.common.image.ImageUrl;
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
public class PostImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private ImageUrl imageUrl;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    private PostImage(ImageUrl imageUrl, Post post) {
        this.imageUrl = imageUrl;
        this.post = post;
    }

    public static PostImage of(String imageUrl, Post post) {
        return new PostImage(ImageUrl.from(imageUrl), post);
    }

}
