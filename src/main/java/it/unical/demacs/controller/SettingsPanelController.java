package it.unical.demacs.controller;

import it.unical.demacs.model.Game;
import it.unical.demacs.view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsPanelController implements ActionListener {

    public SettingsPanelController() {}

    @Override
    public void actionPerformed(ActionEvent e) {
        Object selectedButton = e.getSource();

        if (selectedButton instanceof SettingsButton) {
            SettingsButton settingsButton = (SettingsButton) selectedButton;

            switch (settingsButton.getType()) {
                case SettingsButton.MAIN -> { MyPanel.setTableBackground(0); SettingsFrame.getInstance().repaint(); }
                case SettingsButton.RED -> { MyPanel.setTableBackground(1); SettingsFrame.getInstance().repaint(); }
                case SettingsButton.BLUE -> { MyPanel.setTableBackground(2); SettingsFrame.getInstance().repaint(); }
                case SettingsButton.YELLOW -> { MyPanel.setTableBackground(3); SettingsFrame.getInstance().repaint(); }
                case SettingsButton.PURPLE -> { MyPanel.setTableBackground(4); SettingsFrame.getInstance().repaint(); }
                case SettingsButton.RED1 -> { MyPanel.setTableBackground(5); SettingsFrame.getInstance().repaint(); }
            }
        }

    }
}
