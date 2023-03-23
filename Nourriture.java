/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Random;
import java.util.ArrayList;
/**
 * Classe de Création de Nourriture
 * @author ALVES DE ABREU João Pedro et MATOS MOLTER Lucas
 */
public abstract class Nourriture extends Objet {
    
    
    private int tours;
    Random generateurAleatoire = new Random();
    private ArrayList<String> att;
    
/**
 * Constructeur de la classe Nourriture
 * @param p Puissance de la nourriture
 * @param pos Position du objet
 * L'attribut tours est généré aléatoirement. Il fournit la quantité de tour de jeu qui la nourriture va exister
 */
    public Nourriture(int p, Point2D pos){
        super(p, pos);
        this.tours = generateurAleatoire.nextInt(5); //
    }
    
    /**
     * Méthode pour changer le nombre de tours d'une norriture
     * @param value nouvelle valeur de tours
     */
    public void setTours(int value){
        this.tours = value;
    }
    /**
     * Méthode pour avoir accéss à la quantité de tours
     */
    public int getTours(){
        return this.tours;
    }
   
    /**
     * Méthode abstract à être defini dans les sous-classes
     * @param p
     */
    public abstract void setChange(Personnage p);
    
    /**
     *
     * @return 
     */
    @Override
    public abstract String getTexteSauvegarde();
}
