package it.unical.demacs.view;

public class MenuButton extends MyButton {
    public static final int PLAY = 0;
    public static final int STATISTIC = 1;
    public static final int SETTINGS = 2;
    public static final int EXIT = 3;
    private int type;

    public MenuButton(String str, int type) {
        super(str);
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
