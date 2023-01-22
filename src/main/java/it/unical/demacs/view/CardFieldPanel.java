package it.unical.demacs.view;

import javax.swing.*;
import java.awt.*;

public class CardFieldPanel extends JPanel {

    private static String PATH = "src/main/resources/";
    private PlayerPanel playerPanel;
    private DealerPanel dealerPanel;
    public CardFieldPanel() {
        this.setOpaque(false);
        this.dealerPanel = new DealerPanel();
        this.playerPanel = new PlayerPanel();
        dealerPanel.setOpaque(false);
        playerPanel.setOpaque(false);
        // dealerPanel.setBackground(Color.BLACK);
        // playerPanel.setBackground(Color.RED);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Dimension d = new Dimension(200, 40);
        dealerPanel.setPreferredSize(d);
        playerPanel.setPreferredSize(d);

        this.add(dealerPanel);
        this.add(playerPanel);
    }

    public void inizializzaMano() {
        ImageIcon icon = new ImageIcon(PATH + "card.png");
        Image im = icon.getImage();
        Image logos = im.getScaledInstance(120, 167, Image.SCALE_SMOOTH);
        icon = new ImageIcon(logos);
        JLabel card = new JLabel(icon);
        dealerPanel.add(card);

        ImageIcon icon1 = new ImageIcon(PATH + "card.png");
        Image im1 = icon1.getImage();
        Image logos1 = im1.getScaledInstance(120, 167, Image.SCALE_SMOOTH);
        icon1 = new ImageIcon(logos1);
        JLabel card1 = new JLabel(icon);
        playerPanel.setCard(card1);
        this.playerPanel.setScore(10);

        this.repaint();
        this.revalidate();
    }

    /*
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics g2 = (Graphics2D) g;
        //g2.drawImage(backgroundImage, 0, 0, null);
        g2.fillRect(10, 10, 30, 30);
    }
    */
}
