package it.unical.demacs.view;

import it.unical.demacs.controller.TopPanelController;
import javax.swing.*;

public class TopPanel extends JPanel {

    private static final long serialVersionUID = 1292201700028542212L;
    private TopButton homeBtn = new TopButton("HOME", TopButton.HOME);

    public TopPanel() {
        this.add(homeBtn);
    }

    public void setController(TopPanelController topPanelController) {
        this.homeBtn.addActionListener(topPanelController);
    }
}
