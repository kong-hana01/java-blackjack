package blackjack.domain.gameplayer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {
    @DisplayName("생성 테스트")
    @Test
    void Should_Create_When_NewName() {
        assertDoesNotThrow(() -> new Name("name"));
    }

    @DisplayName("양 끝 공백을 가진 이름이 들어오면, 공백을 제거한다.")
    @ParameterizedTest
    @ValueSource(strings = {" name", " name ", "name "})
    void Should_Trim_When_HaveBlankEnd(String input) {
        assertThat(new Name(input).getName()).isEqualTo("name");
    }

    @DisplayName("가운데 공백을 가진 이름이 들어오면, 그대로 저장된다.")
    @Test
    void Should_Success_When_HaveBlankCenter() {
        assertThat(new Name("na me").getName()).isEqualTo("na me");
    }
}
