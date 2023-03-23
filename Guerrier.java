/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Random;
/**
 * Classe de Création de Guerrier
 *
 * @author ALVES DE ABREU João Pedro et MATOS MOLTER Lucas
 */
public class Guerrier extends Personnage implements Combattant {


    /**
     * Constructeur de la classe Guerrier en passant tous les paramètres.
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
     * @param pos Postion du objet
     */
    public Guerrier(String nom, int ptV, int ptM, int pA, int pP, int pM, int rM, int dA, int dM, int distMax, Point2D pos, int ptPar) {
        super(nom, ptV, ptM, pA, pP, pM, rM, dA, dM, distMax, pos, ptPar);
    }

    /**
     * Constructeur de la classe Guerrier en passant un objet.
     * @param g Objet de la classe Guerrier
     */
    public Guerrier(Guerrier g) {
        super(g);
    }

    /**
     * Constructeur de la classe Guerrier sans paramètres. Initialisation des
     * variables avec valeurs null
     */
    public Guerrier() {
        super();
    }

    public void affiche() {
        System.out.println("Le Guerrier " + this.getNom() + " est dans la position (" + this.getPos().getX() + "," + this.getPos().getY() + ") et il a " + this.getPtVie() + " de Vie");
    }
    /**
     * Méthode pour gérer les attaques
     * @param c la creature qui sera attaquée par le personnage
     */
    public void combattre(Creature c) {
        Random generateurAleatoire = new Random();
        if (this.getPos().distance(c.getPos()) == 1) {
            if (generateurAleatoire.nextInt(100) > this.getPourcentageAtt()) {
                System.out.println("You Failed!");
            } else {
                System.out.println("Attack made!");
                //aqui que eu não tenho certeza se o dano tem que entrar no ptVie mesmo, ou se tem alguma coisa a ver com aqueles dM que a gente não sabe o que é
                if (generateurAleatoire.nextInt(100) > c.getPourcentagePar()) {
                    System.out.println("No defense! Maximum dammage!!");
                    c.setPtVie(c.getPtVie() - this.getDegAtt());
                } else {
                    
                    if(this.getDegAtt()>=c.getPtPar()){
                        System.out.println("Defended! Dammage reduced!");
                        c.setPtVie(c.getPtVie() - this.getDegAtt() + c.getPtPar());
                    } else {
                        System.out.println("Fully defended! No dammage!");
                    } 
                }
            }
        } else {
            System.out.println("Vous êtes encore très loin! La distance doit être plus petite que 1!");
        }
    }
    
    public void reCombattre(Creature c) {
        Random generateurAleatoire = new Random();
        if (this.getPos().distance(c.getPos()) == 1) {
            if (generateurAleatoire.nextInt(100) > this.getPourcentageAtt()) {
                System.out.println("Le Guerrier "+this.getNom()+" n'a pas réussi a t'attaquer");
            } else {
                System.out.println("Le Guerrier "+this.getNom()+" t'a attaque");
                //aqui que eu não tenho certeza se o dano tem que entrar no ptVie mesmo, ou se tem alguma coisa a ver com aqueles dM que a gente não sabe o que é
                if (generateurAleatoire.nextInt(100) > c.getPourcentagePar()) {
                    System.out.println("No defense! Maximum dammage!!");
                    c.setPtVie(c.getPtVie() - this.getDegAtt());
                } else {
                    
                    if(this.getDegAtt()>=c.getPtPar()){
                        System.out.println("Defended! Dammage reduced!");
                        c.setPtVie(c.getPtVie() - this.getDegAtt() + c.getPtPar());
                    } else {
                        System.out.println("Fully defended! No dammage!");
                    } 
                }
            }
        } else {
            System.out.println("Il est encore très loin");
        }
    }
    
    /**
     * Méthode pour renvoyer le texte avec les informations
     * du objet dans le bon format
     */
    public String getTexteSauvegarde() {
        return "Guerrier "+this.getNom()+" "+this.getPtVie()+" "+this.getPtMana()+" "+this.getPourcentageAtt()+" "+this.getPourcentagePar()
                +" "+this.getPourcentageMag()+" "+this.getPourcentageResistMag()+" "+this.getDegAtt()+" "+
                this.getDegMag()+" "+this.getDistAttMax()+" "+this.getPos().getX()+" "+this.getPos().getY()+" "+this.getPtPar();
    }
}