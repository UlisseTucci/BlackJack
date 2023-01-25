package it.unical.demacs.model;

import it.unical.demacs.view.GameTableFrame;

public class Game {
    private static Game instance = null;
    private int dealerPoints;
    private int playerPoints;
    private int dealerPointsAlternativi;
    private int playerPointsAlternativi;
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
        int index = 0;
        this.dealerPoints = 0;
        this.playerPoints = 0;
        this.dealerPointsAlternativi = 0;
        this.playerPointsAlternativi = 0;
        //GameTableFrame.getInstance().setPoints(index, dealerPoints, playerPoints, dealerPointsAlternativi, playerPointsAlternativi);

        Card dealerCard = this.cardStack.drawCard();
        Card playerCard1 = this.cardStack.drawCard();
        Card playerCard2 = this.cardStack.drawCard();
        GameTableFrame.getInstance().dealCard(dealerCard, playerCard1, playerCard2);

        this.dealerPoints += valoreEstratto(dealerCard);
        if (valoreEstratto(dealerCard) == 1) {
            index = 1;
            dealerPointsAlternativi = 11;
        }

        if (valoreEstratto(playerCard1) == 1 || valoreEstratto(playerCard2) == 1) {
            index = 2;
            if (valoreEstratto(playerCard1) == 1) {
                this.playerPoints += 1;
                this.playerPoints += valoreEstratto(playerCard2);
                this.playerPointsAlternativi += 11;
                this.playerPointsAlternativi += valoreEstratto(playerCard2);
            }
            else {
                this.playerPoints += valoreEstratto(playerCard1);
                this.playerPoints += 1;
                this.playerPointsAlternativi += valoreEstratto(playerCard1);
                this.playerPointsAlternativi += 11;
            }
        }
        else {
            this.playerPoints += valoreEstratto(playerCard1);
            this.playerPoints += valoreEstratto(playerCard2);
        }

        GameTableFrame.getInstance().setPoints(index, dealerPoints, playerPoints, dealerPointsAlternativi, playerPointsAlternativi);

        if (dealerPoints == 21 || dealerPointsAlternativi == 21) {
            GameTableFrame.getInstance().dealerWin();
        }
        else if (playerPoints == 21 || playerPointsAlternativi == 21) {
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
        int index = 0;
        if (this.cardStack.getSize() <= 1) { // Controlliamo che il mazzo abbia abbastanza carte.
            this.cardStack = new CardStack();
            this.cardStack.shuffle();
        }

        Card playerCard = this.cardStack.drawCard();
        GameTableFrame.getInstance().askCard(playerCard);
        if (valoreEstratto(playerCard) == 1) {
            playerPointsAlternativi = 11;
        }
        else
            this.playerPoints += valoreEstratto(playerCard);
        GameTableFrame.getInstance().setPoints(index, dealerPoints, playerPoints, dealerPointsAlternativi, playerPointsAlternativi);

        if (playerPoints == 21 || playerPointsAlternativi == 21) {
            GameTableFrame.getInstance().playerWin();
        } else if (playerPoints > 21) {
            GameTableFrame.getInstance().playerBusted(playerPoints);
        }
    }

    public void dealerPlaying() {
        int index = 0;
        if (this.cardStack.getSize() <= 1) { // Controlliamo che il mazzo abbia abbastanza carte.
            this.cardStack = new CardStack();
            this.cardStack.shuffle();
        }

        while (dealerPoints <= 10) {
            Card dealerCard = this.cardStack.drawCard();
            GameTableFrame.getInstance().askDealerCard(dealerCard);
            if (valoreEstratto(dealerCard) == 1) {
                index = 1;
                this.dealerPointsAlternativi = dealerPoints + 11;
                this.dealerPoints += 1;
            }
            else {
                this.dealerPoints += valoreEstratto(dealerCard);
                this.dealerPointsAlternativi += valoreEstratto(dealerCard);
            }
            GameTableFrame.getInstance().setPoints(index, dealerPoints, playerPoints, dealerPointsAlternativi, playerPointsAlternativi);

            if (dealerPoints == 21 || dealerPointsAlternativi == 21) {
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