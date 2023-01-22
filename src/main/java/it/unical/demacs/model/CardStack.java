package it.unical.demacs.model;

import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;

public class CardStack implements Iterable<Card> {
    private Stack<Card> cards;

    public CardStack() {
        this.cards = new Stack<Card>();
    }

    public void addCard(Card c) { cards.push(c); }
    public Card drawCard() { return cards.pop(); }
    public int getSize() { return cards.size(); }
    public void shuffle() { Collections.shuffle(cards); }

    @Override
    public Iterator<Card> iterator() {
        return cards.iterator();
    }
}
