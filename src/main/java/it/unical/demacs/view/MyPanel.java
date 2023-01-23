package it.unical.demacs.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MyPanel extends JPanel {

    //private BufferedImage backgroundImage = null;
    private Image backgroundImage = null;
    private Image cardBackgroundImage = null;
    private static int tableBackground = 0;
    private static int cardBackground = 0;

    public MyPanel() {}

    public static void setTableBackground(int index) {
        tableBackground = index;
    }
    public static void setCardBackground(int index) {
        cardBackground = index;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics g2 = (Graphics2D) g;

        //Table background
        try {
            String PATH_TABLE_BACKGROUND = "src/main/resources/table_background/";
            switch (tableBackground) {
                case 0 -> this.backgroundImage = ImageIO.read(new File(PATH_TABLE_BACKGROUND + "mainbackground.png"));
                case 1 -> this.backgroundImage = ImageIO.read(new File(PATH_TABLE_BACKGROUND + "redbackground.png"));
                case 2 -> this.backgroundImage = ImageIO.read(new File(PATH_TABLE_BACKGROUND + "bluebackground.png"));
                case 3 -> this.backgroundImage = ImageIO.read(new File(PATH_TABLE_BACKGROUND + "yellowbackground.png"));
                case 4 -> this.backgroundImage = ImageIO.read(new File(PATH_TABLE_BACKGROUND + "purplebackground.png"));
                case 5 -> this.backgroundImage = ImageIO.read(new File(PATH_TABLE_BACKGROUND + "red1background.png"));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Card background
        try { //TODO: Aggiungere altri back per le carte...
            String PATH_CARD_BACKGROUND = "src/main/resources/card_background/";
            switch (cardBackground) {
                case 0 -> this.cardBackgroundImage = ImageIO.read(new File(PATH_CARD_BACKGROUND + "mainback.png"));
                case 1 -> this.cardBackgroundImage = ImageIO.read(new File(PATH_CARD_BACKGROUND + "blueback.png"));
                case 2 -> this.cardBackgroundImage = ImageIO.read(new File(PATH_CARD_BACKGROUND + "greenback.png"));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        g2.drawImage(this.backgroundImage, 0, 0, null);
        g2.drawImage(this.cardBackgroundImage, 1250, 300, null);
    }




























    /*
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics g2 = (Graphics2D) g;

        // Background
        try {
            // backgroundImage = ImageIO.read(new File("src/main/resources/grassbackground.png"));
            BufferedImage image = null;

            switch (cardBackground) {
                case 0:
                    image = ImageIO.read(new File(PATH_TABLE_BACKGROUND + "mainbackground.png"));
                    break;
                case 1:
                    image = ImageIO.read(new File("src/main/resources/redbackground.png"));
                    break;
                case 2:
                    image = ImageIO.read(new File("src/main/resources/bluebackground.png"));
                    break;
                case 3:
                    image = ImageIO.read(new File("src/main/resources/darkbluebackground.png"));
                    break;
                case 4:
                    image = ImageIO.read(new File("src/main/resources/graybackground.png"));
                    break;
                case 5:
                    image = ImageIO.read(new File("src/main/resources/redbackground1.png"));
                    break;
                case 6:
                    image = ImageIO.read(new File("src/main/resources/paperbackground.png"));
                    break;
                case 7:
                    image = ImageIO.read(new File("src/main/resources/leafsbackground.png"));
                    break;
                case 8:
                    image = ImageIO.read(new File("src/main/resources/flowristbackground.png"));
                    break;
                case 9:
                    image = ImageIO.read(new File("src/main/resources/background.png"));
                    break;
            }
            if (image != null) {
                Image scaledImage = image.getScaledInstance(300, 150, Image.SCALE_SMOOTH);
                backgroundImage = (BufferedImage) image;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        g2.drawImage(backgroundImage, 0, 0, null);
    }
    */
}
