/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * Classe de Création de NourritureMalusDamAtt
 * @author ALVES DE ABREU João Pedro et MATOS MOLTER Lucas
 */
public class NourritureMalusDamAtt extends Nourriture {
    
/**
 * Constructeur de la classe NourritureMalusDamAtt
 * @param p Puissance de la nourriture
 * @param pos Position du objet
 */
    public NourritureMalusDamAtt(int p, Point2D pos) {
        super(p, pos); // Le '0' répresente qui est un malus
    }

    /**
     * Méthode pour réaliser l'éffect d'une norriture sur un Personnage
     * @param p Personnage dont le DegAtt sera changé
     */
    @Override
    public void setChange(Personnage p) {
        p.setDegAtt(p.getDegAtt() - this.getPuissance());
        this.setTours(this.getTours() - 1);
        System.out.println("Vous avez perdu "+ this.getPuissance() +" points de dégâts d'attaque"
                + "\nIl vous reste "+ this.getTours()+ " unités de nourriture");
    }

    /**
     * Méthode pour ramasser une norriture
     * @param p Personnage qui va ramasser la norritue
     */
    @Override
    public void ramasser(Personnage p) {
        p.addNourriture(this);
        System.out.println("Vous avez pris une nourriture malus! Elle va diminuer vos points de dégâts d'attaque!");
    }
    
    /**
     * Méthode pour renvoyer le texte avec les informations
     * du objet dans le bon format
     */
    public String getTexteSauvegarde() {
        return "NorritureMalusDamAtt "+this.getPuissance()+" "+this.getPos().getX()+" "+this.getPos().getY();
    }
    
}