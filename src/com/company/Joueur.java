package com.company;

import java.util.*;

/**
 * 
 */
public class Joueur {

    private int id;
    private String nom;
    private int nombreDeTour;
    private int position;
    private static Des hDes;
    private static int  nombreInstanceJoueur =1;
    private static final int NOMBREDECASE = 40;
    private int argent;
    private boolean estPrisonnier;

    public Joueur() {
        nombreDeTour = 1;
        position = 0;
        id = nombreInstanceJoueur;
        nombreInstanceJoueur++;
        argent = 1500;
        estPrisonnier = false;
    }

    public Joueur(String nom) {
        this();
        this.nom = nom;
    }
    public int lancerDes()
    {
        return Des.lancerDes();
    }

    public int getNombreDeTour() {
        return nombreDeTour;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        int positionActuel = position+this.position;
        if(positionActuel==30)
        {
            deviensPrisonnier();
        }
        else if(positionActuel<NOMBREDECASE)
        {
            this.position += position;
        }
        else
        {
            this.position = positionActuel - NOMBREDECASE;
            nombreDeTour+=1;
            gestionArgent(200);
        }
    }
    public void deviensPrisonnier()
    {
        this.position = 10;
        estPrisonnier = true;
    }

    public void setNombreDeTour(int nombreDeTour) {
        this.nombreDeTour = nombreDeTour;
    }

    public int getId() {
        return id;
    }

    public void gestionArgent(int argent) {
        this.argent += argent;
    }

    public boolean getEstPrisonnier() {
        return estPrisonnier;
    }

    public void setEstPrisonnier(boolean estPrisonnier) {
        this.estPrisonnier = estPrisonnier;
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", argent=" + argent +
                '}';
    }
}