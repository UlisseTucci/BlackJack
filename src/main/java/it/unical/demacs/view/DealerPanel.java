package it.unical.demacs.view;

import javax.swing.*;
import java.awt.*;

public class DealerPanel extends JPanel {
    private JPanel northPanel;
    private JPanel southPanel;
    private JPanel eastPanel;
    private JPanel westPanel;
    private JPanel centerPanel;
    private JLabel scoreLabel;

    public DealerPanel() {
        this.setLayout(new BorderLayout());

        this.centerPanel = new JPanel(); // CENTER
        this.centerPanel.setOpaque(false);

        this.northPanel = new JPanel(); // NORD
        this.northPanel.setOpaque(false);
        this.scoreLabel = new JLabel("Dealer:");
        this.scoreLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
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
        this.scoreLabel.setText("Dealer: " + score);
    }
}
