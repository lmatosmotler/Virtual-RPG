/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * Classe de Création de Soin
 * @author ALVES DE ABREU João Pedro et MATOS MOLTER Lucas
 */
public class Soin extends Potion {
/**
 * Constructeur de la classe Soin en passant tous les paramètres.
 * @param p Puissance
 * @param pos Position sur le monde
 */
    public Soin (int p, Point2D pos){
        super(p,pos);
    }
    
/**
 * Constructeur de la classe Soin en passant un objet.
 * @param s Objet de la classe Soin
 */
    public Soin (Soin s){
        super(s);
    }
   
/**
 * Constructeur de la classe Soin sans paramètres.
 * Initialisation des variables avec valeurs null
 */
    public Soin (){
        super();
    }
   
/**
 * Méthode pour augmenter des points de vie d'un personnage
 * @param c Creature
 */
    public void ramasser(Personnage p){
        p.setPtVie(p.getPtVie()+ this.getPuissance());
        System.out.println("Le joueur a gagné "+this.getPuissance()+" points de vie!");
    }
    
    public void affiche(){
        System.out.println("La potion du type Soin est en (" + this.getPos().getX() + "," + this.getPos().getY() + ") et a "+this.getPuissance()+" points de puissance");
    }
    
    /**
     * Méthode pour renvoyer le texte avec les informations
     * du objet dans le bon format
     */
    public String getTexteSauvegarde() {
        return "Soin "+this.getPuissance()+" "+this.getPos().getX()+" "+this.getPos().getY();
    }

}