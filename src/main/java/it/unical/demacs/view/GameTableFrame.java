package it.unical.demacs.view;

import it.unical.demacs.Settings;
import it.unical.demacs.controller.CommandPanelController;
import it.unical.demacs.controller.TopPanelController;
import javax.swing.*;
import java.awt.*;

public class GameTableFrame extends JFrame {
    private static GameTableFrame instance = null;
    private InfoPanel infoPanel;
    private CardFieldPanel cardFieldPanel;
    private CommandPanel commandPanel;
    private TopPanel topPanel;
    private JOptionPane startOptionPane = new JOptionPane();

    private GameTableFrame() {

        this.setTitle("The BlackJack");
        this.setSize(Settings.WIDTH, Settings.HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setUndecorated(false);
        this.setVisible(false);

        MyPanel mainPanel = new MyPanel();
        mainPanel.setLayout(new BorderLayout());

        this.cardFieldPanel = new CardFieldPanel(); // CENTRALE
        //cardFieldPanel.setOpaque(false);

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
        Dimension e = new Dimension(200, 10);
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

    public void setVisibile() {

        this.setVisible(true);
    }

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

    public void eliminaMetodo() {
        this.cardFieldPanel.inizializzaMano();
    }

    public void showStartMessage() {
        JOptionPane.showMessageDialog(this, "Benvenuto giocatore." +
                "\nEffettuare una puntata prima di iniziare il gioco.");
        this.commandPanel.betStatus();
    }

    public void startGame() {
        this.commandPanel.playStatus();
    }
}
