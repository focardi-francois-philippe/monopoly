package com.company;

public class Chance extends CaseNonProprietaire{

    public Chance(int id, String nomCase, int loyer) {
        super(id, nomCase, loyer);
    }

    @Override
    public void placerJoueur(Joueur joueur) {
        super.placerJoueur(joueur);
        System.out.println("Carte chance +"+loyer);

    }

    public void actionCase(Joueur joueur) {
        super.actionCase(joueur);
        System.out.println("Case Chance +100");
        joueur.gestionArgent(loyer);
    }
}
