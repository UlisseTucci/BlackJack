package it.unical.demacs.controller;

import it.unical.demacs.model.Game;
import it.unical.demacs.view.GameTableFrame;
import it.unical.demacs.view.MenuButton;
import it.unical.demacs.view.MenuFrame;
import it.unical.demacs.view.MyPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanelController implements ActionListener {

    public MenuPanelController() {}

    @Override
    public void actionPerformed(ActionEvent e) {
        Object selectedButton = e.getSource();

        if (selectedButton instanceof MenuButton) {
            MenuButton menuButton = (MenuButton) selectedButton;

            switch (menuButton.getType()) {
                case MenuButton.PLAY -> {
                    //TODO: HAI SELEZIONATO IL BOTTONE PER GIOCARE.
                    System.out.println("HAI PREMUTO IL BOTTONE 'PLAY'!");
                    MenuFrame.getInstance().setInvisibile();
                    GameTableFrame.getInstance().setVisibile();
                    GameTableFrame.getInstance().resetGame();
                    GameTableFrame.getInstance().showStartMessage();
                    Game.getInstance().start();
                }
                case MenuButton.STATISTIC -> {
                    //TODO: HAI SELEZIONATO IL BOTTONE PER VISUALIZZARE LE STATISTICHE.
                    System.out.println("HAI PREMUTO IL BOTTONE 'STATISTICS'!");
                }
                case MenuButton.SETTINGS -> {
                    //TODO: HAI SELEZIONATO IL BOTTONE PER VISUALIZZARE LE IMPOSTAZIONI.
                    System.out.println("HAI PREMUTO IL BOTTONE 'SETTINGS'!");
                    MyPanel.setSfondo(5);
                    MenuFrame.getInstance().repaint();
                    GameTableFrame.getInstance().resetGame();
                    Game.getInstance().start();
                }
                case MenuButton.EXIT -> {
                    System.out.println("HAI PREMUTO IL BOTTONE 'EXIT'!");
                    System.exit(0);
                }
            }
        }
    }
}