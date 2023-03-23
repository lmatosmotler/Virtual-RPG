/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * Classe de Création de Potion
 * @author ALVES DE ABREU João Pedro et MATOS MOLTER Lucas
 */
public abstract class Potion extends Objet {
   
/**
 * Constructeur de la classe Potion en passant tous les paramètres.
 * @param p Puissance
 * @param pos Position sur le monde
 */
    public Potion(int p, Point2D pos){
        super(p,pos);
    }
   
/**
 * Constructeur de la classe Potion en passant un objet.
 * @param p Objet de la classe Potion
 */
    public Potion (Potion p){
        super(p);
    }
 
/**
 * Constructeur de la classe Potion sans paramètres.
 * Initialisation des variables avec valeurs null
 */
    public Potion (){
        super();
    }
    
    public abstract void affiche();
    
}
