package it.unical.demacs.view;

import it.unical.demacs.Settings;
import it.unical.demacs.controller.CommandPanelController;
import it.unical.demacs.controller.TopPanelController;
import it.unical.demacs.model.Card;
import it.unical.demacs.model.Game;

import javax.swing.*;
import java.awt.*;

public class GameTableFrame extends JFrame {
    private static GameTableFrame instance = null;
    private InfoPanel infoPanel;
    private CardFieldPanel cardFieldPanel;
    private CommandPanel commandPanel;
    private TopPanel topPanel;
    private int possibleWin = 0;

    private GameTableFrame() {

        this.setTitle("The BlackJack");
        //this.setSize(Settings.WIDTH, Settings.HEIGHT);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setVisible(false);

        MyPanel mainPanel = new MyPanel();
        mainPanel.setLayout(new BorderLayout());

        this.cardFieldPanel = new CardFieldPanel(); // CENTRALE
        this.topPanel = new TopPanel(); // NORD
        Dimension n = new Dimension(10, 80);
        this.topPanel.setPreferredSize(n);
        this.topPanel.setOpaque(false);
        TopPanelController topPanelController = new TopPanelController();
        this.topPanel.setController(topPanelController);
        this.commandPanel = new CommandPanel(); // SOUTH
        Dimension s = new Dimension(10, 50);
        this.commandPanel.setPreferredSize(s);
        this.commandPanel.setOpaque(false);
        CommandPanelController commandPanelController = new CommandPanelController();
        this.commandPanel.setController(commandPanelController);
        this.infoPanel = new InfoPanel(); // WEST
        infoPanel.setOpaque(false);
        Dimension e = new Dimension(300, 10);
        infoPanel.setPreferredSize(e);
        JPanel westPanel = new JPanel(); // EAST
        westPanel.setOpaque(false);
        Dimension w = new Dimension(10, 10);
        westPanel.setPreferredSize(w);

        mainPanel.add(cardFieldPanel, BorderLayout.CENTER);
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(commandPanel, BorderLayout.SOUTH);
        mainPanel.add(infoPanel, BorderLayout.WEST);
        mainPanel.add(westPanel, BorderLayout.EAST);
        this.add(mainPanel);
    }

    public static GameTableFrame getInstance() {
        if (instance == null) {
            instance = new GameTableFrame();
        }
        return instance;
    }

    public void setVisibile() { this.setVisible(true); }

    public void setInvisibile() {
        this.setVisible(false);
    }

    public int getMoney() {
        return this.infoPanel.getMoney();
    }

    public void setMoney(int money) {
        this.infoPanel.setMoney(money);
    }

    public int getBet() {
        return this.infoPanel.getBet();
    }

    public void setBet(int bet) {
        this.infoPanel.setBet(bet);
    }

    public void showStartMessage() {
        JOptionPane.showMessageDialog(this, "Benvenuto giocatore." +
                "\nEffettuare una puntata prima di iniziare il gioco.");
        this.commandPanel.betStatus();
    }

    public void gameStatus() {
        this.commandPanel.playStatus();
        //this.cardFieldPanel.startGame();
    }

    public void dealCard(Card dealerCard, Card playerCard1, Card playerCard2) {
        this.cardFieldPanel.dealCard(dealerCard, playerCard1, playerCard2);
    }

    public void setPoints(int dealerPoints, int playerPoints) {
        this.cardFieldPanel.setPoints(dealerPoints, playerPoints);
    }

    public void askCard(Card playerCard) {
        this.cardFieldPanel.askCard(playerCard);
    }

    public void askDealerCard(Card dealerCard) {
        this.cardFieldPanel.askDealerCard(dealerCard);
    }

    public void dealerWin() {
        JOptionPane.showMessageDialog(this, "Dealer Win!");
        resetGame();
        //TODO: Sistemare i soldi vinti...
    }

    public void playerWin() {
        JOptionPane.showMessageDialog(this, "Player Win!");
        int currentMoney = this.infoPanel.getMoney();
        currentMoney += possibleWin*2;
        this.infoPanel.setMoney(currentMoney);
        resetGame();
        //TODO: Sistemare i soldi vinti...
    }

    public void pareggio() {
        JOptionPane.showMessageDialog(this, "Pareggio!");
        int currentMoney = this.infoPanel.getMoney();
        currentMoney += possibleWin;
        this.infoPanel.setMoney(currentMoney);
        resetGame();
        //TODO: Sistemare i soldi vinti...
    }

    public void resetGame() {
        // TODO: Resettare il gioco...
        this.commandPanel.betStatus();
        this.cardFieldPanel.clearPanel();
        Game.getInstance().dealCard();

    }

    public void setPossibleWin(int totalBet) {
        this.possibleWin = totalBet;
    }

    public void playerBusted() {
        JOptionPane.showMessageDialog(this, "Bust! Dealer Win!");
        resetGame();
    }

    public void dealerBusted() {
        JOptionPane.showMessageDialog(this, "Bust! Player Win!");
        int currentMoney = this.infoPanel.getMoney();
        currentMoney += possibleWin*2;
        this.infoPanel.setMoney(currentMoney);
        resetGame();
    }























/*

    public void eliminaMetodo() {
        this.cardFieldPanel.inizializzaMano();
    }

    public void betButtonSelected() {
        startGame();
        eliminaMetodo();
        //TODO: Inserire il movimento della carte...
    }




 */

}
