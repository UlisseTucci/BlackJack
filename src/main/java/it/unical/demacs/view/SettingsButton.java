package it.unical.demacs.view;

import javax.swing.*;

public class SettingsButton extends JButton {
    public static final int MAIN = 0;
    public static final int RED = 1;
    public static final int BLUE = 2;
    public static final int YELLOW = 3;
    public static final int PURPLE = 4;
    public static final int RED1 = 5;
    private int type;

    public SettingsButton(ImageIcon icon, int type) {
        super(icon);
        this.type = type;
    }

    public int getType() { return type; }
}
