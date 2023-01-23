package it.unical.demacs.view;

import it.unical.demacs.controller.CommandPanelController;
import java.awt.*;

public class CommandPanel extends MyPanel {

    private static final long serialVersionUID = 1235020502851442212L;
    private final GameButton bet1Btn = new GameButton("BET $1", GameButton.BET_1);
    private final GameButton bet5Btn = new GameButton("BET $5", GameButton.BET_5);
    private final GameButton bet25Btn = new GameButton("BET $25", GameButton.BET_25);
    private final GameButton bet100Btn = new GameButton("BET $100", GameButton.BET_100);
    private final GameButton clearBetBtn = new GameButton("CLEAR BET", GameButton.CLEAR_BET);
    private final GameButton betBtn = new GameButton("BET", GameButton.BET);
    private final GameButton hitBtn = new GameButton("HIT", GameButton.HIT);
    private final GameButton standBtn = new GameButton("STAND", GameButton.STAND);
    private final GameButton surrendBtn = new GameButton("SURREND", GameButton.SURREND);

    public CommandPanel() {
        int size = 22;
        this.bet1Btn.setFont(new Font("Comic Sans MS", Font.BOLD, size));
        this.bet5Btn.setFont(new Font("Comic Sans MS", Font.BOLD, size));
        this.bet25Btn.setFont(new Font("Comic Sans MS", Font.BOLD, size));
        this.bet100Btn.setFont(new Font("Comic Sans MS", Font.BOLD, size));
        this.clearBetBtn.setFont(new Font("Comic Sans MS", Font.BOLD, size));
        this.betBtn.setFont(new Font("Comic Sans MS", Font.BOLD, size));
        this.hitBtn.setFont(new Font("Comic Sans MS", Font.BOLD, size));
        this.standBtn.setFont(new Font("Comic Sans MS", Font.BOLD, size));
        this.surrendBtn.setFont(new Font("Comic Sans MS", Font.BOLD, size));
        this.bet1Btn.setEnabled(false);
        this.bet5Btn.setEnabled(false);
        this.bet25Btn.setEnabled(false);
        this.bet100Btn.setEnabled(false);
        this.clearBetBtn.setEnabled(false);
        this.betBtn.setEnabled(false);
        this.hitBtn.setEnabled(false);
        this.standBtn.setEnabled(false);
        this.surrendBtn.setEnabled(false);
        this.add(bet1Btn);
        this.add(bet5Btn);
        this.add(bet25Btn);
        this.add(bet100Btn);
        this.add(clearBetBtn);
        this.add(betBtn);
        this.add(hitBtn);
        this.add(standBtn);
        this.add(surrendBtn);
    }

    public void setController(CommandPanelController commandPanelController) {
        this.bet1Btn.addActionListener(commandPanelController);
        this.bet5Btn.addActionListener(commandPanelController);
        this.bet25Btn.addActionListener(commandPanelController);
        this.bet100Btn.addActionListener(commandPanelController);
        this.clearBetBtn.addActionListener(commandPanelController);
        this.betBtn.addActionListener(commandPanelController);
        this.hitBtn.addActionListener(commandPanelController);
        this.standBtn.addActionListener(commandPanelController);
        this.surrendBtn.addActionListener(commandPanelController);
    }

    public void betStatus() {
        this.bet1Btn.setEnabled(true);
        this.bet5Btn.setEnabled(true);
        this.bet25Btn.setEnabled(true);
        this.bet100Btn.setEnabled(true);
        this.clearBetBtn.setEnabled(true);
        this.betBtn.setEnabled(true);
        this.hitBtn.setEnabled(false);
        this.standBtn.setEnabled(false);
        this.surrendBtn.setEnabled(false);
    }

    public void playStatus() {
        this.bet1Btn.setEnabled(false);
        this.bet5Btn.setEnabled(false);
        this.bet25Btn.setEnabled(false);
        this.bet100Btn.setEnabled(false);
        this.clearBetBtn.setEnabled(false);
        this.betBtn.setEnabled(false);
        this.hitBtn.setEnabled(true);
        this.standBtn.setEnabled(true);
        this.surrendBtn.setEnabled(true);
    }

    public void setBet1BtnEnable(boolean enable) { this.bet1Btn.setEnabled(enable); }
    public void setBet5BtnEnable(boolean enable) { this.bet5Btn.setEnabled(enable); }
    public void setBet25BtnEnable(boolean enable) { this.bet25Btn.setEnabled(enable); }
    public void setBet100BtnEnable(boolean enable) { this.bet100Btn.setEnabled(enable); }
    public void setClearBetBtnEnable(boolean enable) { this.clearBetBtn.setEnabled(enable); }
    public void setBetBtnEnable(boolean enable) { this.betBtn.setEnabled(enable); }
    public void setHitBtnEnable(boolean enable) { this.hitBtn.setEnabled(enable); }
    public void setStandBtnEnable(boolean enable) { this.standBtn.setEnabled(enable); }
    public void setSurrendBtnEnable(boolean enable) { this.surrendBtn.setEnabled(enable); }
}
