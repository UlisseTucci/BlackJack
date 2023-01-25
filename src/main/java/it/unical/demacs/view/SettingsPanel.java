package it.unical.demacs.view;

import it.unical.demacs.controller.SettingsPanelController;
import it.unical.demacs.controller.TopPanelController;

import javax.swing.*;
import java.awt.*;

public class SettingsPanel extends MyPanel {

    private TopButton homeBtn = new TopButton("HOME", TopButton.HOME);
    private SettingsButton mainBtn;
    private SettingsButton redBtn;
    private SettingsButton blueBtn;
    private SettingsButton yellowBtn;
    private SettingsButton purpleBtn;
    private SettingsButton red1Btn;

    public SettingsPanel() {
        this.setLayout(new BorderLayout());
        JPanel centerPanel = new JPanel();
        JPanel northPanel = new JPanel();
        northPanel.setOpaque(false);
        Dimension d = new Dimension(10, 300);
        northPanel.setPreferredSize(d);
        JPanel southPanel = new JPanel();
        southPanel.setOpaque(false);
        southPanel.setPreferredSize(d);
        JPanel eastPanel = new JPanel();
        eastPanel.setOpaque(false);
        Dimension d2 = new Dimension(400, 10);
        eastPanel.setPreferredSize(d2);
        JPanel westPanel = new JPanel();
        westPanel.setOpaque(false);
        westPanel.setPreferredSize(d2);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(northPanel, BorderLayout.NORTH);
        this.add(southPanel, BorderLayout.SOUTH);
        this.add(eastPanel, BorderLayout.EAST);
        this.add(westPanel, BorderLayout.WEST);

        //TODO: Sistemazione immagini
        centerPanel.setLayout(new GridLayout(1,4));

        //TODO: Assegnare l'immagine ad ogni bottone e eliminare sfondi, bordi, etc.
        ImageIcon main = new ImageIcon("src/main/resources/table_background/mainbackground.png");
        ImageIcon red = new ImageIcon("src/main/resources/table_background/redbackground.png");
        ImageIcon blue = new ImageIcon("src/main/resources/table_background/bluebackground.png");
        ImageIcon yellow = new ImageIcon("src/main/resources/table_background/yellowbackground.png");
        ImageIcon purple = new ImageIcon("src/main/resources/table_background/purplebackground.png");
        ImageIcon red1 = new ImageIcon("src/main/resources/table_background/red1background.png");
        this.mainBtn = new SettingsButton(main, SettingsButton.MAIN);
        this.redBtn = new SettingsButton(red, SettingsButton.RED);
        this.blueBtn = new SettingsButton(blue, SettingsButton.BLUE);
        this.yellowBtn = new SettingsButton(yellow, SettingsButton.YELLOW);
        this.purpleBtn = new SettingsButton(purple, SettingsButton.PURPLE);
        this.red1Btn = new SettingsButton(red1, SettingsButton.RED1);

        centerPanel.add(this.mainBtn);
        centerPanel.add(this.redBtn);
        centerPanel.add(this.blueBtn);
        centerPanel.add(this.yellowBtn);
        centerPanel.add(this.purpleBtn);
        centerPanel.add(this.red1Btn);
        northPanel.add(homeBtn);
    }

    public void setController(SettingsPanelController settingsPanelController, TopPanelController topPanelController) { //TODO: Inserire il controller giusto
        this.mainBtn.addActionListener(settingsPanelController);
        this.redBtn.addActionListener(settingsPanelController);
        this.blueBtn.addActionListener(settingsPanelController);
        this.yellowBtn.addActionListener(settingsPanelController);
        this.purpleBtn.addActionListener(settingsPanelController);
        this.red1Btn.addActionListener(settingsPanelController);
        this.homeBtn.addActionListener(topPanelController);
    }
}
