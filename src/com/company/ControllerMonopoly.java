package com.company;

public class ControllerMonopoly {
    private Jeu j;

    public ControllerMonopoly(int nombreDeTour) {
        this.j = new Jeu(nombreDeTour);
    }
    public void addJoueur(String nom)
    {
        j.addJoueur(nom);
    }
    public void lancerJeu()
    {
        j.lancerJeu();
    }

    public Jeu getJ() {
        return j;
    }
}
