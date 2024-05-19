package com.nachimban.web.common.image;

import com.nachimban.web.common.util.RegexUtil;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ImageUrl {
    private static final String VALID_IMAGE_URL_REGEX = "https?://.+";

    @Pattern(regexp = VALID_IMAGE_URL_REGEX)
    @Column(nullable = false, length = 2048)
    private String imageUrl;

    private ImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public static ImageUrl from(String imageUrl) {
        validateUrl(imageUrl);

        return new ImageUrl(imageUrl);
    }

    private static void validateUrl(String imageUrl) {
        if (imageUrl == null) {
            throw new IllegalArgumentException();
        }
        if (!RegexUtil.matches(VALID_IMAGE_URL_REGEX, imageUrl)) {
            throw new IllegalArgumentException();
        }
    }

}
