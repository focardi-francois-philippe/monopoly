package com.company;

import java.util.*;

/**
 * 
 */
public abstract class Case {

    private int id;
    private String nom;
    protected int loyer;
    protected ArrayList<Joueur> joueur;

    public Case() {
    }

    public Case(int numeroDeCase, String nom,int loyer) {
        this.id = numeroDeCase;
        this.nom = nom;
        this.loyer = loyer;
        joueur = new ArrayList<>();
    }

    public void addJoueur(Joueur joueur) {
        this.joueur.add(joueur);
    }
    public void removeJoueur(Joueur joueur)
    {
        this.joueur.remove(joueur);
    }
    public boolean listeVide()
    {
        return this.joueur.isEmpty();
    }

    public int getLoyer() {
        return loyer;
    }

    @Override
    public String toString() {
        return "Case{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", joueur=" + joueur +
                '}';
    }
}