package it.unical.demacs.model;

public class Card {
    private final String type;
    private final String picture;

    public Card(String type, String picture) {
        this.type = type;
        this.picture = picture;
    }

    public String getType() { return type; }

    public String getPicture() { return picture; }

    public String toString() { return picture + "-" + type; }
}
