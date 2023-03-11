package blackjack.domain;

import blackjack.domain.gameplayer.Dealer;
import blackjack.domain.gameplayer.Player;

public class ResultReferee {

    public static Result getPlayerResult(Player player, Dealer dealer) {
        if (player.isBust()) {
            return Result.LOSE;
        }
        if (player.isBlackJack()) {
            return getPlayerResultWhenPlayerBlackJack(dealer);
        }
        if (dealer.isBust()) {
            return Result.WIN;
        }
        return getPlayerResultWhenParticipantsIsNotBust(player, dealer);
    }

    private static Result getPlayerResultWhenParticipantsIsNotBust(Player player, Dealer dealer) {
        Score playerScore = player.calculateScore();
        Score dealerScore = dealer.calculateScore();
        if (playerScore.isGreaterThan(dealerScore)) {
            return Result.WIN;
        }
        if (playerScore.isEqualTo(dealerScore)) {
            return Result.DRAW;
        }
        return Result.LOSE;
    }

    private static Result getPlayerResultWhenPlayerBlackJack(Dealer dealer) {
        if (dealer.isBlackJack()) {
            return Result.DRAW;
        }
        return Result.BLACKJACK;
    }

    public static Result getOpponentResult(Result result) {
        if (result == Result.WIN || result == Result.BLACKJACK) {
            return Result.LOSE;
        }
        if (result == Result.DRAW) {
            return Result.DRAW;
        }
        return Result.WIN;
    }
}