/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * Classe de Création de Lapin
 * @author ALVES DE ABREU João Pedro et MATOS MOLTER Lucas
 */
public class Lapin extends Monstre {
    
/**
 * Constructeur de la classe Lapin en passant tous les paramètres.
 * @param ptV   Points de Vie
 * @param pA    Pourcentage de Attaque
 * @param pP    Pourcentage de 
 * @param dA    Damage de Attaque
 * @param pos   Position du objet
 * @param ptPar Points de parade
 */
    public Lapin(int ptV, int pA, int pP, int dA, Point2D pos,int ptPar){
        super(ptV, pA, pP, dA, pos, ptPar);
    }
    
/**
 * Constructeur de la classe Lapin en passant un objet.
 * @param l Objet de la classe Lapin
 */
    public Lapin(Lapin l){
        super(l); 
    }
   
/**
 * Constructeur de la classe Lapin sans paramètres.
 * Initialisation des variables avec valeurs null
 */
    public Lapin(){
        super();
        this.setPtVie(10);
    }
        


    @Override
    public void affiche() {
        System.out.println("Lapin est dans la position (" + this.getPos().getX() + "," + this.getPos().getY() + ") et il a " + this.getPtVie() + " de Vie");
    }
    
    /**
     * Méthode pour renvoyer le texte avec les informations
     * du objet dans le bon format
     */
    @Override
    public String getTexteSauvegarde() {
        return "Lapin "+this.getPtVie()+" "+this.getPourcentageAtt()+" "+this.getPourcentagePar()
                +" "+this.getDegAtt()+" "+this.getPos().getX()+" "+this.getPos().getY()+" "+this.getPtPar();
    }
}