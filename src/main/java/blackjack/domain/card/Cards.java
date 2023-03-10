package blackjack.domain.card;

import blackjack.domain.Score;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cards {

    private final List<Card> cards;

    public Cards() {
        this.cards = new ArrayList<>();
    }

    public void add(final Card card) {
        cards.add(card);
    }

    public boolean hasAce() {
        return cards.stream()
                .anyMatch(card -> card.isAce());
    }

    public int calculateScore() {
        return cards.stream()
                .mapToInt(card -> card.getScore())
                .sum();
    }

    public Card getOneCard() {
        return cards.get(0);
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }
}
