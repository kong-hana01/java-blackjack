package blackjack.domain.card;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class DeckTest {
    @DisplayName("생성 테스트")
    @Test
    void Should_Create_When_NewDeck() {
        Stack<Card> cards = new Stack<>();
        cards.add(new Card(CardNumber.ACE, CardSymbol.CLUBS));
        assertDoesNotThrow(() -> new Deck(cards));
    }

    @DisplayName("덱의 가장 위쪽에 위치하는 카드를 뽑을 수 있다.")
    @Test
    void Should_Draw_When_HIT() {
        Stack<Card> cards = new Stack<>();

        Card card1 = new Card(CardNumber.ACE, CardSymbol.CLUBS);
        Card card2 = new Card(CardNumber.ACE, CardSymbol.DIAMONDS);

        cards.add(card1);
        cards.add(card2);

        Deck deck = new Deck(cards);

        assertThat(cards).contains(deck.draw());
    }

    @DisplayName("덱이 비어있다면 true를 반환할 수 있다.")
    @Test
    void Should_ReturnTrue_When_Empty() {
        Deck deck = new Deck(new Stack<>());

        assertThat(deck.isEmpty()).isTrue();
    }

    @DisplayName("덱이 비어있지 않다면 false를 반환할 수 있다.")
    @Test
    void Should_ReturnFalse_When_NotEmpty() {
        Stack<Card> cards = new Stack<>();

        Card card1 = new Card(CardNumber.ACE, CardSymbol.CLUBS);
        Card card2 = new Card(CardNumber.ACE, CardSymbol.DIAMONDS);

        cards.add(card1);
        cards.add(card2);

        Deck deck = new Deck(cards);

        assertThat(deck.isEmpty()).isFalse();
    }

    @DisplayName("덱이 비어있을 때 draw를 요청하면 예외를 발생시킨다.")
    @Test
    void Should_ThrowException_When_EmptyDraw() {
        Stack<Card> cards = new Stack<>();
        Deck deck = new Deck(cards);

        assertThatThrownBy(() -> deck.draw())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("덱이 비어있습니다.");
    }
}
