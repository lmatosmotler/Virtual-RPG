/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;
import java.util.ArrayList;
import java.util.Random;

/**
 * Classe de création de personnages
 * @author ALVES DE ABREU João Pedro et MATOS MOLTER Lucas
 */

public abstract class Personnage extends Creature {
  
    private String nom;
    private int ptMana, pourcentageMag, pourcentageResistMag, degMag, distAttMax;
    private ArrayList<Nourriture> nourr;
    private static int nbPerso;
/**
 * Constructeur de la classe Personnage en passant tous les paramètres.
 * @param nom   nom du personnage
 * @param ptV   Points de Vie
 * @param ptM   Points de Mana 
 * @param pA    Pourcentage de Attaque
 * @param pP    Pourcentage de 
 * @param pM    Pourcentage de Magie
 * @param rM    Pourcentage de Resistance de Magie
 * @param dA    Damage de Attaque
 * @param dM    Damage de Magie
 * @param distMax    Distance de Attaque Max
 * @param pos   Postion du objet
 * @param ptPar points de parade en tant que défenseur
 */
    public Personnage(String nom, int ptV, int ptM, int pA, int pP, int pM, int rM, int dA, int dM, int distMax, Point2D pos, int ptPar){
        super(ptV, pA, pP, dA, pos, ptPar);
        this.nom = nom;
        this.ptMana = ptM;
        this.pourcentageMag = pM;
        this.pourcentageResistMag = rM;
        this.degMag = dM;
        this.distAttMax = distMax;
        nourr = new ArrayList<>();
    }
    
/**
 * Constructeur de la classe Personnage en passant un objet.
 * @param p Objet de la classe Personnage
 */
    public Personnage(Personnage p){
        super(p);
        this.nom = p.nom;
        this.ptMana = p.ptMana;
        this.pourcentageMag = p.pourcentageMag;
        this.pourcentageResistMag = p.pourcentageResistMag;
        this.degMag = p.degMag;
        this.distAttMax = p.distAttMax;
    }
    
/**
 * Constructeur de la classe Personnage sans paramètres.
 * Initialisation des variables avec valeurs null
 */
    public Personnage(){
        super();
        Random generateurAleatoire = new Random();
        this.nom = "Perso"+(nbPerso++);
        this.ptMana = 0;
        this.pourcentageMag = 0;
        this.pourcentageResistMag = generateurAleatoire.nextInt(100);
        this.degMag = 0;
        this.distAttMax = 1;
    }
    
    public void setNom(String value){
        this.nom = value;
    }
    
    public String getNom(){
        return this.nom;
    }
    
    public void setPtMana(int value){
        this.ptMana = value;
    }
    
    public int getPtMana(){
        return this.ptMana;
    }
    
    public void setPourcentageMag(int value){
        this.pourcentageMag = value;
    }
    
    public int getPourcentageMag(){
        return this.pourcentageMag;
    }
    
    public void setPourcentageResistMag(int value){
        this.pourcentageResistMag = value;
    }
    
    public int getPourcentageResistMag(){
        return this.pourcentageResistMag;
    }
    
    public void setDegMag(int value){
        this.degMag = value;
    }
    
    public int getDegMag(){
        return this.degMag;
    }
    
    public void setDistAttMax(int value){
        this.distAttMax = value;
    }
    
    public int getDistAttMax(){
        return this.distAttMax;
    }
    
    /**
     * Méthode pour ajouter une nourriture dans la liste
     * @param  n Nourriture
     */
    public void addNourriture(Nourriture n){
        nourr.add(n);
    }
    
    
    public ArrayList<Nourriture> getNourr(){
        return this.nourr;
    }

    
    /**
     * Méthode pour enlever une nourriture dans la liste quand l'attribut tours soit égal à 0
     */
    public void removeNourriture(){
        int i;
        for(i=0;i<nourr.size();i++){
            if(nourr.get(i).getTours() == 0){
                nourr.remove(i);
            }
        }
    }

    
}