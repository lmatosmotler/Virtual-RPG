/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * Classe de Teste du Projet World of ECN
 * @author ALVES DE ABREU João Pedro et MATOS MOLTER Lucas
 */
public class TestSeance1 {
    
    public static void main(String[] args){
        // On crée un monde en passant aucune attribut, donc les personnages au début ils n'auront pas de nom
        World w1 = new World();
        
        // Cette fonction positionne les personnages en respectant les contraintes du diapo
        w1.creeMondeAlea();
        /*
        w1.robin.affiche();
        w1.bugs.affiche();
        w1.peon.affiche();
        w1.guillaumeT.affiche();
        w1.magic.affiche();
        w1.warrior.affiche();
        w1.wolf.affiche();
        */
        //On change certaines attributs du objet robin (classe Archer)
       
        w1.robin.setNom("Legolas");
        w1.guillaumeT.setNom("Cortela");
        w1.robin.affiche();
        w1.guillaumeT.affiche();
        System.out.println("La distance entre les deux est: "
        +w1.robin.getPos().distance(w1.guillaumeT.getPos()));
        
        
        /*
        System.out.println("Adresse memoire de la position de chaque objet : ");
        System.out.println(w1.robin.pos);
        System.out.println(w1.guillaumeT.pos);
        System.out.println("Adresse memoire de chaque objet: ");
        System.out.println(w1.robin);
        System.out.println(w1.guillaumeT);
        w1.guillaumeT.setNom("Cortela");
        w1.guillaumeT.setNbFleches(100);
        */
        
        /*
        w1.peon.setNom("Aragorn");
        
        
        w1.robin.affiche();
        w1.bugs.affiche();
        w1.peon.affiche();
        
        w1.robin.deplace(1, 1); //slide 10 -> changement de position de l'objet Robin
        w1.peon.deplace(1, 1);
        w1.bugs.deplace(-1, 1);
        w1.robin.deplace(10, 10);
        w1.peon.deplace(10, 10);
        w1.bugs.deplace(-10, 10);
        
        w1.robin.affiche();//slide 10 encore
        w1.guillaumeT.affiche();//slide 10 encore, le but c'est de vérifier si les deux ne sont pas dans la même position
        
        */
    }
}
