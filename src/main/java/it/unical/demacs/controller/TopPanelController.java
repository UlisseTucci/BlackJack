package it.unical.demacs.controller;

import it.unical.demacs.view.GameTableFrame;
import it.unical.demacs.view.MenuFrame;
import it.unical.demacs.view.TopButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopPanelController implements ActionListener {

    public TopPanelController() {}

    @Override
    public void actionPerformed(ActionEvent e) {
        Object selectedButton = e.getSource();

        if (selectedButton instanceof TopButton) {
            TopButton topButton = (TopButton) selectedButton;

            switch (topButton.getType()) {
                case TopButton.HOME -> {
                    System.out.println("Hai premuto il tasto per tornare alla HOMEPAGE!");
                    MenuFrame.getInstance().setVisibile();
                    GameTableFrame.getInstance().setInvisibile();
                }
            }
        }
    }
}
