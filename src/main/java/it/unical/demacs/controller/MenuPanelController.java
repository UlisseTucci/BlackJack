package it.unical.demacs.controller;

import it.unical.demacs.model.Game;
import it.unical.demacs.view.*;

import javax.swing.*;
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
                    MenuFrame.getInstance().setInvisibile();
                    SettingsFrame.getInstance().setInvisibile();
                    StatisticFrame.getInstance().setInvisibile();
                    GameTableFrame.getInstance().setVisibile();
                    GameTableFrame.getInstance().resetGame();
                    GameTableFrame.getInstance().showStartMessage();
                    Game.getInstance().start();
                }
                case MenuButton.STATISTIC -> {
                    MenuFrame.getInstance().setInvisibile();
                    GameTableFrame.getInstance().setInvisibile();
                    StatisticFrame.getInstance().setVisibile();
                }
                case MenuButton.SETTINGS -> {
                    MenuFrame.getInstance().setInvisibile();
                    GameTableFrame.getInstance().setInvisibile();
                    StatisticFrame.getInstance().setInvisibile();
                    SettingsFrame.getInstance().setVisibile();
                    SettingsFrame.getInstance().showMessage();

                    // MyPanel.setTableBackground(5);
                    // MenuFrame.getInstance().repaint();
                    // GameTableFrame.getInstance().resetGame();
                    // Game.getInstance().start();
                }
                case MenuButton.EXIT -> {
                    System.out.println("HAI PREMUTO IL BOTTONE 'EXIT'!");
                    System.exit(0);
                }
            }
        }
    }
}