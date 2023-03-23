/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * Classe de Création de NourritureBonusDamAtt
 * @author ALVES DE ABREU João Pedro et MATOS MOLTER Lucas
 */
public class NourritureBonusDamAtt extends Nourriture {

/**
 * Constructeur de la classe NourritureBonusDamAtt
 * @param p Puissance de la nourriture
 * @param pos Position du objet
 */
    public NourritureBonusDamAtt(int p, Point2D pos) {
        super(p, pos); // Le '1' répresente qui est un bonus
    }

    @Override
    /**
     * Méthode pour réaliser l'éffect d'une norriture sur un Personnage
     * @param p Personnage dont le DegAtt sera changé
     */
    public void setChange(Personnage p) {
        p.setDegAtt(p.getDegAtt() + this.getPuissance());
        this.setTours(this.getTours() - 1);
        System.out.println("Vous avez gagné "+ this.getPuissance() +" points de dégâts d'attaque"
                + "\nIl vous reste "+ this.getTours()+ " unités de nourriture");
    }

    /**
     * Méthode pour ramasser une norriture
     * @param p Personnage qui va ramasser la norritue
     */
    @Override
    public void ramasser(Personnage p) {
        p.addNourriture(this);
        System.out.println("Vous avez pris une nourriture bonus! Elle va augmenter vos points de dégâts d'attaque!");
    }
    
     
    /**
     * Méthode pour renvoyer le texte avec les informations
     * du objet dans le bon format
     */
    public String getTexteSauvegarde() {
        return "NorritureBonusDamAtt "+this.getPuissance()+" "+this.getPos().getX()+" "+this.getPos().getY();
    }
   
}