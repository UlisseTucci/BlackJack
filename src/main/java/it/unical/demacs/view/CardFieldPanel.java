package it.unical.demacs.view;

import it.unical.demacs.controller.CommandPanelController;
import it.unical.demacs.model.Card;
import it.unical.demacs.model.CardStack;

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
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Dimension d = new Dimension(200, 40);
        dealerPanel.setPreferredSize(d);
        playerPanel.setPreferredSize(d);
        this.add(dealerPanel);
        this.add(playerPanel);
    }

    public void dealCard(Card dealerCard, Card playerCard1, Card playerCard2) {
        this.playerPanel.removeCard();
        this.dealerPanel.removeCard();
        this.repaint();
        this.revalidate();

        JLabel dealerCardLabel = new JLabel(readCard(dealerCard.getType() + dealerCard.getPicture()));
        System.out.println("Leggi la seguente carta: " + dealerCard.getType() + dealerCard.getPicture());
        this.dealerPanel.setCard(dealerCardLabel);
        //this.dealerPanel.setCard(dealerCardLabel);

        JLabel playerCardLabel1 = new JLabel(readCard(playerCard1.getType() + playerCard1.getPicture()));
        JLabel playerCardLabel2 = new JLabel(readCard(playerCard2.getType() + playerCard2.getPicture()));
        this.playerPanel.setCard(playerCardLabel1);
        this.playerPanel.setCard(playerCardLabel2);
        //this.playerPanel.add(playerCardLabel1);
        //this.playerPanel.add(playerCardLabel2);
    }

    public void askCard(Card playerCard) {
        JLabel playerCardLabel = new JLabel(readCard(playerCard.getType() + playerCard.getPicture()));
        this.playerPanel.setCard(playerCardLabel);
        //this.playerPanel.add(playerCardLabel);
    }

    public void askDealerCard(Card dealerCard) {
        JLabel dealerCardLabel = new JLabel(readCard(dealerCard.getType() + dealerCard.getPicture()));
        this.dealerPanel.setCard(dealerCardLabel);
    }

    public ImageIcon readCard(String str) {
        ImageIcon icon = new ImageIcon(PATH + str + ".png");
        //System.out.println(PATH + str + ".png");
        Image image = icon.getImage();
        Image logos = image.getScaledInstance(170, 237, Image.SCALE_SMOOTH);
        icon = new ImageIcon(logos);
        return icon;
    }

    public void setPoints(int dealerPoints, int playerPoints) {
        this.dealerPanel.setScore(dealerPoints);
        this.playerPanel.setScore(playerPoints);
    }

    public void clearPanel() {
        this.playerPanel.removeCard();
        this.dealerPanel.removeCard();
        this.repaint();
        this.revalidate();
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
