/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Random;

/**
 * Classe de Création de Mage
 *
 * @author ALVES DE ABREU João Pedro et MATOS MOLTER Lucas
 */
public class Mage extends Personnage implements Combattant {

    /**
     * Constructeur de la classe Archer en passant tous les paramètres.
     *
     * @param nom nom du personnage
     * @param ptV Points de Vie
     * @param ptM Points de Magie
     * @param pA Pourcentage de Attaque
     * @param pP Pourcentage de Parade
     * @param pM Pourcentage de Magie
     * @param rM Pourcentage de Resistance de Magie
     * @param dA Damage de Attaque
     * @param dM Damage de Magie
     * @param distMax Distance de Attaque Max
     * @param pos Position du objet
     * @param ptPar Points de parade
     */
    public Mage(String nom, int ptV, int ptM, int pA, int pP, int pM, int rM, int dA, int dM, int distMax, Point2D pos, int ptPar) {
        super(nom, ptV, ptM, pA, pP, pM, rM, dA, dM, distMax, pos, ptPar);
    }

    /**
     * Constructeur de la classe Mage en passant un objet.
     *
     * @param m Objet de la classe Mage
     */
    public Mage(Mage m) {
        super(m);
    }

    /**
     * Constructeur de la classe Lapin sans paramètres. Initialisation des
     * variables avec valeurs null
     */
    public Mage() {
        super();
        Random generateurAleatoire = new Random();
        this.setDegMag(10-generateurAleatoire.nextInt(10));
        this.setDistAttMax(5-generateurAleatoire.nextInt(5));
        this.setPourcentageMag(100-generateurAleatoire.nextInt(50));
    }

    public void affiche() {
        System.out.println("Le Mage " + this.getNom() + " est dans la position (" + this.getPos().getX() + "," + this.getPos().getY() + ") et il a " + this.getPtVie() + " de Vie");
    }

    /**
     * Méthode pour gérer les attaques
     *
     * @param c la creature qui sera attaquée par le personnage
     */
    public void combattre(Creature c) {
        Random generateurAleatoire = new Random();
        if (this.getPos().distance(c.getPos()) > this.getDistAttMax() || this.getPos().distance(c.getPos()) < 1) {
            System.out.println("Vous n'êtes pas à la distance correcte!");
        } else {
            this.setPtMana(this.getPtMana() - 1);
            if (generateurAleatoire.nextInt(100) > this.getPourcentageMag()) {
                System.out.println("You Failed!");
            } else {
                if (c instanceof Guerrier || c instanceof Mage || c instanceof Archer || c instanceof Paysan) {
                    if (generateurAleatoire.nextInt(100) > ((Personnage) c).getPourcentageResistMag()) {
                        System.out.println("No defense! Maximum dammage!!");
                        c.setPtVie(c.getPtVie() - this.getDegMag());
                    } else {
                        if (this.getDegAtt() >= c.getPtPar()) {
                            System.out.println("Defended! Dammage reduced!");
                            c.setPtVie(c.getPtVie() - this.getDegMag() + c.getPtPar());
                        } else {
                            System.out.println("Fully defended! No dammage!");
                        }
                    }

                    System.out.println("Attack made!");
                    c.setPtVie(c.getPtVie() - this.getDegMag());
                    //mesma incerteza se é no pt de vie mesmo
                }
            }
        }
    }
    
    public void reCombattre(Creature c) {
        Random generateurAleatoire = new Random();
        if (this.getPos().distance(c.getPos()) > this.getDistAttMax() || this.getPos().distance(c.getPos()) < 1) {
            System.out.println("il n'est pas à la distance correcte");
        } else {
            this.setPtMana(this.getPtMana() - 1);
            if (generateurAleatoire.nextInt(100) > this.getPourcentageMag()) {
                System.out.println("Il n'a pas réussi à faire l'attaque");
            } else {
                if (c instanceof Guerrier || c instanceof Mage || c instanceof Archer || c instanceof Paysan) {
                    if (generateurAleatoire.nextInt(100) > ((Personnage) c).getPourcentageResistMag()) {
                        System.out.println("No defense! Maximum dammage!!");
                        c.setPtVie(c.getPtVie() - this.getDegMag());
                    } else {
                        if (this.getDegAtt() >= c.getPtPar()) {
                            System.out.println("Defended! Dammage reduced!");
                            c.setPtVie(c.getPtVie() - this.getDegMag() + c.getPtPar());
                        } else {
                            System.out.println("Fully defended! No dammage!");
                        }
                    }

                    System.out.println("Attack made!");
                    c.setPtVie(c.getPtVie() - this.getDegMag());
                    //mesma incerteza se é no pt de vie mesmo
                }
            }

        }
    }

    /**
     * Méthode pour renvoyer le texte avec les informations du objet dans le bon
     * format
     */
    @Override
    public String getTexteSauvegarde() {
        return "Mage " + this.getNom() + " " + this.getPtVie() + " " + this.getPtMana() + " " + this.getPourcentageAtt() + " " + this.getPourcentagePar()
                + " " + this.getPourcentageMag() + " " + this.getPourcentageResistMag() + " " + this.getDegAtt() + " "
                + this.getDegMag() + " " + this.getDistAttMax() + " " + this.getPos().getX() + " " + this.getPos().getY() + " " + this.getPtPar();
    }
}
