package it.unical.demacs.view;

import javax.swing.*;
import java.awt.*;

public class StatisticPanel extends JPanel {
    private JLabel vittorieTotaliLab;
    private JLabel sconfitteTotaliLab;
    private JLabel denaroGuadagnatoLab;
    private JLabel denaroPersoLab;
    private JLabel vittoriaMiglioreLab;
    private JLabel sconfittaMaggioreLab;
    private int vittorieTotali = 0;
    private int sconfitteTotali = 0;
    private int denaroGuadagnato = 0;
    private int denaroPerso = 0;
    private int vittoriaMigliore = 0;
    private int sconfittaMaggiore = 0;

    public StatisticPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.vittorieTotaliLab = new JLabel("   Vittorie totali: $" + this.vittorieTotali);
        this.sconfitteTotaliLab = new JLabel("   Sconfitte totali: $" + this.sconfitteTotali);
        this.denaroGuadagnatoLab = new JLabel("   Denaro guadagnato: $" + this.denaroGuadagnato);
        this.denaroPersoLab = new JLabel("   Denaro perso: $" + this.denaroPerso);
        this.vittoriaMiglioreLab = new JLabel("   Vincita migliore: $" + this.vittoriaMigliore);
        this.sconfittaMaggioreLab = new JLabel("   Perdita maggiore: $" + this.sconfittaMaggiore);

        this.vittorieTotaliLab.setFont(new Font("Time new roman", Font.BOLD, 30));
        this.sconfitteTotaliLab.setFont(new Font("Time new roman", Font.BOLD, 30));
        this.denaroGuadagnatoLab.setFont(new Font("Time new roman", Font.BOLD, 30));
        this.denaroPersoLab.setFont(new Font("Time new roman", Font.BOLD, 30));
        this.vittoriaMiglioreLab.setFont(new Font("Time new roman", Font.BOLD, 30));
        this.sconfittaMaggioreLab.setFont(new Font("Time new roman", Font.BOLD, 30));

        this.sconfitteTotaliLab.setForeground(Color.WHITE);
        this.vittorieTotaliLab.setForeground(Color.WHITE);
        this.denaroGuadagnatoLab.setForeground(Color.WHITE);
        this.denaroPersoLab.setForeground(Color.WHITE);
        this.vittoriaMiglioreLab.setForeground(Color.WHITE);
        this.sconfittaMaggioreLab.setForeground(Color.WHITE);

        this.add(vittorieTotaliLab);
        this.add(sconfitteTotaliLab);
        this.add(denaroGuadagnatoLab);
        this.add(denaroPersoLab);
        this.add(vittoriaMiglioreLab);
        this.add(sconfittaMaggioreLab);
    }

    public int getVittorieTotali() {
        return vittorieTotali;
    }
    public void setVittorieTotali(int vittorieTotali) {
        this.vittorieTotali = vittorieTotali;
        this.vittorieTotaliLab.setText("   Vittorie totali: $" + this.vittorieTotali);
    }

    public int getSconfitteTotali() {
        return sconfitteTotali;
    }
    public void setSconfitteTotali(int sconfitteTotali) {
        this.sconfitteTotali = sconfitteTotali;
        this.sconfitteTotaliLab.setText("   Sconfitte totali: $" + this.sconfitteTotali);
    }

    public int getDenaroGuadagnato() {
        return denaroGuadagnato;
    }
    public void setDenaroGuadagnato(int denaroGuadagnato) {
        this.denaroGuadagnato = denaroGuadagnato;
        this.denaroGuadagnatoLab.setText("   Denaro guadagnato: $" + this.denaroGuadagnato);
    }

    public int getDenaroPerso() {
        return denaroPerso;
    }
    public void setDenaroPerso(int denaroPerso) {
        this.denaroPerso = denaroPerso;
        this.denaroPersoLab.setText("   Denaro perso: $" + this.denaroPerso);
    }

    public int getVittoriaMigliore() {
        return vittoriaMigliore;
    }
    public void setVittoriaMigliore(int vittoriaMigliore) {
        this.vittoriaMigliore = vittoriaMigliore;
        this.vittoriaMiglioreLab.setText("   Vincita migliore: $" + this.vittoriaMigliore);
    }

    public int getSconfittaMaggiore() {
        return sconfittaMaggiore;
    }
    public void setSconfittaMaggiore(int sconfittaMaggiore) {
        this.sconfittaMaggiore = sconfittaMaggiore;
        this.sconfittaMaggioreLab.setText("   Perdita maggiore: $" + this.sconfittaMaggiore);
    }
}
