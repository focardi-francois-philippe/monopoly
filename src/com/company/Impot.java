package com.company;

public class Impot extends CaseNonProprietaire{
    public Impot(int numeroDeCase, String nom, int loyer) {
        super(numeroDeCase, nom, loyer);
    }



    @Override
    public void actionCase(Joueur joueur) {
        super.actionCase(joueur);
        System.out.println("Case impot -200");
        joueur.gestionArgent(loyer);
    }

}
