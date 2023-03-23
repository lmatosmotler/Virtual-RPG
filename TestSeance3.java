/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.io.File;
import java.util.Scanner;

/**
 * @author ALVES DE ABREU João Pedro et MATOS MOLTER Lucas
 */
public class TestSeance3 {

    public static void main(String[] args) {
        boolean continuer = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tapez N pour commencer une nouvelle partie ou tapez C pour charger une partie anciene");
        String choix = scanner.next();
        while (!choix.equals("N") && !choix.equals("C")) {
            System.out.println("Tapez N pour commencer une nouvelle partie ou tapez C pour charger une partie anciene");
            choix = scanner.next();
        }

        if (choix.equals("N")) {
            World w1 = new World();
            w1.j = new Joueur();
            w1.creeMondeAlea(15);
            System.out.println("--- Bienvenue au World of ECN ---");
            
            w1.afficheMondeEspecial();
            

            System.out.println("Aussi, pour deplacer le personnage, vous devez considerer que vous êtes à la posição de la clé S du clavier");
            System.out.println("Donc, si vous voulez se deplacer, il faut suivre les lettres a-z-e-a-d-w-x-c");
            System.out.println("De plus, on remarque que dans l'affichage du monde, si la valeur de la case est 0 la case esti vide, si est 1 il y a une créature (Lapin, Loup, Mage, Archer ou Guerrier)");
            System.out.println("si la valeur est 2 il y a une objeta (soin, mana, norriture bonus, norriture malus ou nuage toxique)");
            System.out.println("Et la case avec le 5 est la case où est ton personnage");
            w1.afficheMondeMatrice();
            
            System.out.println("Le but du jeu est tuer toutes les créatures");
            //w1.afficheMondeElementsJeu();
            boolean jeitinho = true;
            while (continuer) {
                if (jeitinho) {
                    continuer = w1.tourDeJeu(w1.j);
                    jeitinho = false;
                } else {
                    w1.afficheMondeMatrice();
                    //  System.out.println(w1.j.getPersonnage().getClass().getName());
                    continuer = w1.tourDeJeu(w1.j);
                }
            }
        } else {
            System.out.println("Inserez le nom du ficher sauvegardé :");
            String fileName = scanner.next();
            File tempFile = new File(".\\" + fileName + ".txt");
            boolean exists = tempFile.exists();
            while (!exists) {
                System.out.println("File doesn't exist, please chose another name: ");
                fileName = scanner.next();
                File tempFile2 = new File(".\\" + fileName + ".txt");
                exists = tempFile2.exists();
            }
            ChargementPartie cp = new ChargementPartie(fileName);
            World w2 = cp.chargerPartie();
            System.out.println("--- (Re)Bienvenue au World of ECN ---");
            w2.afficheMondeEspecial();
            w2.afficheMondeMatrice();
            System.out.println("Aussi, pour deplacer le personnage, vous devez considerer que vous êtes à la posição de la clé S du clavier");
            System.out.println("Donc, si vous voulez se deplacer, il faut suivre les lettres a-z-e-a-d-w-x-c");
            System.out.println("De plus, on remarque que dans l'affichage du monde, si la valeur de la case est 0 la case esti vide, si est 1 il y a une créature (Lapin, Loup, Mage, Archer ou Guerrier)");
            System.out.println("si la valeur est 2 il y a une objeta (soin, mana, norriture bonus, norriture malus ou nuage toxique)");
            System.out.println("Et la case avec le 5 est la case où est ton personnage");
            
            while (continuer) {
                w2.afficheMondeMatrice();
                // System.out.println(w2.j.getPersonnage().getClass().getName());
                continuer = w2.tourDeJeu(w2.j);
            }

        }

        System.out.println("--- FIN DE JEU ---");
    }
}
