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
        String cle = "";
        int loyer = 0;
        int prixDAchat = 0;
        while (scanner.hasNext())
        {
            id = Integer.parseInt(scanner.next().replaceAll("\r\n",""));
            nomCase = scanner.next();
            type = scanner.next();
            cle = scanner.next();
            prixDAchat = Integer.parseInt(scanner.next().replaceAll("\r\n",""));
            loyer = Integer.parseInt(scanner.next().replaceAll("\r\n",""));

            if(type.equals("Impot"))
            {
                hCase[id] = new Impot(id,nomCase,loyer);
            }
            else if(type.equals("Chance"))
            {
                hCase[id] = new Chance(id,nomCase,loyer);
            }
            else if(type.equals("AllerEnPrison"))
            {
                hCase[id] = new AllerEnPrison(id,nomCase,loyer);
            }
            else if(type.equals("Depart"))
            {
                hCase[id] = new Depart(id,nomCase,loyer);
            }
            else if(type.equals("ProprieteGare"))
            {
                hCase[id] = new ProprieteGare(id,nomCase,loyer,prixDAchat,cle);
            }
            else if(type.equals("ProprieteMaison"))
            {
                hCase[id] = new ProprieteMaison(id,nomCase,loyer,prixDAchat,cle);
            }
            else if(type.equals("ProprieteCompagnie"))
            {
                hCase[id] = new ProprieteCompagnie(id,nomCase,loyer,prixDAchat,cle);
            }
            else
            {
                hCase[id] = new NoAction(id,nomCase,loyer);
            }
            //
        }
        scanner.close();
    }
    public void addJoueur(String nom)
    {
        hJoueur[nombreDeJoueur] = new Joueur(nom);
        hCase[0].placerJoueur(hJoueur[nombreDeJoueur]);
        Jeu.nombreDeJoueur++;
    }
    public void lancerJeu()
    {
        int scoreLancer1;
        int scoreLancer2;
        int nombreDeDouble = 0;
        int positionPrecedente = 0;
        int[] nombreDeTourEffectuerParJoueur = new int[nombreDeJoueur];
        for (int i =0;i<nombreDeJoueur;i++) {
            nombreDeTourEffectuerParJoueur[i] = 1;
        }

        while (nombreDeTourEffectuer<=nombreDeTourAEffectuer)
        {
            for (Joueur joueur : hJoueur) {
                positionPrecedente = joueur.getPosition();
                if(!joueur.getEstPrisonnier())
                {
                    hCase[joueur.getPosition()].removeJoueur(joueur);
                    joueur.lancerLesDes();
                    if(joueur.getPosition()<positionPrecedente && joueur.getPosition() != 0 && joueur.getEstPrisonnier() == false)//pas 0 car sinon l'action est effectue juste avant
                        hCase[0].actionCase(joueur);
                    hCase[joueur.getPosition()].placerJoueur(joueur);
                    hCase[joueur.getPosition()].actionCase(joueur);

                    while (joueur.getLancer1() == joueur.getLancer2() && !joueur.getEstPrisonnier())
                    {
                        positionPrecedente = joueur.getPosition();
                        hCase[joueur.getPosition()].removeJoueur(joueur);
                        nombreDeDouble++;
                        if(joueur.getPosition()<positionPrecedente && joueur.getPosition() != 0 && joueur.getEstPrisonnier() == false)//pas 0 car sinon l'action est effectue juste avant
                            hCase[0].actionCase(joueur);
                        if(nombreDeDouble != 3)
                        {
                            joueur.lancerLesDes();
                            hCase[joueur.getPosition()].placerJoueur(joueur);
                            hCase[joueur.getPosition()].actionCase(joueur);

                        }
                        else
                            joueur.deviensPrisonnier();//Case prison
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