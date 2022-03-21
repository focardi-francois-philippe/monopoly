package com.company;

public class ControllerMonopoly {
    private Jeu jeu;

    public ControllerMonopoly(int nombreDeTour) {
        this.jeu = new Jeu(nombreDeTour);
    }
    public void addJoueur(String nom)
    {
        jeu.addJoueur(nom);
    }
    public void lancerJeu()
    {
        jeu.lancerJeu();
    }

    public Jeu getJ() {
        return jeu;
    }
}
