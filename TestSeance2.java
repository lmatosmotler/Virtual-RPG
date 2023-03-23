/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * Classe de Création et Manipulation du Monde
 * @author ALVES DE ABREU João Pedro et MATOS MOLTER Lucas
 */
public class TestSeance2 {
    public static void main(String[] args){
        World w1 = new World();
        
        //w1.testCombattre();
        
        w1.robin.setNom("Legolas");
        System.out.println("Pts Vie: "+w1.robin.getPtVie());
        w1.robin.getPos().setPosition(0, 0);
        
        w1.soin1.setPuissance(50);
        w1.soin1.getPos().setPosition(0, 0);
        
        //Verification si ils sont dans la même position
        if(w1.robin.getPos().distance(w1.soin1.getPos()) == 0){
            w1.soin1.augmenterPtVie(w1.robin);
            System.out.println("Pts Vie: "+w1.robin.getPtVie());
        }
    }
}
