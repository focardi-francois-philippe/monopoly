package com.company;

public class ProprieteMaison extends CaseProprietaire{


    public ProprieteMaison(int numeroDeCase, String nom, int loyer, int prixDAchat, String cle) {
        super(numeroDeCase, nom, loyer, prixDAchat, cle);
    }
    @Override
    public void actionCase(Joueur joueur) {
        super.actionCase(joueur);
    }

    @Override
    public int calculLoyer(Joueur locataire, Joueur proprietaire) {
        return loyer;
    }
}
