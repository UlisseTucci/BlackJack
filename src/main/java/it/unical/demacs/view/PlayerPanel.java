package it.unical.demacs.view;

import javax.swing.*;
import java.awt.*;

public class PlayerPanel extends JPanel {
    private JPanel northPanel;
    private JPanel southPanel;
    private JPanel eastPanel;
    private JPanel westPanel;
    private JPanel centerPanel;
    private JLabel scoreLabel;
    public PlayerPanel() {
        this.setLayout(new BorderLayout());

        this.centerPanel = new JPanel(); // CENTER
        this.centerPanel.setOpaque(false);
        //this.centerPanel.setLayout(new GridLayout());
        this.northPanel = new JPanel(); // NORD
        this.northPanel.setOpaque(false);
        this.scoreLabel = new JLabel("You:");
        this.scoreLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        this.scoreLabel.setForeground(Color.WHITE);
        this.northPanel.add(scoreLabel);
        this.southPanel = new JPanel(); // SOUTH
        this.southPanel.setOpaque(false);
        this.eastPanel = new JPanel(); // EAST
        this.eastPanel.setOpaque(false);
        this.westPanel = new JPanel(); // WEST
        this.westPanel.setOpaque(false);

        this.add(centerPanel, BorderLayout.CENTER);
        this.add(northPanel, BorderLayout.NORTH);
        this.add(southPanel, BorderLayout.SOUTH);
        this.add(eastPanel, BorderLayout.EAST);
        this.add(westPanel, BorderLayout.WEST);
    }

    public void setCard(JLabel card) {
        this.centerPanel.add(card);
    }

    public void setScore(int score) {
        this.scoreLabel.setText("You: " + score);
    }

    public void setAlternativScore(int score1, int score2) { this.scoreLabel.setText("Dealer: " + score1 + "/" + score2); }

    public void removeCard() {
        this.centerPanel.removeAll();
    }
}
