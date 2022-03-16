package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Jeu {

    private static final int NOMBRE_DE_JOUEUR_MAX = 2;
    private static final int NOMBRE_DE_CASES = 40 ;
    private static int nombreDeJoueur = 0;
    private static final String FILE_NAME = "src/config.csv";
    private Joueur[] hJoueur = new Joueur[NOMBRE_DE_JOUEUR_MAX];
    private Case[] hCase = new Case[NOMBRE_DE_CASES];
    private int nombreDeTourAEffectuer;
    private int nombreDeTourEffectuer;

    public Jeu() {
        try {
            initCase();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Jeu(int nombreDeTourAEffectuer) {
        this();
        this.nombreDeTourAEffectuer = nombreDeTourAEffectuer;
    }

    private void initCase() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(FILE_NAME));
        scanner.useDelimiter(";");
        int id = 0;
        String s = "";
        while (scanner.hasNext())
        {
            id = Integer.parseInt(scanner.next().replaceAll("\r\n",""));
            s = scanner.next();
            hCase[id] = new Case(id,s);
        }
        scanner.close();
    }
    public void addJoueur(String nom)
    {
        hJoueur[nombreDeJoueur] = new Joueur(nom);
        Jeu.nombreDeJoueur++;
    }
    public void lancerJeu()
    {
        int scoreLancer1;
        int scoreLancer2;
        int nombreDeDouble = 0;
        int[] nombreDeTourEffectuerParJoueur = new int[nombreDeJoueur];
        for (int i =0;i<nombreDeJoueur;i++) {
            nombreDeTourEffectuerParJoueur[i] = 1;
        }

        while (nombreDeTourEffectuer<=nombreDeTourAEffectuer)
        {
            for (Joueur joueur : hJoueur) {
                scoreLancer1 = joueur.lancerDes();
                scoreLancer2 = joueur.lancerDes();
                joueur.setPosition(scoreLancer1+scoreLancer2);
                while (scoreLancer1 == scoreLancer2)
                {
                    nombreDeDouble++;
                    scoreLancer1 = joueur.lancerDes();
                    scoreLancer2 = joueur.lancerDes();
                    if(nombreDeDouble != 3)
                    {
                        joueur.setPosition(scoreLancer1+scoreLancer2);
                    }
                    else
                        joueur.setPosition(10);//Case prison
                }
                nombreDeTourEffectuerParJoueur[joueur.getId()-1] = joueur.getNombreDeTour();
                nombreDeDouble = 0;
            }

            for (int i = 0;i<Jeu.nombreDeJoueur;i++) {
                if (nombreDeTourEffectuer < nombreDeTourEffectuerParJoueur[i])
                    nombreDeTourEffectuer = nombreDeTourEffectuerParJoueur[i];
            }
        }
    }

    public int getNombreDeTourEffectuer() {
        return nombreDeTourEffectuer;
    }
}