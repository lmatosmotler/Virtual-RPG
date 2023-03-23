/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Random;

/**
 * Classe de Création et Manipulation des objets archer
 *
 * @author ALVES DE ABREU João Pedro et MATOS MOLTER Lucas
 */
public class Archer extends Personnage implements Combattant {

    private int nbFleches;

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
     * @param pos Postion du objet
     * @param nbF Nombre de flèches
     * @param ptPar Point de Parade
     */
    public Archer(String nom, int ptV,int ptM, int pA, int pP, int pM, int rM, int dA, int dM, int distMax, Point2D pos, int nbF, int ptPar) {
        super(nom, ptV, ptM, pA, pP, pM, rM, dA, dM, distMax, pos, ptPar);
        this.nbFleches = nbF;
    }

    /**
     * Constructeur de la classe Archer en passant un objet.
     * @param a Objet de la classe Archer
     */
    public Archer(Archer a) {
        super(a);
        this.nbFleches = a.nbFleches;
    }

    /**
     * Constructeur de la classe Archer sans paramètres. Initialisation des
     * variables avec valeurs null
     */
    public Archer() {
        super();
        Random generateurAleatoire = new Random();
        this.setDistAttMax(5-generateurAleatoire.nextInt(5));
        this.nbFleches = 0;
    }

    public int getNbFleches() {
        return this.nbFleches;
    }

    public void setNbFleches(int value) {
        this.nbFleches = value;
    }

    /**
     * Méthode pour afficher le nom de l'archer,sa position et le nombre des
     * flèches
     */
    public void affiche() {
        System.out.println("Archer " + this.getNom() + " est dans la position (" + this.getPos().getX() + "," + this.getPos().getY() + ") et il a " + this.getPtVie() + " de Vie");
    }

    /**
     * Méthode pour gérer les attaques
     * @param c la creature qui sera attaquée par le personnage
     */
    public void combattre(Creature c) {
        Random generateurAleatoire = new Random();
        if (1 > this.getPos().distance(c.getPos()) || this.getPos().distance(c.getPos()) > this.getDistAttMax()) {//acho que tá errado também... distMax tem que estar em Criatura, não em personagem senão não dá para fazer...
            System.out.println("Vous n'êtes pas à la distance correcte!");
        } else {
            this.nbFleches--;
            if (generateurAleatoire.nextInt(100) > this.getPourcentageAtt()) {
                System.out.println("You Failed!");
            } else {
                System.out.println("Attack made!");
                c.setPtVie((c.getPtVie() - this.getDegAtt()));
            }
        }
    }
    
    public void reCombattre(Creature c) {
        Random generateurAleatoire = new Random();
        if (1 > this.getPos().distance(c.getPos()) || this.getPos().distance(c.getPos()) > this.getDistAttMax()) {//acho que tá errado também... distMax tem que estar em Criatura, não em personagem senão não dá para fazer...
            System.out.println("Il n'est pas à la distance correcte");
        } else {
            this.nbFleches--;
            if (generateurAleatoire.nextInt(100) > this.getPourcentageAtt()) {
                System.out.println("Il n'a pas réussi");
            } else {
                System.out.println("Attack made!");
                c.setPtVie((c.getPtVie() - this.getDegAtt()));
            }
        }
    }

    /**
     * Méthode pour renvoyer le texte avec les informations
     * du objet dans le bon format
     */
    @Override
    public String getTexteSauvegarde() {
        return "Archer "+this.getNom()+" "+this.getPtVie()+" "+this.getPtMana()+" "+this.getPourcentageAtt()+" "+this.getPourcentagePar()
                +" "+this.getPourcentageMag()+" "+this.getPourcentageResistMag()+" "+this.getDegAtt()+" "+
                this.getDegMag()+" "+this.getDistAttMax()+" "+this.getPos().getX()+" "+this.getPos().getY()+" "+this.getPtPar()+" "+this.getNbFleches();
    }



}
