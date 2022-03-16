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
        String nomCase = "";
        String type = "";
        int loyer = 0;
        while (scanner.hasNext())
        {
            id = Integer.parseInt(scanner.next().replaceAll("\r\n",""));
            nomCase = scanner.next();
            type = scanner.next();
            loyer = Integer.parseInt(scanner.next().replaceAll("\r\n",""));
            if(type.equals("Impot"))
            {
                hCase[id] = new Impot(id,nomCase,loyer);
            }
            else if(type.equals("Chance"))
            {
                hCase[id] = new Chance(id,nomCase,loyer);
            }
            else
            {
                hCase[id] = new CaseProprietaire(id,nomCase,loyer);
            }
            //
        }
        scanner.close();
    }
    public void addJoueur(String nom)
    {
        hJoueur[nombreDeJoueur] = new Joueur(nom);
        hCase[0].addJoueur(hJoueur[nombreDeJoueur]);
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
                if(!joueur.getEstPrisonnier())
                {
                    hCase[joueur.getPosition()].removeJoueur(joueur);
                    scoreLancer1 = joueur.lancerDes();
                    scoreLancer2 = joueur.lancerDes();
                    joueur.setPosition(scoreLancer1+scoreLancer2);
                    hCase[joueur.getPosition()].addJoueur(joueur);
                    while (scoreLancer1 == scoreLancer2)
                    {
                        hCase[joueur.getPosition()].removeJoueur(joueur);
                        nombreDeDouble++;
                        scoreLancer1 = joueur.lancerDes();
                        scoreLancer2 = joueur.lancerDes();
                        if(nombreDeDouble != 3)
                            joueur.setPosition(scoreLancer1+scoreLancer2);
                        else
                            joueur.deviensPrisonnier();//Case prison

                        hCase[joueur.getPosition()].addJoueur(joueur);
                    }
                }
                else
                {
                    joueur.setEstPrisonnier(false);
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

    public Joueur[] gethJoueur() {
        return hJoueur;
    }

    public int getNombreDeTourEffectuer() {
        return nombreDeTourEffectuer;
    }
}