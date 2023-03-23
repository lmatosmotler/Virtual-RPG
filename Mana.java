/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * Classe de Création de Mana
 * @author ALVES DE ABREU João Pedro et MATOS MOLTER Lucas
 */
public class Mana extends Potion {
    public Mana (int p, Point2D pos){
        super(p,pos);
    }
    
    public Mana (Mana m){
        super(m);
    }
    
    public Mana (){
        super();
    }
    
/**
 * Méthode pour augmenter des points de mana d'un Personnage qui est arrivé dans une case où il y a une potion
 */
    public void ramasser(Personnage p){
        p.setPtMana(p.getPtMana() + this.getPuissance());
        System.out.println("Le joueur a gagné "+this.getPuissance()+" points de mana!");
    }
    
    public void affiche(){
        System.out.println("La potion du type Mana est en (" + this.getPos().getX() + "," + this.getPos().getY() + ") et a "+this.getPuissance()+" points de puissance");
    }
    
    /**
     * Méthode pour renvoyer le texte avec les informations
     * du objet dans le bon format
     */
    public String getTexteSauvegarde() {
        return "Mana "+this.getPuissance()+" "+this.getPos().getX()+" "+this.getPos().getY();
    }
}