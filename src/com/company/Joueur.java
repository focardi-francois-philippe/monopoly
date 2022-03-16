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

    public Joueur() {
        nombreDeTour = 1;
        position = 0;
        id = nombreInstanceJoueur;
        nombreInstanceJoueur++;
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

    public void setPosition(int position) {
        if(position+this.position<NOMBREDECASE)
        {
            this.position += position;
        }
        else
        {
            this.position = this.position+position - NOMBREDECASE;
            nombreDeTour+=1;
        }
        System.out.println(nom + "  " + this.position);
    }

    public void setNombreDeTour(int nombreDeTour) {
        this.nombreDeTour = nombreDeTour;
    }

    public int getId() {
        return id;
    }
}