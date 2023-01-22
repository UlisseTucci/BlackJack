package it.unical.demacs.controller;

import it.unical.demacs.view.GameTableFrame;
import it.unical.demacs.view.MyButton;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameTableController implements ActionListener {
    private GameTableFrame gameTableFrame;

    // private CardStack cardstack;
    // private Dealer dealer;
    // private Player player;
    // private Statistic statistic;

    public GameTableController(GameTableFrame gameTableFrame) {
        this.gameTableFrame = gameTableFrame;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object selectedButton = e.getSource();

        if (selectedButton instanceof JButton || selectedButton instanceof MyButton) {

        }
        /*
        if (selectedButton == gameTableFrame.get) {
            //TODO: HAI SELEZIONATO IL BOTTONE PER TORNARE ALLA HOME.
            System.out.println("HAI PREMUTO IL BOTTONE 'HOME'!");
            MenuFrame.getInstance().setVisibile();
            GameTableFrame.getInstance().setInvisibile();
        }
        else if (selectedButton == bet1Btn) {
            System.out.println("HAI PREMUTO IL BOTTONE 'BET $1'!");
            cardFieldPanel.inizializzaMano();
        }
        else if (selectedButton == bet5Btn) {
            System.out.println("HAI PREMUTO IL BOTTONE 'BET $5'!");
        }*/
    }
}
