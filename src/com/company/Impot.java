package com.company;

public class Impot extends CaseNonProprietaire{
    public Impot(int numeroDeCase, String nom, int loyer) {
        super(numeroDeCase, nom, loyer);
    }

    @Override
    public void placerJoueur(Joueur joueur) {
        super.placerJoueur(joueur);
        System.out.println("Case impot "+loyer);
        actionCase(joueur);
    }

    @Override
    public void actionCase(Joueur joueur) {
        super.actionCase(joueur);
        System.out.println("Case impot -200");
        joueur.gestionArgent(loyer);
    }

}
