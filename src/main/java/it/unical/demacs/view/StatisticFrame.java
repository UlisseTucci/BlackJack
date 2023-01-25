package it.unical.demacs.view;

import it.unical.demacs.controller.SettingsPanelController;
import it.unical.demacs.controller.TopPanelController;

import javax.swing.*;
import java.awt.*;

public class StatisticFrame extends JFrame {
    private static StatisticFrame instance = null;
    private TopButton homeBtn = new TopButton("HOME", TopButton.HOME);
    private StatisticPanel statisticPanel;

    private StatisticFrame() {
        this.setTitle("The BlackJack");
        //this.setSize(Settings.WIDTH, Settings.HEIGHT);
        this.setExtendedState(MenuFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setVisible(false);

        MyPanel mainPanel = new MyPanel();
        mainPanel.setLayout(new BorderLayout());

        this.statisticPanel = new StatisticPanel(); // CENTER
        this.statisticPanel.setOpaque(false);

        JPanel northPanel = new JPanel(); // NORTH
        Dimension d = new Dimension(10, 300);
        northPanel.setPreferredSize(d);
        northPanel.setOpaque(false);
        northPanel.add(this.homeBtn);

        JPanel southPanel = new JPanel(); // SOUTH
        southPanel.setOpaque(false);
        southPanel.setPreferredSize(d);

        JPanel eastPanel = new JPanel(); // EAST
        Dimension d2 = new Dimension(300, 10);
        eastPanel.setPreferredSize(d2);
        eastPanel.setOpaque(false);

        JPanel westPanel = new JPanel(); // WEST
        Dimension d3 = new Dimension(500, 10);
        westPanel.setPreferredSize(d3);
        westPanel.setOpaque(false);


        mainPanel.add(this.statisticPanel, BorderLayout.CENTER);
        mainPanel.add(northPanel, BorderLayout.NORTH);
        mainPanel.add(southPanel, BorderLayout.SOUTH);
        mainPanel.add(eastPanel, BorderLayout.EAST);
        mainPanel.add(westPanel, BorderLayout.WEST);
        this.add(mainPanel);

        TopPanelController topPanelController = new TopPanelController();
        this.setController(topPanelController);

    }

    public static StatisticFrame getInstance() {
        if (instance == null) {
            instance = new StatisticFrame();
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

    public void setController(TopPanelController topPanelController) { //TODO: Inserire il controller giusto
        this.homeBtn.addActionListener(topPanelController);
    }

    public void setVittorieTotali() {
        int current = this.statisticPanel.getVittorieTotali();
        current++;
        this.statisticPanel.setVittorieTotali(current);
    }

    public void setSconfitteTotali() {
        int current = this.statisticPanel.getSconfitteTotali();
        current++;
        this.statisticPanel.setSconfitteTotali(current);
    }

    public void setDenaroGuadagnato(int denaroGuadagnato) {
        int current = this.statisticPanel.getDenaroGuadagnato();
        current += denaroGuadagnato;
        this.statisticPanel.setDenaroGuadagnato(current);

        int currentBestWin = this.statisticPanel.getVittoriaMigliore();
        if(denaroGuadagnato > currentBestWin)
            this.statisticPanel.setVittoriaMigliore(denaroGuadagnato);
    }

    public void setDenaroPerso(int denaroPerso) {
        int current = this.statisticPanel.getDenaroPerso();
        current += denaroPerso;
        this.statisticPanel.setDenaroPerso(current);

        int currentBestLost = this.statisticPanel.getSconfittaMaggiore();
        if (denaroPerso > currentBestLost)
            this.statisticPanel.setSconfittaMaggiore(denaroPerso);
    }
}
