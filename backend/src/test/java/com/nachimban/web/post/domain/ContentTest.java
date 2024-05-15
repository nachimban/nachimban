package com.nachimban.web.post.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ContentTest {

    @ParameterizedTest(name = "content의 길이는 1이상 1000이하여야 한다.")
    @ValueSource(strings = {"a", "aaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaa"})
    void whenContentIsValid_thenSuccess(String content) {
        assertDoesNotThrow(() -> Content.from(content));
    }

    @ParameterizedTest(name = "content는 null이거나 empty일 수 없다")
    @EmptySource
    @NullSource
    void whenContentIsEmptyOrNull_thenFail(String content) {
        assertThatThrownBy(() -> Content.from(content))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("content의 길이는 1000을 초과할 수 없다")
    void whenContentIsGraterThan1000_thenFail() {
        String content = "a".repeat(1001);

        assertThatThrownBy(() -> Content.from(content))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
