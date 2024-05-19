package com.nachimban.web.post.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class TitleTest {

    @ParameterizedTest(name = "title의 길이는 1이상 20이하여야 한다.")
    @ValueSource(strings = {"a", "aaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaa"})
    void whenTitleIsValid_thenSuccess(String title) {
        assertDoesNotThrow(() -> Title.from(title));
    }

    @ParameterizedTest(name = "title은 null이거나 empty일 수 없다")
    @EmptySource
    @NullSource
    void whenTitleIsEmptyOrNull_thenFail(String title) {
        assertThatThrownBy(() -> Title.from(title))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("title의 길이는 20을 초과할 수 없다")
    void whenTitleIsGraterThan20_thenFail() {
        String title = "a".repeat(21);

        assertThatThrownBy(() -> Title.from(title))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
