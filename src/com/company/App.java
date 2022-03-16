package com.company;

import java.util.*;

/**
 * 
 */
public class App {

    /**
     * Default constructor
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nombreDeTour = 0;

        System.out.println("Saisir le Nom du joueur 1 ");
        String nomJoueur1 = scanner.nextLine();
        System.out.println("Saisir le  Nom du joueur 2 ");
        String nomJoueur2 = scanner.nextLine();
        System.out.println("Saisir le Nombre de tour a effectuer");
        nombreDeTour = scanner.nextInt();
        Jeu j = new Jeu(nombreDeTour);
        j.addJoueur(nomJoueur1);
        j.addJoueur(nomJoueur2);
        j.lancerJeu();
        System.out.println("Le nombre de tour effectué est de " + j.getNombreDeTourEffectuer());
    }



}