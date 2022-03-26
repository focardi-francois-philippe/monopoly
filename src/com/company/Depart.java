package com.company;

public class Depart extends CaseNonProprietaire{
    public Depart(int numeroDeCase, String nom, int loyer) {
        super(numeroDeCase, nom, loyer);
    }

    @Override
    public void actionCase(Joueur joueur) {
        super.actionCase(joueur);
        System.out.println("Vous etes passer par la case depart+200");
        joueur.gestionArgent(loyer);
        joueur.setNombreDeTour(joueur.getNombreDeTour()+1);
        joueur.proprietesListToString();
    }
}
