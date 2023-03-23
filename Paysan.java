/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * Classe de Création et Manipulation des objets Paysan
 * @author ALVES DE ABREU João Pedro et MATOS MOLTER Lucas
 */

public class Paysan extends Personnage {
    
/**
 * Constructeur de la classe Paysan en passant tous les paramètres.
 * @param nom   nom du personnage
 * @param ptV   Points de Vie
 * @param ptM Points de Magie
 * @param pA    Pourcentage de Attaque
 * @param pP    Pourcentage de 
 * @param pM    Pourcentage de Magie
 * @param rM    Pourcentage de Resistance de Magie
 * @param dA    Damage de Attaque
 * @param dM    Damage de Magie
 * @param distMax    Distance de Attaque Max
 * @param pos   Postion du objet
 */
    public Paysan(String nom, int ptV,int ptM, int pA, int pP, int pM, int rM, int dA, int dM, int distMax, Point2D pos, int ptPar){
        super(nom, ptV, ptM, pA, pP, pM, rM, dA, dM, distMax, pos, ptPar);
    }
    
/**
 * Constructeur de la classe Paysan en passant un objet.
 * @param p Objet de la classe Paysan
 */
    public Paysan(Paysan p){
        super(p);
    }
   
/**
 * Constructeur de la classe Paysan sans paramètres.
 * Initialisation des variables avec valeurs null
 */
    public Paysan(){
        super();
    }
    
    /*@Override
    public boolean deplace(int dx, int dy) {
        super.deplace(dx, dy);
    }*/

    @Override
    public void affiche() {
        System.out.println("Paysan est dans la position (" + this.getPos().getX() + "," + this.getPos().getY() + ") et il a " + this.getPtVie() + " de Vie");
    }

    /**
     * Méthode pour renvoyer le texte avec les informations
     * du objet dans le bon format
     */
    public String getTexteSauvegarde() {
        return "Paysan " + this.getNom() + " " + this.getPtVie() + " " + this.getPtMana() + " " + this.getPourcentageAtt() + " " + this.getPourcentagePar()
                + " " + this.getPourcentageMag() + " " + this.getPourcentageResistMag() + " " + this.getDegAtt() + " "
                + this.getDegMag() + " " + this.getDistAttMax() + " " + this.getPos().getX() + " " + this.getPos().getY() + " " + this.getPtPar();
    }
}