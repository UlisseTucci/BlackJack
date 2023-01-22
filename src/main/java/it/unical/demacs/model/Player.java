package it.unical.demacs.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Hand> hands;
    private int bet;
    private int money = 500;


    public Player() {
        this.hands = new ArrayList<Hand>();
        this.hands.add(new Hand(true));
    }

    public Hand getActiveHand() { // Ritorna la Hand attiva del Player.
        for (Hand hand : hands) {
            if (hand.isActive())
                return hand;
        }
        return null;
    }

    public void takeCard(Card card) { // Aggiuge una carta alla Hand attiva.
        getActiveHand().addCard(card);
    }

    public int getNumberOfHands() { // Ritorna il numero di Hand che un Player ha.
        return hands.size();
    }

    public boolean isActiveLast() { // Ritorna se la Hand attiva è l'ultima dell'elenco.
        return (hands.indexOf(getActiveHand()) == hands.size()-1);
    }

    public void switchHand() { // Imposta la Hand corrente (che è attiva) in inattiva.
                               // Imposta la successiva Hand della lista come attiva (se non è l'ultima della lista).
        int index;
        for (Hand hand : hands) {
            if (hand.isActive()) {
                hand.setActive(false);
                index = hands.indexOf(hand);

                if (index == getNumberOfHands() - 1) {
                    Hand next = hands.get(0);
                    next.setActive(true);
                    break;
                }
                else {
                    Hand next = hands.get(index + 1);
                    next.setActive(true);
                    break;
                }
            }

        }
    }

    public void reset() { // Resetta il Player.
        hands.clear();
        hands.add(new Hand(true));
        bet = 0;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        if (bet >= 0) {
            this.bet = bet;
        }
        else
            this.bet = 0;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void split() { // Divide la Hand attiva del Player.
        Hand activeHand = getActiveHand();
        Card card = activeHand.drawCard();
        Hand splitHand = new Hand(false);
        splitHand.addCard(card);
        hands.add(splitHand);
    }

    public List<Hand> getHands() {
        return hands;
    }
}
