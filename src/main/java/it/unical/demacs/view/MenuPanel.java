package it.unical.demacs.view;

import it.unical.demacs.controller.MenuPanelController;
import javax.swing.*;
import java.awt.*;

public class MenuPanel extends MyPanel {

    private static final long serialVersionUID = 1239220200285442212L;
    private MenuButton playBtn = new MenuButton("PLAY", MenuButton.PLAY);;
    private MenuButton statisticsBtn = new MenuButton("STATISTICS", MenuButton.STATISTIC);
    private MenuButton settingsBtn = new MenuButton("SETTINGS", MenuButton.SETTINGS);
    private MenuButton exitBtn = exitBtn = new MenuButton("EXIT", MenuButton.EXIT);

    public MenuPanel() {
        this.setLayout(new BorderLayout());
        JPanel centerPanel = new JPanel();
        JPanel northPanel = new JPanel();
        northPanel.setOpaque(false);
        Dimension d = new Dimension(10, 200);
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
        centerPanel.setLayout(new GridLayout(4,1));

        centerPanel.add(playBtn);
        centerPanel.add(statisticsBtn);
        centerPanel.add(settingsBtn);
        centerPanel.add(exitBtn);
        exitBtn.setColorClick(Color.RED);
    }

    public void setController(MenuPanelController menuPanelController) {
        this.playBtn.addActionListener(menuPanelController);
        this.statisticsBtn.addActionListener(menuPanelController);
        this.settingsBtn.addActionListener(menuPanelController);
        this.exitBtn.addActionListener(menuPanelController);
    }
}
