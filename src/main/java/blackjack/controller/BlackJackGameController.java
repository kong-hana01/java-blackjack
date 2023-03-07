package blackjack.controller;

import blackjack.domain.Game;
import blackjack.domain.GameResult;
import blackjack.domain.card.Card;
import blackjack.domain.card.Deck;
import blackjack.domain.card.DeckFactory;
import blackjack.domain.gameplayer.*;
import blackjack.view.InputView;
import blackjack.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class BlackJackGameController {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    private final InputView inputView;
    private final OutputView outputView;

    public BlackJackGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    private static Deck generateDeck() {
        return DeckFactory.createBlackJackDeck();
    }

    private static List<String> getCardNames(List<Card> cards) {
        return cards.stream()
                .map(card -> card.getCardNumberToString() + card.getCardSymbolToString())
                .collect(Collectors.toList());
    }

    public void run() {
        Game game = start();
        play(game);
        finish(game);
    }

    private void finish(Game game) {
        outputView.printDealerResult(getCardNames(game.showDealerAllCards()), game.getDealerScore());

        for (Player player : game.getPlayers()) {
            printOnePlayerResult(player);
        }

        GameResult gameResult = new GameResult(game);
        outputView.printEndMsg();
        outputView.printDealerWinningResult(gameResult.getDealerResult());
        outputView.printPlayerWinningResult(gameResult.getPlayerResult());
    }

    private void printOnePlayerResult(Player player) {
        String playerName = player.showName();
        List<String> playerCards = getCardNames(player.showCards());
        int score = player.calculateScore();
        outputView.printPlayerResult(playerName, playerCards, score);
    }

    private void play(Game game) {
        for (Player player : game.getPlayers()) {
            playersPlay(game, player);
        }
        dealerPlay(game);
    }

    private Game start() {
        Game game = generateGame();
        printStartCards(game);
        return game;
    }

    private void dealerPlay(Game game) {
        while (game.isHitDealer()) {
            outputView.printDealerHit();
            game.giveCardToDealer();
        }
    }

    private void printStartCards(Game game) {
        outputView.printStartMsg(game.showPlayersName());
        outputView.printDealerCards(getCardNames(game.showDealerCards()), System.lineSeparator());
        for (Player player : game.getPlayers()) {
            String playerName = player.showName();
            List<String> cards = getCardNames(player.showCards());
            outputView.printPlayerCards(playerName, cards, LINE_SEPARATOR);
        }
    }

    private Game generateGame() {
        List<Player> players = generatePlayers();
        Deck deck = generateDeck();
        GamePlayer gamePlayer = new GamePlayer(new Players(players), new Dealer());
        return new Game(deck, gamePlayer);
    }

    private List<Player> generatePlayers() {
        try {
            List<String> playersName = inputView.readPlayersName();
            return playersName.stream()
                    .map(name -> new Player(new Name(name)))
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]" + e.getMessage());
            return generatePlayers();
        }
    }

    private void playersPlay(Game game, Player player) {
        String playerName = player.showName();

        while (isCheckPlayerCommand(player)) {
            game.giveCardTo(player);
            List<String> playerCards = getCardNames(player.showCards());
            outputView.printPlayerCards(playerName, playerCards, System.lineSeparator());
        }
    }

    private boolean isCheckPlayerCommand(Player player) {
        if (player.isHit()) {
            return inputView.readTryCommand(player.showName()).equals("y");
        }
        return false;
    }
}
