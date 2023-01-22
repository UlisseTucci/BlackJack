package it.unical.demacs.view;

public class GameButton extends MyButton {
    public static final int BET_1 = 1;
    public static final int BET_5 = 2;
    public static final int BET_25 = 3;
    public static final int BET_100 = 4;
    public static final int CLEAR_BET = 5;
    public static final int BET = 6;
    public static final int HIT = 7;
    public static final int STAND = 8;
    public static final int SURREND = 9;
    private int type;

    public GameButton(String str, int type) {
        super(str);
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
