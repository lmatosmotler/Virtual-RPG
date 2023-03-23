/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * Classe de Création de Objet
 * @author ALVES DE ABREU João Pedro et MATOS MOLTER Lucas
 */
public abstract class Objet extends ElementDeJeu {
    
    private int puissance;
    
/**
 * Constructeur de la classe Objet en passant tous les paramètres.
 * @param p Puissance
 * @param pos Position sur le monde
 */
    public Objet(int p, Point2D pos){
        super(pos);
        this.puissance = p;
    }
 
/**
 * Constructeur de la classe Objet en passant un objet.
 * @param o Objet de la classe Objet
 */
    public Objet(Objet o){
        super(new Point2D(o.getPos()));
        this.puissance = o.puissance;
    }
   
/**
 * Constructeur de la classe Objet sans paramètres.
 * Initialisation des variables avec valeurs null
 */
    public Objet(){
        super(new Point2D());
        this.puissance = 0;
    }    
    
    public void setPuissance(int value){
        this.puissance = value;
    }
    
    public int getPuissance(){
        return this.puissance;
    }
    
    public void affiche() {
        System.out.println("L'objet est en (" + this.getPos().getX() + "," + this.getPos().getY() + ") et a "+this.getPuissance()+" points de puissance");
    }
    
    public abstract void ramasser(Personnage p);

     
}