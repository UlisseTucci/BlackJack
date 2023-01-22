package it.unical.demacs.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Hand implements Iterable<Card> {

    private static final int ZERO = 0;
    private List<Card> cards;
    private boolean active = false;

    public Hand() { // Costruttore senza paramentri.
        this.cards = new ArrayList<Card>();
    }

    public Hand(boolean active) { // Costruttore che imposta lo status della Hand.
        this.cards = new ArrayList<Card>();
        this.active = active;
    }

    public void addCard(Card card) { cards.add(card); } // Aggiungere una Card alla Hand.
    public void clearHand() { cards.clear(); } // Pulire la Hand.
    public Card drawCard() { return cards.remove(ZERO); } // Ritorna la carta e la rimuove dalla Hand.
    public int getSize() { return cards.size(); } // Ritorna quante carte rimangono nella Hand.
    public boolean isActive() { return active; } // Ritorna True se la Hand è attiva.
    public void setActive(boolean active) { this.active = active; } // Imposta lo status della Hand.
    public List<Card> getCards() { return cards; } // Ritorna la lista di Card della Hand.
    public String toString() { return cards.toString(); }

    @Override
    public Iterator<Card> iterator() {
        return cards.iterator();
    }
}
