package com.company;

import java.util.Scanner;

public class IhmMonopoly {
    private ControllerMonopoly controllerMonopoly;

    public void lancerPartie()
    {
        Scanner scanner = new Scanner(System.in);
        int nombreDeTour = 0;

        System.out.println("Saisir le Nom du joueur 1 ");
        String nomJoueur1 = scanner.nextLine();
        System.out.println("Saisir le  Nom du joueur 2 ");
        String nomJoueur2 = scanner.nextLine();
        System.out.println("Saisir le Nombre de tour a effectuer");
        nombreDeTour = scanner.nextInt();
        this.controllerMonopoly = new ControllerMonopoly(nombreDeTour);
        controllerMonopoly.addJoueur(nomJoueur1);
        controllerMonopoly.addJoueur(nomJoueur2);
        controllerMonopoly.lancerJeu();

        Jeu j = controllerMonopoly.getJ();
        Joueur[]joueurs = j.gethJoueur();
        for (Joueur joueur : joueurs) {
            System.out.println(joueur);
        }
        System.out.println("Le nombre de tour effectué est de " + j.getNombreDeTourEffectuer());
    }
}
