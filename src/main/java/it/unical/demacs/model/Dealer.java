package it.unical.demacs.model;

public class Dealer {
    private Hand hand;

    public Dealer() {
        this.hand = new Hand(true);
    }

    public void takeCard(Card c) {
        this.hand.addCard(c);
    }

    public Hand getActiveHand() {
        return this.hand;
    }

    public void reset() {
        this.hand = new Hand(true);
    }
}
