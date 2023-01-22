package it.unical.demacs.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameTablePanel extends MyPanel implements ActionListener {

    private static GameTablePanel instance;
    private final JButton bet1Btn = new JButton("BET $1");
    private final JButton bet5Btn = new JButton("BET $5");
    private final JButton bet25Btn = new JButton("BET $25");
    private final JButton bet100Btn = new JButton("BET $100");
    private final JButton clearBetBtn = new JButton("CLEAR BET");
    private final JButton dealBtn = new JButton("DEAL");
    private final JButton hitBtn = new JButton("HIT");
    private final JButton standBtn = new JButton("STAND");
    private final JButton surrendBtn = new JButton("SURREND");
    private final MyButton homeBtn = new MyButton("HOME");

    private GameTablePanel() {

        // Layout
        this.setLayout(new BorderLayout());

        // Panel
        MyPanel commandPanel = new MyPanel();
        MyPanel nordPanel = new MyPanel();
        MyPanel infoPanel = new MyPanel();
        this.add(commandPanel, BorderLayout.PAGE_END);
        this.add(nordPanel, BorderLayout.NORTH);
        //this.add(infoPanel, BorderLayout.WEST);
        commandPanel.add(bet1Btn);
        commandPanel.add(bet5Btn);
        commandPanel.add(bet25Btn);
        commandPanel.add(bet100Btn);
        commandPanel.add(clearBetBtn);
        commandPanel.add(dealBtn);
        commandPanel.add(hitBtn);
        commandPanel.add(standBtn);
        commandPanel.add(surrendBtn);
        nordPanel.add(homeBtn);

        // Button
        bet1Btn.addActionListener(this);
        bet5Btn.addActionListener(this);
        bet25Btn.addActionListener(this);
        bet100Btn.addActionListener(this);
        clearBetBtn.addActionListener(this);
        dealBtn.addActionListener(this);
        hitBtn.addActionListener(this);
        standBtn.addActionListener(this);
        surrendBtn.addActionListener(this);
        homeBtn.addActionListener(this);

    }

    public static GameTablePanel getInstance() {
        if (instance == null) {
            instance = new GameTablePanel();
        }
        return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object selectedButton = e.getSource();

        if (selectedButton == homeBtn) {
            //TODO: HAI SELEZIONATO IL BOTTONE PER TORNARE ALLA HOME.
            System.out.println("HAI PREMUTO IL BOTTONE 'HOME'!");
            MenuFrame.getInstance().setVisibile();
            GameTableFrame.getInstance().setInvisibile();
        }
        else if (selectedButton == bet1Btn) {
            //TODO: HAI SELEZIONATO IL BOTTONE PER VISUALIZZARE LE STATISTICHE.
            System.out.println("HAI PREMUTO IL BOTTONE 'BET $1'!");
        }
    }
}
