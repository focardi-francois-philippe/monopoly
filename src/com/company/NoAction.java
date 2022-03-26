package com.company;

public class NoAction extends CaseNonProprietaire{
    public NoAction(int numeroDeCase, String nom, int loyer) {
        super(numeroDeCase, nom, loyer);
    }

    @Override
    public void actionCase(Joueur joueur) {
        super.actionCase(joueur);
        System.out.println("Case NO action rien ne se passe");
    }
}
