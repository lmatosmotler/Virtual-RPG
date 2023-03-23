/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Random;

/**
 * Classe de Création de Loup
 *
 * @author ALVES DE ABREU João Pedro et MATOS MOLTER Lucas
 */
public class Loup extends Monstre implements Combattant {

/**
 * Constructeur de la classe Loup en passant tous les paramètres.
 * @param pV   Points de Vie
 * @param pA    Pourcentage de Attaque
 * @param pP    Pourcentage de 
 * @param dA    Damage de Attaque
 * @param p   Position du objet
 * @param ptPar Points de parade
 */
    public Loup(int pV, int pA, int pP, int dA, Point2D p, int ptPar) {
        super(pV, pA, pP, dA, p, ptPar);
    }

/**
 * Constructeur de la classe Loup en passant un objet.
 * @param l Objet de la classe Loup
 */
    public Loup(Loup l) {
        super(l);
    }

/**
 * Constructeur de la classe Loup sans paramètres.
 * Initialisation des variables avec valeurs null
 */
    public Loup() {
        super();
        this.setPtVie(25);
    }

    /**
     * Méthode pour gérer les attaques
     * @param c la creature qui sera attaquée par le personnage
     */
    public void combattre(Creature c) {
        Random generateurAleatoire = new Random();
        if (this.getPos().distance(c.getPos()) == 1) {
            if (generateurAleatoire.nextInt(100) > this.getPourcentageAtt()) {
                System.out.println("Le loup n'a pas réussi à t'attaquer");
            } else {
                System.out.println("Le loup t'a attaqué");
                //aqui que eu não tenho certeza se o dano tem que entrar no ptVie mesmo, ou se tem alguma coisa a ver com aqueles dM que a gente não sabe o que é
                if (generateurAleatoire.nextInt(100) > c.getPourcentagePar()) {
                    System.out.println("No defense! Maximum dammage!!");
                    c.setPtVie(c.getPtVie() - this.getDegAtt());
                } else {
                    System.out.println("Defended! Dammage reduced!");
                    c.setPtVie(c.getPtVie() - this.getDegAtt() + c.getPtPar()); //então no slide ele fala que a defesa é esse ptPar, mas esse atributo não existe... podemos criar?
                }
            }
        } else {
            System.out.println("Le loup a essayé de t'attaquer mais il est très loin");
        }
    }
    
    @Override
    public void affiche() {
        System.out.println("Loup est dans la position (" + this.getPos().getX() + "," + this.getPos().getY() + ") et il a " + this.getPtVie() + " de Vie"); 
    }
    
    /**
     * Méthode pour renvoyer le texte avec les informations
     * du objet dans le bon format
     */
    @Override
    public String getTexteSauvegarde() {
        return "Loup "+this.getPtVie()+" "+this.getPourcentageAtt()+" "+this.getPourcentagePar()
                +" "+this.getDegAtt()+" "+this.getPos().getX()+" "+this.getPos().getY()+" "+this.getPtPar();
    }

}