package com.company;

public class Impot extends CaseNonProprietaire{
    public Impot(int numeroDeCase, String nom, int loyer) {
        super(numeroDeCase, nom, loyer);
    }

    @Override
    public void addJoueur(Joueur joueur) {
        super.addJoueur(joueur);
        System.out.println("Case impot "+loyer);
        joueur.gestionArgent(loyer);
    }
}
