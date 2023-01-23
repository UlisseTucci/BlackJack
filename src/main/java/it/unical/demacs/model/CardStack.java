package it.unical.demacs.model;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class CardStack {
    private Stack<Card> cards;
    private String[] value = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace" };
    private String[] type = { "clubs", "spades", "hearts", "diamonds" };

    public CardStack() {
        this.cards = new Stack<Card>();
        for (int i=0; i<4; i++) {
            for (int j=0; j<13; j++) {
                this.cards.add(new Card(value[j], type[i]));
            }
        }
    }

    public void addCard(Card c) { cards.push(c); }
    public Card drawCard() { return cards.pop(); }
    public int getSize() { return cards.size(); }
    public void shuffle() { Collections.shuffle(cards); }

}
