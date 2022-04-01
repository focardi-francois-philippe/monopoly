package com.company;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class JoueurTest {

    Joueur joueur = new Joueur("Francois");
    Joueur joueur2 = new Joueur("Pilou");
    @Test
    @RepeatedTest(1000)
    @DisplayName("Test des des compris entre 1 et 6")
    void lancerDes() {
        joueur.lancerDes();
        assertTrue(joueur.getLancer1() >=0 && joueur.getLancer1()<=6);
        assertTrue(joueur.getLancer2() >=0 && joueur.getLancer2()<=6);
    }


    @Test
    @RepeatedTest(1000)
    void transactionLoyer() {
        int locataireArgents = joueur.getArgent();
        int proprietaireArgents = joueur2.getArgent();
        int loyer = new Random().nextInt(100,200);
        Joueur.transactionLoyer(joueur,joueur2,loyer);

        assertEquals(locataireArgents-loyer,joueur.getArgent());
        assertEquals(proprietaireArgents+loyer,joueur2.getArgent());
        assertTrue(locataireArgents>joueur.getArgent());
        assertTrue(proprietaireArgents<joueur2.getArgent());
    }

    @Test
    void acheter() {
        int argentJoueur = joueur.getArgent();
        CaseProprietaire c1 = new ProprieteGare(15,"Test",100,120,"gare");
        CaseProprietaire c2 = new ProprieteGare(16,"Test2",100,120,"gare");
        CaseProprietaire c3 = new ProprieteMaison(17,"Test3",150,120,"Rouge");
        joueur.acheter(c1);
        assertEquals(argentJoueur-c1.prixDAchat,joueur.getArgent());
        assertTrue(joueur.casesPossedes.containsKey("gare"));
        joueur.acheter(c2);
        assertTrue(joueur.casesPossedes.get(c2.getCle()).size()==2);
        joueur.acheter(c3);
        assertTrue(joueur.casesPossedes.containsKey(c3.getCle()));

    }
}