package blackjack.domain.gameplayer;

import blackjack.domain.card.Card;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Players implements Iterable<Player> {
    private final List<Player> players;

    public Players(List<Player> players) {
        validatePlayersCount(players);
        this.players = players;
    }

    private void validatePlayersCount(List<Player> players) {
        if (players.isEmpty() || players.size() > 6) {
            throw new IllegalArgumentException("게임을 진행하는 플레이어의 수는 1명에서 6명 사이여야 합니다.");
        }
    }

    public boolean getPlayerIsHit(int i) {
        return players.get(i).isHit();
    }

    public void addCardToPlayer(int i, Card card) {
        players.get(i).addCard(card);
    }

    public Player getPlayer(int i) {
        return players.get(i);
    }

    public int count() {
        return players.size();
    }

    public List<String> getPlayersName() {
        return players.stream()
                .map(Player::showName)
                .collect(Collectors.toList());
    }

    public int getPlayerScoreByIndex(int i) {
        return getPlayer(i).calculateScore();
    }

    public List<Card> showPlayerCardsByIndex(int i) {
        return getPlayer(i).showCards();
    }

    public String showPlayerNameByIndex(int i) {
        return getPlayer(i).showName();
    }

    @Override
    public Iterator<Player> iterator() {
        return players.iterator();
    }
}