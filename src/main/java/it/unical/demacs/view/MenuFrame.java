package it.unical.demacs.view;

import it.unical.demacs.Settings;
import it.unical.demacs.controller.MenuPanelController;
import javax.swing.*;

public class MenuFrame extends JFrame {
    private static MenuFrame instance = null;
    private MenuPanel menuPanel;

    private MenuFrame() {
        this.setTitle("The BlackJack");
        //this.setSize(Settings.WIDTH, Settings.HEIGHT);
        this.setExtendedState(MenuFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setVisible(false);

        this.menuPanel = new MenuPanel();
        MenuPanelController menuPanelController = new MenuPanelController();
        this.menuPanel.setController(menuPanelController);
        this.add(menuPanel);
    }

    public static MenuFrame getInstance() {
        if (instance == null) {
            instance = new MenuFrame();
        }
        return instance;
    }

    public void setVisibile() {
        // Rendiamo il frame visibile
        this.setVisible(true);
    }

    public void setInvisibile() {
        // Rendiamo il frame invisibile
        this.setVisible(false);
    }
}
