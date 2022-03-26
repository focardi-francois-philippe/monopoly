package com.company;

public abstract class CaseNonProprietaire extends Case{
    public CaseNonProprietaire(int numeroDeCase, String nom, int loyer) {
        super(numeroDeCase, nom, loyer);
    }

    @Override
    public void actionCase(Joueur joueur) {
        System.out.print(joueur.getNom() + "Vous etes tombé sur ");
    }
}
