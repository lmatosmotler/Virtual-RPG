/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;



import java.io.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe de Sauvegarder parties dans un fichier texte
 * @author ALVES DE ABREU João Pedro et MATOS MOLTER Lucas
 */
public class SauvegardePartie {
    private BufferedWriter bufferedWriter;
    private String fileName;
   
/**
 * Constructeur de la classe
 * @param name nom du fichier
 */
    public SauvegardePartie(String name){
        this.fileName = name;
        this.bufferedWriter = null;
    }
/**
 * Constructeur de la classe sans paramètres 
 */
    public SauvegardePartie(){
        this.fileName = "Sauvegarde-WoE"+Instant.now().getEpochSecond()+".txt";
        this.bufferedWriter = null;
    }
  
/**
 * Méthode qui reçoit un paramètre du type World et écrit ses informations
 * dans un fichier texte
 * @param w variable du type World
 */   
    public void sauvagerderPartie(World w){
       
       try{
           this.bufferedWriter = new BufferedWriter(new FileWriter(this.fileName));
           this.bufferedWriter.write("Largeur "+ w.getRow());
           this.bufferedWriter.newLine();
           this.bufferedWriter.write("Hauteur "+w.getCol());
           for(int i = 0; i<w.elementsDeJeu.size();i++){
               this.bufferedWriter.newLine();
               this.bufferedWriter.write(w.elementsDeJeu.get(i).getTexteSauvegarde());
           }
           this.bufferedWriter.newLine();
           this.bufferedWriter.write("Joueur "+w.j.getTexteSauvegarde());
           System.out.println("Le jeu a été enregistré sur le nom : "+fileName);
       } catch (FileNotFoundException ex) {
           ex.printStackTrace();
       } catch (IOException ex) {
            Logger.getLogger(TestWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
       finally{
           try{
               if(bufferedWriter != null){
                   bufferedWriter.flush();
                   bufferedWriter.close();
               }
           }
           catch(IOException ex){
               ex.printStackTrace();
           }
       }
    }
}
