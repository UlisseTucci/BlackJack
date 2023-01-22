package it.unical.demacs.view;

public class BlackJackUI {
    private static BlackJackUI instance = null;
    private MenuFrame menuFrame;
    private BlackJackUI() {
        menuFrame = MenuFrame.getInstance();
        menuFrame.setVisibile();
    }
    public static BlackJackUI getInstance() {
        if (instance == null) {
            instance = new BlackJackUI();
        }
        return instance;
    }

}
