/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Random;
import java.util.Scanner;
import static org.centrale.projet.objet.World.COL;
import static org.centrale.projet.objet.World.ROW;

/**
 * Classe de Création de Joueur
 * @author ALVES DE ABREU João Pedro et MATOS MOLTER Lucas
 */
public class Joueur {
    
    private Personnage perso;
    
    /**
     * Constructeur de la classe joueur où on demande à l'utilisateur le type de personnage et son nom.
     */
    public Joueur(){
        Random generateurAleatoire = new Random();
        String type="Fluminense";
        String nom;
        Scanner scanner = new Scanner(System.in);
        
        while(!("A".equals(type))&&!("G".equals(type))&&!("M".equals(type))){
            System.out.println("Entrez le type de personnage avec lequelle vous voulez jouer, soit G pour Guerrier, A pour Archer ou M pour Mage: ");
            type = scanner.nextLine();
            if("G".equals(type)){
                System.out.println("Vous avez bien choisi le Guerrier. Quel nome vous voulez donner à votre personnage?");
                nom = scanner.nextLine();
                while (nom.contains(" ")) {
                    System.out.println("Vous ne pouvez pas utiliser des espaces dans le nom du personnage!!");
                    System.out.println("Nom : ");
                    nom = scanner.nextLine();
                }
                Point2D pos = new Point2D(0,0);
                //String nom, int ptV, int pA, int pP, int pM, int rM, int dA, int dM, int distMax, Point2D pos, int arm, int ptPar
                perso = new Guerrier(nom, 100, 0,generateurAleatoire.nextInt(100),100- generateurAleatoire.nextInt(50), 
                        generateurAleatoire.nextInt(50), generateurAleatoire.nextInt(50), generateurAleatoire.nextInt(5), 
                        generateurAleatoire.nextInt(10),5-generateurAleatoire.nextInt(5),pos,generateurAleatoire.nextInt(5));
                System.out.println("Le guerrier "+ nom +" a été bién créé");
                
            } else if("M".equals(type)){
                System.out.println("Vous avez bien choisi le Mage. Quel nome vous voulez donner à votre personnage?");
                nom = scanner.nextLine();
                while (nom.contains(" ")) {
                    System.out.println("Vous ne pouvez pas utiliser des espaces dans le nom du personnage!!");
                    System.out.println("Nom : ");
                    nom = scanner.next();
                }
                Point2D pos = new Point2D(0,0); 
                //String nom, int ptV, int ptM, int pA, int pP, int pM, int rM, int dA, int dM, int distMax, Point2D pos, int ptPar
                perso = new Mage(nom, 100, generateurAleatoire.nextInt(100), 100 - generateurAleatoire.nextInt(50), 
                        100-generateurAleatoire.nextInt(50), generateurAleatoire.nextInt(50), generateurAleatoire.nextInt(15), 
                        generateurAleatoire.nextInt(10),generateurAleatoire.nextInt(3),10-generateurAleatoire.nextInt(8),pos,generateurAleatoire.nextInt(5));
                System.out.println("Le mage "+ nom +" a été bién créé");    
            } else if("A".equals(type)){
                System.out.println("Vous avez bien choisi le Archer. Quel nome vous voulez donner à votre personnage?");
                nom = scanner.nextLine();
                while (nom.contains(" ")) {
                    System.out.println("Vous ne pouvez pas utiliser des espaces dans le nom du personnage!!");
                    System.out.println("Nom : ");
                    nom = scanner.nextLine();
                }
                Point2D pos = new Point2D(0,0); 
                //String nom, int ptV, int pA, int pP, int pM, int rM, int dA, int dM, int distMax, Point2D pos, int nbF, int ptPar
                perso = new Archer(nom, 100, 0,generateurAleatoire.nextInt(100), 100 - generateurAleatoire.nextInt(50), 
                        generateurAleatoire.nextInt(50), generateurAleatoire.nextInt(50), generateurAleatoire.nextInt(15), 
                        generateurAleatoire.nextInt(10),10-generateurAleatoire.nextInt(8),pos,30-generateurAleatoire.nextInt(10),generateurAleatoire.nextInt(5));
                System.out.println("L'Archer "+ nom +" a été bién créé");
            } else {
                System.out.println("Si vous voyez ce message c'est parce que on n'a pas compris votre demande. Insérez le mot Sortie si vous ne voulez plus jouer");
                System.out.println("N'oubliez pas que les types des personnages sont écrits de la manière suivante : Guerrier, Mage et Archer");
            }
        }
        
        if("Sortie".equals(type)){
            this.perso = null;
        }
    }
/**
 * Constructeur de la classe Joueur qui sera utilisé à partir d'un fichier texte.
 * @param pers Classe du personnage
 * @param nom nom du personnage
 * @param ptV Points de Vie
 * @param ptM Points de Magie
 * @param pA Pourcentage de Attaque
 * @param pP Pourcentage de Parade
 * @param pM Pourcentage de Magie
 * @param rM Pourcentage de Resistance de Magie
 * @param dA Damage de Attaque
 * @param dM Damage de Magie
 * @param distMax Distance de Attaque Max
 * @param pos Postion du objet
 */

    public Joueur(String pers, String nom, int ptV, int ptM, int pA, int pP, int pM, int rM, int dA, int dM, int distMax, Point2D pos, int ptPar, int nbF){
        
        switch(pers){
            case "Guerrier":
                perso = new Guerrier(nom, ptV, ptM, pA, pP, pM, rM, dA, dM, distMax, pos, ptPar);
                break;
            case "Mage":
                perso = new Mage(nom, ptV, ptM, pA, pP, pM, rM, dA, dM, distMax, pos, ptPar);
                break;
            case "Archer":
                perso = new Archer(nom, ptV, ptM, pA, pP, pM, rM, dA, dM, distMax, pos, ptPar, nbF);
                break;
        }
    }

    //On pense qu'il n'est pas logique de créer une méthode setPersonnage
    public Personnage getPersonnage(){
        return this.perso;
    }
    /**
     * Méthode pour permettre que l'utilisateur fasse la choix de déplacement
     * @param w objet monde
     */
    public void deplaceJoueur(World w){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("On vous rappele que votre personnage est dans la position "+this.perso.getPos().getX()+", "+this.perso.getPos().getY());
        System.out.println("Inserez SVP a-z-e-q-d-w-x-c :");
        int pos[];
        pos = this.choixDeDirection();
        
        boolean control = false;
        w.monde[this.perso.getPos().getX()][this.perso.getPos().getY()] = 0; //mise à jour de la matrice des positions
        
        if(w.monde[pos[0]][pos[1]]!=1){
            
            control = this.perso.deplace(pos[0]-this.perso.getPos().getX(), pos[1]-this.perso.getPos().getY());
        }
        
        while(!control){
            pos = this.choixDeDirection();
            if(w.monde[pos[0]][pos[1]]!=1){
                control = this.perso.deplace(pos[0]-this.perso.getPos().getX(), pos[1]-this.perso.getPos().getY());
            }  
        }
        
        
        //this.perso.getPos().setPosition(posX, posY);
        System.out.println("Votre personnage "+this.perso.getNom()+" est bien dans la position: "+this.perso.getPos().getX()+", "+this.perso.getPos().getY());
        if(w.monde[this.perso.getPos().getX()][this.perso.getPos().getY()] == 2){
            //chamar método que faz consumir o que tinha na casa
            System.out.println("Vous avez ramassé un objet!");
            for(int i=0; i<w.objets.size(); i++){
                if(w.objets.get(i).getPos().getX()==this.perso.getPos().getX() && w.objets.get(i).getPos().getY() == this.perso.getPos().getY()){
                    w.objets.get(i).ramasser(perso);
                    w.monde[this.perso.getPos().getX()][this.perso.getPos().getY()]=5;
                    w.objets.remove(i);
                }
            }
        }
        w.monde[this.perso.getPos().getX()][this.perso.getPos().getY()] = 5; //mise à jour de la matrice des positions Partie 2
    
    }
    
    public void affiche(){
        System.out.println("Le joueur "+this.getPersonnage().getNom()+" est dans la case "+this.getPersonnage().getPos().getX()+", "
                +this.getPersonnage().getPos().getY()+" avec "+this.getPersonnage().getPtVie()+" points de vie");
    }
    
    /**
     * Méthode pour renvoyer le texte avec les informations
     * du objet dans le bon format
     */
    public String getTexteSauvegarde(){
        String palavra = "";
        if (this.getPersonnage() instanceof Archer){
            palavra = "Archer "+this.getPersonnage().getNom()+" "+this.getPersonnage().getPtVie()+" "+this.getPersonnage().getPtMana()+" "+this.getPersonnage().getPourcentageAtt()+" "+this.getPersonnage().getPourcentagePar()
                +" "+this.getPersonnage().getPourcentageMag()+" "+this.getPersonnage().getPourcentageResistMag()+" "+this.getPersonnage().getDegAtt()
                +" "+this.getPersonnage().getDegMag()+" "+this.getPersonnage().getDistAttMax()+" "+this.getPersonnage().getPos().getX()
                +" "+this.getPersonnage().getPos().getY()+" "+this.getPersonnage().getPtPar()+" "+((Archer)this.getPersonnage()).getNbFleches();
            
            return palavra;
        } else if(this.getPersonnage() instanceof Guerrier) {
            palavra = "Guerrier ";
        } else if (this.getPersonnage() instanceof Mage){
            palavra = "Mage ";
        }
        
        palavra = palavra+this.getPersonnage().getNom()+" "+this.getPersonnage().getPtVie()+" "+this.getPersonnage().getPtMana()+" "+this.getPersonnage().getPourcentageAtt()+" "+this.getPersonnage().getPourcentagePar()
                +" "+this.getPersonnage().getPourcentageMag()+" "+this.getPersonnage().getPourcentageResistMag()+" "+this.getPersonnage().getDegAtt()
                +" "+this.getPersonnage().getDegMag()+" "+this.getPersonnage().getDistAttMax()+" "+this.getPersonnage().getPos().getX()
                +" "+this.getPersonnage().getPos().getY()+" "+this.getPersonnage().getPtPar();
        return palavra;
    }
    
    /**
     * Méthode qui permettre le déplacement du joueur à partir du clavier
     */
    public int[] choixDeDirection(){
        int posX=0, posY=0;
        Scanner scanner = new Scanner(System.in);
        
        String move = scanner.next();
        boolean control = this.validationPosition(move, this.getPersonnage().getPos().getX(), this.getPersonnage().getPos().getY());
        
        while(!("a".equals(move)||"z".equals(move)||"e".equals(move)||"q".equals(move)||"d".equals(move)||"w".equals(move)||"x".equals(move)||"c".equals(move))||!control){
            System.out.println("Vouz n'avez pas inserez une bonne valuer. Inserez a ou z ou e ou q ou d ou w ou x ou c :");
            move=scanner.next();
            control = this.validationPosition(move, this.getPersonnage().getPos().getX(), this.getPersonnage().getPos().getY());
        }
        
        switch (move){
            case "a" :
                posX = this.getPersonnage().getPos().getX() - 1;
                posY = this.getPersonnage().getPos().getY() - 1;
                break;
            case "z":
                posX = this.getPersonnage().getPos().getX() - 1;
                posY = this.getPersonnage().getPos().getY();
                break;
            case "e":
                posX = this.getPersonnage().getPos().getX() - 1;
                posY = this.getPersonnage().getPos().getY() + 1;
                break;
            case "q":
                posX = this.getPersonnage().getPos().getX();
                posY = this.getPersonnage().getPos().getY() - 1;
                break;
            case "d":
                posX = this.getPersonnage().getPos().getX();
                posY = this.getPersonnage().getPos().getY() + 1;
                break;
            case "w":
                posX = this.getPersonnage().getPos().getX() + 1;
                posY = this.getPersonnage().getPos().getY() - 1;
                break;
            case "x":
                posX = this.getPersonnage().getPos().getX() + 1;
                posY = this.getPersonnage().getPos().getY();
                break;
            case "c":
                posX = this.getPersonnage().getPos().getX() + 1;
                posY = this.getPersonnage().getPos().getY() + 1;
                break;
                
        }
        
        
        return new int[] {posX, posY};
    }
    
    public boolean validationPosition(String choix, int posX, int posY){
        boolean resposta = true;
        switch (choix){
            
            case "a" :
                posX = posX - 1;
                posY = posY - 1;
                break;
            case "z":
                posX = posX - 1;
                posY = posY;
                break;
            case "e":
                posX = posX - 1;
                posY = posY + 1;
                break;
            case "q":
                posX = posX;
                posY = posY - 1;
                break;
            case "d":
                posX = posX;
                posY = posY + 1;
                break;
            case "w":
                posX = posX + 1;
                posY = posY - 1;
                break;
            case "x":
                posX = posX + 1;
                posY = posY;
                break;
            case "c":
                posX = posX + 1;
                posY = posY + 1;
                break;
            default :
                resposta = false;
                break;
        }
        if(posX < 0 || posY < 0 || posX>(ROW-1) || posY>(COL-1)){
            resposta = false;
        }
        return resposta;
        
    }
    
    /**
     * Méthode pour faire le combat lorsque l'utilisateur veut. Méthode appellé par tourDeJeu
     * @param c créature qui sera attaquée
     */
    
    public void combattreJoueur(Creature c){
        ((Combattant)this.perso).combattre(c);
    }
   
}
