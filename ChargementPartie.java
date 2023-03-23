/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Classe de Chargement de parties à partir de fichier texte
 *
 * @author ALVES DE ABREU João Pedro et MATOS MOLTER Lucas
 */
public class ChargementPartie {

    private String source;
    private World wd;
    private ArrayList<String> strLis;
    private int row, col;

/**
 * Constructeur de la classe ChargementPartie
 * @param source Nom du fichier texte
 */
    public ChargementPartie(String source) {
        this.source = source + ".txt";
        this.strLis = new ArrayList<String>();
        wd = new World();
    }
/**
 * Méthode pour lire le fichier et fait appels à méthodes auxiliaires
     * @return renvoie un objet du type World
 */
    public World chargerPartie(){
        try {
          String ligne ;
          BufferedReader fichier = new BufferedReader(new FileReader(this.source));
          ligne = fichier.readLine();
          int compt = 0;
          while (ligne != null) {
              this.strLis = stringTokenizer(ligne);
              if(this.strLis.get(0).equals("Largeur") || this.strLis.get(0).equals("Hauteur")){
                  compt+=1;
              }
              creerElementJeu(this.strLis);
              if(compt == 2){
                  wd = new World(this.row, this.col);
                  compt = 0;
              }
              //System.out.println(ligne);
              ligne = fichier.readLine();
          }
          fichier.close();
          for(int i=0;i<wd.objets.size();i++){
            wd.monde[wd.objets.get(i).getPos().getX()][wd.objets.get(i).getPos().getY()] = 2;
          }
          
          for(int i=0;i<wd.creatures.size();i++){
            wd.monde[wd.creatures.get(i).getPos().getX()][wd.creatures.get(i).getPos().getY()] = 1;
          }
          
          wd.monde[wd.j.getPersonnage().getPos().getX()][wd.j.getPersonnage().getPos().getY()] = 5;
          
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wd;
    }

/**
 * Méthode pour séparer une ligne en différents mots à chaque 'espace' trouvé
 * @param ligne Une ligne du fichier texte
 */
    public ArrayList<String> stringTokenizer(String ligne) {
        ArrayList<String> strLis = new ArrayList<String>();
        String delimiteur = " ";
        StringTokenizer tokenizer = new StringTokenizer(ligne, delimiteur);
        while (tokenizer.hasMoreTokens()) {
            // nextToken() retourne la prochaine unite lexicale decoupee par les delimiteurs
            String mot = tokenizer.nextToken();
            // pour l'exemple, on transforme 'mot' en lettres minuscules
            //mot = mot.toLowerCase();
            // on affiche 'mot' qui est maintenant en minuscules
            strLis.add(mot);
        }
        return strLis;
    }

/**
 * Méthode pour aider la création de elementsDeJeu
 * @param info ArrayList avec les informations obtenues du fichier texte
 */
    public void creerElementJeu(ArrayList<String> info){
        switch(info.get(0)){ //premiere mot de la ligne, elle sera determinant
            case "Largeur":
                //wd.setCol(Integer.parseInt(info.get(1)));
                this.col = Integer.parseInt(info.get(1));
                break;
            case "Hauteur":
                //wd.setRow(Integer.parseInt(info.get(1)));
                this.row = Integer.parseInt(info.get(1));
                break;
            case "Guerrier":
                creerPersonnage(info);
                break;
            case "Mage":
                creerPersonnage(info);
                break;     
            case "Archer":
                creerPersonnage(info);
                break;
            case "Paysan":
                creerPersonnage(info);
                break;
            case "Lapin":
                creerMonstre(info);
                break;
            case "Loup":
                creerMonstre(info);
                break;
            case "Soin":
                creerObjet(info);
                break;
            case "Mana":
                creerObjet(info);
                break;
            case "NourritureBonusDamAtt":
                creerObjet(info);
                break;
            case "NourritureMalusDamAtt":
                creerObjet(info);
                break;
            case "NuageToxique":
                creerObjet(info);
                break;
            case "Joueur":
                creerJoueur(info);
                break;
            default:
                break;
        }
        
        
    }

/**
 * Méthode pour la création de Guerrier, Archer, Mage et Paysan
 * @param info ArrayList avec les informations obtenues du fichier texte
 */
    public void creerPersonnage(ArrayList<String> info) {
        String nom;
        int ptV, ptM, pA, pP, pM, rM, dA, dM, distMax, ptPar;
        Point2D pos;

        nom = info.get(1);
        ptV = Integer.parseInt(info.get(2));
        ptM = Integer.parseInt(info.get(3));
        pA = Integer.parseInt(info.get(4));
        pP = Integer.parseInt(info.get(5));
        pM = Integer.parseInt(info.get(6));
        rM = Integer.parseInt(info.get(7));
        dA = Integer.parseInt(info.get(8));
        dM = Integer.parseInt(info.get(9));
        distMax = Integer.parseInt(info.get(10));
        pos = new Point2D(Integer.parseInt(info.get(11)), Integer.parseInt(info.get(12)));
        ptPar = Integer.parseInt(info.get(13));

        switch (info.get(0)) {
            case "Guerrier":
                Guerrier g = new Guerrier(nom, ptV, ptM, pA, pP, pM, rM, dA, dM, distMax, pos, ptPar);
                wd.creatures.add(g);
                wd.elementsDeJeu.add(g);
                //String nom, int ptV, int ptM, int pA, int pP, int pM, int rM, int dA, int dM, int distMax, Point2D pos, int ptPar
                break;
            case "Mage":
                Mage m = new Mage(nom, ptV, ptM, pA, pP, pM, rM, dA, dM, distMax, pos, ptPar);
                wd.creatures.add(m);
                wd.elementsDeJeu.add(m);
                //String nom, int ptV, int ptM, int pA, int pP, int pM, int rM, int dA, int dM, int distMax, Point2D pos, int ptPar
                break;
            case "Archer":
                int nbF = Integer.parseInt(info.get(14));
                Archer a = new Archer(nom, ptV, ptM, pA, pP, pM, rM, dA, dM, distMax, pos, ptPar, nbF);
                wd.creatures.add(a);
                wd.elementsDeJeu.add(a);
                //String nom, int ptV,int ptM, int pA, int pP, int pM, int rM, int dA, int dM, int distMax, Point2D pos, int nbF, int ptPar
                //Il faut remarquer qu'on a ajouté le nombre de fleches !!
                break;
            case "Paysan":
                Paysan p = new Paysan(nom, ptV, ptM, pA, pP, pM, rM, dA, dM, distMax, pos, ptPar);
                wd.creatures.add(p);
                wd.elementsDeJeu.add(p);
                break;
        }
    }

/**
 * Méthode pour la création de Loup et Lapin
 * @param info ArrayList avec les informations obtenues du fichier texte
 */
    public void creerMonstre(ArrayList<String> info) {
        int ptV, pA, pP, dA, ptPar;
        Point2D pos;
        //int ptV, int pA, int pP, int dA, Point2D pos,int ptPar
        ptV = Integer.parseInt(info.get(1));
        pA = Integer.parseInt(info.get(2));
        pP = Integer.parseInt(info.get(3));
        dA = Integer.parseInt(info.get(4));
        ptPar = Integer.parseInt(info.get(5));
        pos = new Point2D(Integer.parseInt(info.get(6)), Integer.parseInt(info.get(7)));

        switch (info.get(0)) {
            case "Loup":
                Loup lo = new Loup(ptV, pA, pP, dA, pos, ptPar);
                //int pV, int pA, int pP, int dA, Point2D p, int ptPar
                wd.creatures.add(lo);
                wd.elementsDeJeu.add(lo);
                break;
            case "Lapin":
                Lapin la = new Lapin(ptV, pA, pP, dA, pos, ptPar);
                //int pV, int pA, int pP, int dA, Point2D p, int ptPar
                wd.creatures.add(la);
                wd.elementsDeJeu.add(la);
                break;
        }

    }
/**
 * Méthode pour la création de Soin, Mana, Nourriture et NuageToxique
 * @param info ArrayList avec les informations obtenues du fichier texte
 */
    public void creerObjet(ArrayList<String> info) {
        int p;
        Point2D pos;

        p = Integer.parseInt(info.get(1));
        pos = new Point2D(Integer.parseInt(info.get(2)), Integer.parseInt(info.get(3)));
        switch (info.get(0)) {
            case "Soin":
                Soin s = new Soin(p, pos);
                wd.objets.add(s);
                wd.elementsDeJeu.add(s);
                break;
            case "Mana":
                Mana m = new Mana(p, pos);
                wd.objets.add(m);
                wd.elementsDeJeu.add(m);
                break;
            case "NourritureBonusDamAtt":
                NourritureBonusDamAtt nb = new NourritureBonusDamAtt(p, pos);
                wd.objets.add(nb);
                wd.elementsDeJeu.add(nb);
                break;
            case "NourritureMalusDamAtt":
                NourritureMalusDamAtt nm = new NourritureMalusDamAtt(p, pos);
                wd.objets.add(nm);
                wd.elementsDeJeu.add(nm);
                break;
            case "NuageToxique":
                int pA,
                 pP,
                 dA,
                 ptPar;
                pA = Integer.parseInt(info.get(1));
                pP = Integer.parseInt(info.get(2));
                dA = Integer.parseInt(info.get(3));
                ptPar = Integer.parseInt(info.get(4));
                pos = new Point2D(Integer.parseInt(info.get(5)), Integer.parseInt(info.get(6)));
                NuageToxique nt = new NuageToxique(pA, pP, dA, ptPar, pos);
                wd.objets.add(nt);
                wd.elementsDeJeu.add(nt);
                break;
        }

    }
/**
 * Méthode pour la création de Joueur
 * @param info ArrayList avec les informations obtenues du fichier texte
 */
    private void creerJoueur(ArrayList<String> info) {
        String nom, pers;
        int ptV, ptM, pA, pP, pM, rM, dA, dM, distMax, ptPar;
        Point2D pos;

        pers = info.get(1);
        nom = info.get(2);
        ptV = Integer.parseInt(info.get(3));
        ptM = Integer.parseInt(info.get(4));
        pA = Integer.parseInt(info.get(5));
        pP = Integer.parseInt(info.get(6));
        pM = Integer.parseInt(info.get(7));
        rM = Integer.parseInt(info.get(8));
        dA = Integer.parseInt(info.get(9));
        dM = Integer.parseInt(info.get(10));
        distMax = Integer.parseInt(info.get(11));
        pos = new Point2D(Integer.parseInt(info.get(12)), Integer.parseInt(info.get(13)));
        ptPar = Integer.parseInt(info.get(14));

        switch (pers) {
            case "Archer":
                int nbF = Integer.parseInt(info.get(15));
                wd.j = new Joueur(pers, nom, ptV, ptM, pA, pP, pM, rM, dA, dM, distMax, pos, ptPar, nbF);
                break;
            default:
                wd.j = new Joueur(pers, nom, ptV, ptM, pA, pP, pM, rM, dA, dM, distMax, pos, ptPar, 0);
                break;
        }
    }

}
