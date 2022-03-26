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

    private static int  nombreInstanceJoueur =1;
    private static final int NOMBREDECASE = 40;
    private int argent;
    private boolean estPrisonnier;
    private int lancer1;
    private int lancer2;
    HashMap<String,List<CaseProprietaire>> casesPossedes;

    public Joueur() {
        nombreDeTour = 1;
        position = 0;
        id = nombreInstanceJoueur;
        nombreInstanceJoueur++;
        argent = 1500;
        estPrisonnier = false;
        casesPossedes = new HashMap<>();
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

    public String getNom() {
        return nom;
    }

    public void setPosition(int position) {
        this.position = position;
    }
    public void deplacement(int position)
    {
        int positionDep = (position+this.position)%40;
        setPosition(positionDep);
    }

    public void deviensPrisonnier()
    {
        this.position = 10;
        estPrisonnier = true;
    }
    public static void transactionLoyer(Joueur locataire,Joueur proprietaire,int loyer)
    {
        locataire.gestionArgent(-loyer);
        proprietaire.gestionArgent(loyer);
    }
    public void acheter(CaseProprietaire caseProprietaire)
    {
        if(casesPossedes.containsKey(caseProprietaire.getCle()))
        {
            casesPossedes.get(caseProprietaire.getCle()).add(caseProprietaire);
        }
        else
        {
            casesPossedes.put(caseProprietaire.getCle(),new ArrayList<>());
            casesPossedes.get(caseProprietaire.getCle()).add(caseProprietaire);
        }


        gestionArgent(-caseProprietaire.prixDAchat);

    }
    public int sizeForKey(String s)
    {
        return casesPossedes.get(s).size();
    }


    public int getArgent() {
        return argent;
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

    public void setLancer1(int lancer1) {
        this.lancer1 = lancer1;
    }

    public void setLancer2(int lancer2) {
        this.lancer2 = lancer2;
    }

    public void lancerLesDes()
    {
        lancer1 = lancerDes();
        lancer2 = lancerDes();
        deplacement(lancer1+lancer2);
    }

    public int getLancer1() {
        return lancer1;
    }

    public int getLancer2() {
        return lancer2;
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", argent=" + argent +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Joueur joueur = (Joueur) o;

        return id == joueur.id;
    }
}