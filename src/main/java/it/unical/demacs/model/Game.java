package it.unical.demacs.model;

import it.unical.demacs.view.GameButton;
import it.unical.demacs.view.GameTableFrame;

import javax.swing.*;

public class Game {
    private static Game instance = null;
    private int dealerPoints;
    private int playerPoints;
    private CardStack cardStack;
    private boolean gameInProgress = false;

    private Game() {
        this.cardStack = new CardStack();
        this.cardStack.shuffle();
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public void start() {
        this.gameInProgress = true;
    }

    public void dealCard() {
        if (this.cardStack.getSize() <= 4) { // Controlliamo che il mazzo abbia abbastanza carte.
            this.cardStack = new CardStack();
            this.cardStack.shuffle();
        }
        this.dealerPoints = 0;
        this.playerPoints = 0;
        GameTableFrame.getInstance().setPoints(dealerPoints, playerPoints);

        Card dealerCard = this.cardStack.drawCard();
        Card playerCard1 = this.cardStack.drawCard();
        Card playerCard2 = this.cardStack.drawCard();
        GameTableFrame.getInstance().dealCard(dealerCard, playerCard1, playerCard2);

        this.dealerPoints += valoreEstratto(dealerCard);
        this.playerPoints += valoreEstratto(playerCard1);
        this.playerPoints += valoreEstratto(playerCard2);
        GameTableFrame.getInstance().setPoints(dealerPoints, playerPoints);

        if (dealerPoints == 21) {
            GameTableFrame.getInstance().dealerWin();
        }
        else if (playerPoints == 21) {
            GameTableFrame.getInstance().playerWin();
        }
    }

    private int valoreEstratto(Card card) {
        switch (card.getType()) {
            case "2" -> { return 2; }
            case "3" -> { return 3; }
            case "4" -> { return 4; }
            case "5" -> { return 5; }
            case "6" -> { return 6; }
            case "7" -> { return 7; }
            case "8" -> { return 8; }
            case "9" -> { return 9; }
            case "10" -> { return 10; }
            case "jack" -> { return 10; }
            case "queen" -> { return 10; }
            case "king" -> { return 10; }
            case "ace" -> { return 1; }
        }
        return 0;
    }

    public void askCard() {
        if (this.cardStack.getSize() <= 1) { // Controlliamo che il mazzo abbia abbastanza carte.
            this.cardStack = new CardStack();
            this.cardStack.shuffle();
        }

        Card playerCard = this.cardStack.drawCard();
        GameTableFrame.getInstance().askCard(playerCard);
        this.playerPoints += valoreEstratto(playerCard);
        GameTableFrame.getInstance().setPoints(dealerPoints, playerPoints);

        if (playerPoints == 21) {
            GameTableFrame.getInstance().playerWin();
        } else if (playerPoints > 21) {
            GameTableFrame.getInstance().playerBusted(playerPoints);
        }
    }

    public void dealerPlaying() {
        if (this.cardStack.getSize() <= 1) { // Controlliamo che il mazzo abbia abbastanza carte.
            this.cardStack = new CardStack();
            this.cardStack.shuffle();
        }

        while (dealerPoints <= 10) {
            Card dealerCard = this.cardStack.drawCard();
            GameTableFrame.getInstance().askDealerCard(dealerCard);
            this.dealerPoints += valoreEstratto(dealerCard);
            GameTableFrame.getInstance().setPoints(dealerPoints, playerPoints);

            if (dealerPoints == 21) {
                GameTableFrame.getInstance().dealerWin();
            } else if (dealerPoints > 21) {
                GameTableFrame.getInstance().dealerBusted(dealerPoints);
            }
        }
    }

    public void decideWinners() {
        if (dealerPoints == playerPoints) {
            GameTableFrame.getInstance().pareggio();
        }
        else if (dealerPoints > playerPoints) {
            GameTableFrame.getInstance().dealerWin();
        }
        else {
            GameTableFrame.getInstance().playerWin();
        }
    }

    public void surrenderedPlayer() {
        GameTableFrame.getInstance().dealerWin();
    }
}