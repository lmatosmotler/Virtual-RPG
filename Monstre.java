/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * Classe de Création de Monstres
 * @author ALVES DE ABREU João Pedro et MATOS MOLTER Lucas
 */

public abstract class Monstre extends Creature {
           
/**
 * Constructeur de la classe Monstre en passant tous les paramètres.
 * @param ptV   Points de Vie
 * @param pA    Pourcentage de Attaque
 * @param pP    Pourcentage de Parade
 * @param dA    Damage de Attaque
 * @param pos   Postion du objet
 */
    public Monstre(int ptV, int pA, int pP, int dA, Point2D pos, int ptPar){
        super(ptV, pA, pP, dA, pos,ptPar);
    }
    
/**
 * Constructeur de la classe Monstre en passant un objet.
 * @param m Objet de la classe Monstre
 */
    public Monstre(Monstre m){
        super(m);
    }
    
/**
 * Constructeur de la classe Monstre sans paramètres.
 * Initialisation des variables avec valeurs null
 */
    public Monstre(){
        super();
    }
    
}