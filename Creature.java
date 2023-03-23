/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Random;


/**
 * Classe de Création de Creature
 * @author ALVES DE ABREU João Pedro et MATOS MOLTER Lucas
 */
public abstract class Creature extends ElementDeJeu implements Deplacable {
    
    private int ptVie, pourcentageAtt, pourcentagePar, degAtt,ptPar;
    
/**
 * Constructeur de la classe Creature en passant tous les paramètres.
 * @param ptV   Points de Vie
 * @param pA    Pourcentage de Attaque
 * @param pP    Pourcentage de Parade
 * @param dA    Damage de Attaque
 * @param pos   Postion du objet
 * @param ptPar Points de parade
 */
    public Creature(int ptV, int pA, int pP, int dA, Point2D pos, int ptPar){
        super(pos);
        this.ptVie = ptV;
        this.pourcentageAtt = pA;
        this.pourcentagePar = pP;
        this.degAtt = dA;
        this.ptPar = ptPar;
    }
    
/**
 * Constructeur de la classe Creature en passant un objet.
 * @param c Objet de la classe Creature
 */
    public Creature(Creature c){
        super(new Point2D(c.getPos()));
        this.ptVie = c.ptVie;
        this.pourcentageAtt = c.pourcentageAtt;
        this.pourcentagePar = c.pourcentagePar;
        this.degAtt = c.degAtt; 
        this.ptPar = c.ptPar;
    }
   
/**
 * Constructeur de la classe Creature sans paramètres.
 * Initialisation des variables avec valeurs null
 */
    public Creature(){
        super(new Point2D());
        Random generateurAleatoire = new Random();
        this.ptVie = 100;
        this.pourcentageAtt = 100-generateurAleatoire.nextInt(70);
        this.pourcentagePar = 100-generateurAleatoire.nextInt(90);
        this.degAtt = 10-generateurAleatoire.nextInt(9);
        this.ptPar = 5-generateurAleatoire.nextInt(5);
    }
    
    public void setPtVie(int value){
        this.ptVie = value;
    }
    
    public int getPtVie(){
        return this.ptVie;
    }
    
    public void setPourcentageAtt(int value){
        this.pourcentageAtt = value;
    }
    
    public int getPourcentageAtt(){
        return this.pourcentageAtt;
    }
    
    public void setPourcentagePar(int value){
        this.pourcentagePar = value;
    }
    
    public int getPourcentagePar(){
        return this.pourcentagePar;
    }
    
    public void setDegAtt(int value){
        this.degAtt = value;
    }
    
    public int getDegAtt(){
        return this.degAtt;
    }

    public void setPtPar(int value){
        this.ptPar = value;
    }
    
    public int getPtPar(){
        return this.ptPar;
    }
    
    
    
/**
 * Deplace les creatures
 * @param dx Deplacement en x
 * @param dy Deplacement en y
 * @return  
 */
    @Override
    public boolean deplace(int dx, int dy){
        if((dx >= -1) && (dx <= 1) && (dy >= -1) && (dy <= 1)){
            this.getPos().translate(dx, dy);

            return true;
        } 
        else{
            return false;
        }
    }
    
    public abstract void affiche();
  
}