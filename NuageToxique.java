/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * Classe de Création de NuageToxique
 * @author ALVES DE ABREU João Pedro et MATOS MOLTER Lucas
 */
public class NuageToxique extends Objet implements Deplacable, Combattant {
    
    private int pAtt;
    private int pPar; //pourcentage de parade
    private int degAtt;
    private int ptPar; //point de parade
    
 
    public NuageToxique(){
        super();
        this.degAtt =0;
        this.pAtt =0;
        this.pPar=0;
        this.ptPar=0;
    }
    
    public NuageToxique(NuageToxique n){
        super(n);
        this.degAtt = n.degAtt;
        this.pAtt = n.pAtt;
        this.pPar = n.pPar;
        this.ptPar = n.ptPar;
    }

/**
 * Constructeur de la classe NuageToxique
 * @param pAtt Pourcentage Attaque
 * @param pPar Pourcentage parade
 * @param degA Degats attaque
 * @param ptPar Points de Parade
 * @param pos Position du objet
 */       
    public NuageToxique(int pAtt, int pPar, int degA, int ptPar, Point2D pos){
        super(0,pos);
        this.degAtt = degA;
        this.pAtt = pAtt;
        this.pPar = pPar;
        this.ptPar = ptPar;
    }
    

    /**
     * Méthode pour réaliser le déplacement d'un nuage toxique
     * @param dx Variation sur l'axis X
     * @param dy Variation sur l'axis Y
     */
    @Override
    public boolean deplace(int dx, int dy) {
        if((dx >= -1) && (dx <= 1) && (dy >= -1) && (dy <= 1)){
            this.getPos().translate(dx, dy);
            return true;
        } 
        else{
            return false;
        }
    }
    
    public int getPAtt(){
        return this.pAtt;
    }
    
    public int getPPar(){
        return this.pPar;
    }
    
    public int getDegAtt(){
        return this.degAtt;
    }
    
    public int getPtPar(){
        return this.ptPar;
    }

    /**
     * Méthode pour réaliser l'attaque d'un nuage toxique
     * @param c Créature qui sera attaquée par le nuage toxique
     */
    @Override
    public void combattre(Creature c) {
        if(this.pAtt > c.getPourcentagePar()){ //Si attaque de la nuage est plus grand que du joueur
            c.setPtVie(c.getPtVie() - this.degAtt);
            System.out.println("Vous avez perdu "+ this.degAtt+" points de vie!");
        }
        else{
            System.out.println("Vous avez defendu! Pas de points de vie perdu!");
        }
    }

    /**
     * Méthode pas encore fait, mais il sera responsable de rélier un nuage à un Personnage
     * @param p Personnage qui est arrivé dans un nuage toxique
     */
    public void ramasser(Personnage p) {
        System.out.println("Vous avez trouvé une nuage toxique!");
        this.combattre(p);
    }
    
    /**
     * Méthode pour renvoyer le texte avec les informations
     * du objet dans le bon format
     */
    public String getTexteSauvegarde() {
        return "NuageToxique "+this.getPAtt()+" "+this.getPPar()+" "+this.getDegAtt()+" "+this.getPtPar()+" "+this.getPos().getX()+" "+this.getPos().getY();
    }
}