package com.company;

public class Chance extends CaseNonProprietaire{

    public Chance(int id, String nomCase, int loyer) {
        super(id, nomCase, loyer);
    }

    @Override
    public void addJoueur(Joueur joueur) {
        super.addJoueur(joueur);
        System.out.println("Carte chance +"+loyer);
        joueur.gestionArgent(loyer);
    }
}
