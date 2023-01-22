package it.unical.demacs.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MyPanel extends JPanel {

    private BufferedImage backgroundImage = null;

    private static int sfondo = 0;

    public MyPanel() {}

    public static void setSfondo(int i) {
        sfondo = i;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics g2 = (Graphics2D) g;

        // Background
        try {
            // backgroundImage = ImageIO.read(new File("src/main/resources/grassbackground.png"));
            BufferedImage image = null;

            switch (sfondo) {
                case 0:
                    image = ImageIO.read(new File("src/main/resources/mainbackground.png"));
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
}
