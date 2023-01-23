package it.unical.demacs.view;

import it.unical.demacs.controller.SettingsPanelController;
import it.unical.demacs.controller.TopPanelController;

import javax.swing.*;

public class SettingsFrame extends JFrame {
    private static SettingsFrame instance = null;
    private SettingsPanel settingsPanel;

    private SettingsFrame() {
        this.setTitle("The BlackJack");
        //this.setSize(Settings.WIDTH, Settings.HEIGHT);
        this.setExtendedState(MenuFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setVisible(false);

        this.settingsPanel = new SettingsPanel();
        SettingsPanelController settingsPanelController = new SettingsPanelController();
        TopPanelController topPanelController = new TopPanelController();
        this.settingsPanel.setController(settingsPanelController, topPanelController);
        this.add(settingsPanel);
    }

    public static SettingsFrame getInstance() {
        if (instance == null) {
            instance = new SettingsFrame();
        }
        return instance;
    }

    public void setVisibile() {
        // Rendiamo il frame visibile
        this.setVisible(true);
    }

    public void setInvisibile() {
        // Rendiamo il frame invisibile
        this.setVisible(false);
    }

    public void showMessage() {
        JOptionPane.showMessageDialog(this, "Clicca un'immagine per cambiare sfondo.");
    }
}
