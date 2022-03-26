package com.company;

public class AllerEnPrison extends CaseNonProprietaire{
    public AllerEnPrison(int numeroDeCase, String nom, int loyer) {
        super(numeroDeCase, nom, loyer);
    }

    @Override
    public void actionCase(Joueur joueur) {
        super.actionCase(joueur);
        System.out.println("Case Aller en prison vous ne jouez pas le prochain tour");
        joueur.deviensPrisonnier();

    }
}
