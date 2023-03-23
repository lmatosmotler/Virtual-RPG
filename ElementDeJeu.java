/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * Classe de Création de ElementDeJeu
 * @author ALVES DE ABREU João Pedro et MATOS MOLTER Lucas
 */
public abstract class ElementDeJeu {
    
    private Point2D pos;
    
    public ElementDeJeu(Point2D pos){
        this.pos = pos;
    }
    
    public void setPos(Point2D p){
        this.pos.setPosition(p.getX(), p.getY());
    }
    
    public Point2D getPos(){
        return this.pos;
    }
    
    public abstract String getTexteSauvegarde();
    
}
