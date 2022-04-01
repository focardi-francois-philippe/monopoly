package com.company;

import java.util.Scanner;

public abstract class CaseProprietaire extends Case{
    protected Joueur proprietaire;
    protected int prixDAchat;
    protected String cle;
    private static Scanner scanner = new Scanner(System.in);

    public CaseProprietaire(int numeroDeCase, String nom, int loyer, int prixDAchat, String cle) {
        super(numeroDeCase, nom, loyer);
        this.prixDAchat = prixDAchat;
        this.cle = cle;
        proprietaire = null;
    }


    public CaseProprietaire(int numeroDeCase, String nom, int loyer) {
        super(numeroDeCase, nom, loyer);
    }

    @Override
    public void actionCase(Joueur joueur) {
        int loyerAPayer = 0;
        System.out.print(joueur.getNom() + " Vous etes tombe sur "+this.getNom() + " Qui a pour cle "+this.cle + "Qui appartient a "+proprietaire.getNom());
        if(proprietaire!=null && !joueur.equals(proprietaire))//Si la case a un proprietaire et ce n'est pas lui passé en parametre joueur paye le loyer
        {
            loyerAPayer = calculLoyer(joueur,proprietaire);
            System.out.println(" qui appartient a "+proprietaire.getNom() + " vous payez"+loyerAPayer);
            Joueur.transactionLoyer(joueur,proprietaire,loyerAPayer);
        }
        else if(proprietaire==null)
        {
            if(joueur.getArgent()>this.prixDAchat)
            {
                System.out.println(" elle est libre au prix de "+this.prixDAchat + "vous disposez de "+joueur.getArgent()+" voulez vous l'acheter? tapez 1 pour l'acheter ");
                String s = scanner.nextLine();
                if(s.equals("1"))
                {
                    this.proprietaire = joueur;
                    joueur.acheter(this);
                }
            }
            else
                System.out.println("Vous ne disposez des fonds necessaires");
        }
        else
            System.out.println("Vous etes chez vous");

    }

    public abstract int calculLoyer(Joueur locataire,Joueur proprietaire);

    public String getCle() {
        return cle;
    }

    @Override
    public String toString() {
        return "CaseProprietaire{" +
                "joueur=" + joueur +
                ", proprietaire=" + proprietaire +
                ", prixDAchat=" + prixDAchat +
                ", cle='" + cle + '\'' +
                '}';
    }
}
