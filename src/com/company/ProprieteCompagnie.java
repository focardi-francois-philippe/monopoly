package com.company;

import java.util.Scanner;

public class ProprieteCompagnie extends CaseProprietaire{
    public ProprieteCompagnie(int numeroDeCase, String nom, int loyer, int prixDAchat, String cle) {
        super(numeroDeCase, nom, loyer, prixDAchat, cle);
    }

    @Override
    public void actionCase(Joueur joueur) {
        super.actionCase(joueur);
    }

    @Override
    public int calculLoyer(Joueur locataire, Joueur proprietaire) {
        int sommeDesLancer = locataire.getLancer1()+locataire.getLancer2();
        if(proprietaire.sizeForKey("compagnie")==2)
            return sommeDesLancer*10;
        else
            return sommeDesLancer*4;

    }


}
