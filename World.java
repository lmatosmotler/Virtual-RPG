/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.io.File;
import java.util.Random;
import java.lang.Math;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Classe de Création et Manipulation du Monde
 *
 * @author ALVES DE ABREU João Pedro et MATOS MOLTER Lucas
 */
public class World {

    //defining 2D array to hold matrix data
    public static int ROW = 15;
    public static int COL = 15;

    int[][] monde;
    public ArrayList<Creature> creatures;
    public ArrayList<Objet> objets;
    public ArrayList<ElementDeJeu> elementsDeJeu;
    public Joueur j;

    /**
     * Constructeur de la classe sans paramètres Cela sera utile pour créer un
     * monde aléatoirement
     */
    public World() {
        creatures = new ArrayList<>();
        objets = new ArrayList<>();
        monde = new int[ROW][COL];
        elementsDeJeu = new ArrayList<>();
    }

    /**
     * Constructeur de la classe avec paramètres Cela sera utile pour créer un
     * monde à partir d'un fichier texte
     *
     * @param row nombre de lignes
     * @param col nombre de collones
     */
    public World(int row, int col) {
        creatures = new ArrayList<>();
        objets = new ArrayList<>();
        elementsDeJeu = new ArrayList<>();
        monde = new int[row][col];
        this.setRow(row);
        this.setCol(col);
    }

    public void setRow(int value) {
        this.ROW = value;
    }

    public int getRow() {
        return this.ROW;
    }

    public void setCol(int value) {
        this.COL = value;
    }

    public int getCol() {
        return this.COL;
    }

    /**
     * Méthode pour créer une Monde d'une façon randomique, et appeler des
     * autres méthodes pour créer les personnages d'une façon aleatoire et après
     * les places aussi aleatoirrement
     */
    public void creeMondeAlea(int total) {
        //initializer tous les personnages et objets

        this.monde[0][0] = 1; //pour s'assurer que acune creature sera dans la positions du joueur
        this.creePersonnageAlea(total);
        this.creeObjetAlea(total);
        // initializer le monde vide
        int i, j;
        for (i = 0; i < ROW; i++) {
            for (j = 0; j < COL; j++) {
                monde[i][j] = 0;
            }
        }

        //placer tous les objets
        for (i = 0; i < objets.size(); i++) {
            placerObjet(objets.get(i));
        }

        //placer tous les personnages
        for (i = 0; i < creatures.size(); i++) {
            placerCreature(creatures.get(i));
        }

        this.monde[0][0] = 5; //pour être claire à l'utilisateur où est le personnage

    }

    /**
     * Générer des coordonnées x et y à l'aide de la paquetage Random et en
     * analysant la matrice monde on peut savoir si la case est vide
     *
     * @param c Creature à être placée dans le monde
     */
    public void placerCreature(Creature c) {

        Random generateurAleatoire = new Random();
        int x = generateurAleatoire.nextInt(ROW);
        int y = generateurAleatoire.nextInt(COL);

        while (!(this.validationPosition(x, y))) {
            x = generateurAleatoire.nextInt(ROW);
            y = generateurAleatoire.nextInt(COL);
        }

        c.getPos().setPosition(x, y);
        monde[x][y] = 1;//maintenant la nouvelle case est déjà marquée  

    }

    /**
     * Générer des coordonnées x et y à l'aide de la paquetage Random et en
     * analysant la matrice monde on peut savoir si la case est vide
     *
     * @param o Objet à être placée dans le monde
     */
    public void placerObjet(Objet o) {
        Random generateurAleatoire = new Random();
        int x = generateurAleatoire.nextInt(ROW);
        int y = generateurAleatoire.nextInt(ROW);

        while (!(monde[x][y] == 0)) {
            x = generateurAleatoire.nextInt(ROW);
            y = generateurAleatoire.nextInt(ROW);
        }

        o.getPos().setPosition(x, y);
        monde[x][y] = 2;
    }

    /**
     * Méthode pour créer d'une façon aléatoire les objets du jeu
     *
     * @param total le nombre d'objets qu'on veut dans le jeu
     */
    public void creeObjetAlea(int total) {
        Random generateurAleatoire = new Random();
        int compt = 0;
        int entierAlea;

        entierAlea = generateurAleatoire.nextInt(total / 5);
        compt += entierAlea;
        for (int i = 0; i < entierAlea; i++) {
            objets.add(new Soin(i + 1, new Point2D()));
            elementsDeJeu.add(objets.get(objets.size() - 1));
        }

        entierAlea = generateurAleatoire.nextInt(total / 5);
        compt += entierAlea;
        for (int i = 0; i < entierAlea; i++) {
            objets.add(new Mana(i + 1, new Point2D()));
            elementsDeJeu.add(objets.get(objets.size() - 1));
        }

        entierAlea = generateurAleatoire.nextInt(total / 5);
        compt += entierAlea;
        for (int i = 0; i < entierAlea; i++) {
            objets.add(new NourritureMalusDamAtt(i, new Point2D()));
            elementsDeJeu.add(objets.get(objets.size() - 1));
        }

        entierAlea = generateurAleatoire.nextInt(total / 5);
        compt += entierAlea;
        for (int i = 0; i < entierAlea; i++) {
            objets.add(new NourritureBonusDamAtt(i, new Point2D()));
            elementsDeJeu.add(objets.get(objets.size() - 1));
        }
        entierAlea = total - compt;
        compt += entierAlea;
        for (int i = 0; i < entierAlea; i++) {
            objets.add(new NuageToxique(10 - generateurAleatoire.nextInt(10), 10 - generateurAleatoire.nextInt(10), 10 - generateurAleatoire.nextInt(10), 10 - generateurAleatoire.nextInt(10), new Point2D()));
            elementsDeJeu.add(objets.get(objets.size() - 1));
        }
    }

    /**
     * Méthode responsable pour la création des personnages. On remarque que le
     * nombre de chaque type de personnage est aleatoire, mais le nombre total
     * de personnages est forcement égal au paramètre reçu.
     *
     * @param total
     */
    public void creePersonnageAlea(int total) {
        Random generateurAleatoire = new Random();
        int compt = 0;
        int entierAlea;

        entierAlea = generateurAleatoire.nextInt(total / 5);
        compt += entierAlea;
        for (int i = 0; i < entierAlea; i++) {
            creatures.add(new Archer());
            elementsDeJeu.add(creatures.get((creatures.size() - 1)));
        }

        entierAlea = generateurAleatoire.nextInt(total / 5);
        compt += entierAlea;
        for (int i = 0; i < entierAlea; i++) {
            creatures.add(new Guerrier());
            elementsDeJeu.add(creatures.get(creatures.size() - 1));
        }

        entierAlea = generateurAleatoire.nextInt(total / 5);
        compt += entierAlea;
        for (int i = 0; i < entierAlea; i++) {
            creatures.add(new Mage());
            elementsDeJeu.add(creatures.get(creatures.size() - 1));
        }

        entierAlea = generateurAleatoire.nextInt(total / 5);
        compt += entierAlea;
        for (int i = 0; i < entierAlea; i++) {
            creatures.add(new Loup());
            elementsDeJeu.add(creatures.get(creatures.size() - 1));
        }

        entierAlea = total - compt;
        compt += entierAlea;
        for (int i = 0; i < entierAlea; i++) {
            creatures.add(new Lapin());
            elementsDeJeu.add(creatures.get(creatures.size() - 1));
        }
    }

    /**
     * La méthode suivante appelle la méthode de calcul du barycentre et aussi
     * calcule et affiche le temps d'éxecution de la máthode appelé.
     */
    public void mesurerTemps() {
        long debut = System.nanoTime();
        this.calculBaryIt();
        //this.calculBaryFor();
        long fin = System.nanoTime();
        System.out.println("Temps de parcours: " + (fin - debut) / (Math.pow(10, 6)) + " miliseconds");
    }

    /**
     * La méthode suivante fait le calcul du barycentre, en prenant les
     * coordonées X et Y de chaque personnage dans un boucle geré par un
     * iterateur.
     */
    public void calculBaryIt() {
        int totalP = 0;
        int totalX = 0;
        int totalY = 0;
        Iterator<Creature> listIt = creatures.iterator();
        while (listIt.hasNext()) {
            totalP++;
            Creature c = listIt.next();
            totalX += c.getPos().getX();
            totalY += c.getPos().getY();
        }
        float baryX = (float) totalX / totalP;
        float baryY = (float) totalY / totalP;
        System.out.println("Le barycentre est dans la position: (" + baryX + "," + baryY + ")");
    }

    /**
     * La méthode suivante fait le calcul du barycentre, en prenant les
     * coordonées X et Y de chaque personnage dans un boucle for.
     */
    public void calculBaryFor() {
        int totalP = 0;
        int totalX = 0;
        int totalY = 0;
        for (int i = 0; i < creatures.size(); i++) {
            totalP++;
            Creature c = creatures.get(i);
            totalX += c.getPos().getX();
            totalY += c.getPos().getY();
        }
        float baryX = (float) totalX / totalP;
        float baryY = (float) totalY / totalP;
        System.out.println("Le barycentre est dans la position: (" + baryX + "," + baryY + ")");
    }

    /**
     * Méthode responsable pour la communication avec le joueur. Il demande la
     * choix de l'utilisateur et fait l'appele du méthode de la classe joueur
     * correspondant
     *
     * @param j joueur
     */
    public boolean tourDeJeu(Joueur j) {
        Scanner scanner = new Scanner(System.in);
        String choix = "naoimporta";
        int posX = 0;
        int posY = 0;

        while (!(choix.equals("S")) && !(choix.equals("C")) && !(choix.equals("D")) && !(choix.equals("E"))) {
            System.out.println("Entrez C pour Combattre, D pour Deplacement, S pour Sauvegarder ou E pour Sortir");
            choix = scanner.nextLine();
        }

        if (choix.equals("D")) {
            j.deplaceJoueur(this);
        } else if (choix.equals("C")) {
            //this.afficheMonde();
            try {
                System.out.println("Inserez la coordonée X du personnage que vous voulez combattre: ");
                posX = scanner.nextInt();
                System.out.println("Inserez la coordonée Y du personnage que vous voulez combattre: ");
                posY = scanner.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Il faut rentrer un numero entier");
            }
            if (posX < 0 || posY < 0 || posX > (ROW - 1) || posY > (COL - 1)) {
                System.out.println("Ces coordonées n'existent pas dans la monde :( ");
            } else if (monde[posX][posY] != 1) {
                System.out.println("Aucune créature trouvée :( ");
            }
            for (int i = 0; i < creatures.size(); i++) {
                if (creatures.get(i).getPos().getX() == posX && creatures.get(i).getPos().getY() == posY) {
                    j.combattreJoueur(creatures.get(i)); //Joueur va combattre
                    if (creatures.get(i).getPtVie() > 0) { //On fait une vérification pour voir si la creature est toujours vif
                        if (creatures.get(i) instanceof Archer) { //Pour chaque 'if', on verifie si la creature peut combattre
                            //eu não gosto muito dessa ideia porque os affiches vão fazer parecer que é o jogador que está atacando...
                            System.out.println("L'archer " + ((Archer) creatures.get(i)).getNom() + " que t'as attaqué veut répondre avec un autre attaque");
                            ((Archer) creatures.get(i)).reCombattre(j.getPersonnage());
                        } else if (creatures.get(i) instanceof Guerrier) {
                            System.out.println("Le guerrier " + ((Guerrier) creatures.get(i)).getNom() + " que t'as attaqué veut répondre avec un autre attaque");
                            ((Guerrier) creatures.get(i)).reCombattre(j.getPersonnage());
                        } else if (creatures.get(i) instanceof Mage) {
                            System.out.println("Le mage " + ((Mage) creatures.get(i)).getNom() + " que t'as attaqué veut répondre avec un autre attaque");
                            ((Mage) creatures.get(i)).reCombattre(j.getPersonnage());
                        } else if (creatures.get(i) instanceof Loup) {
                            ((Loup) creatures.get(i)).combattre(j.getPersonnage());
                        }
                    }
                    j.affiche();  //On montre les points de vie après le combat
                    creatures.get(i).affiche();
                    this.checkVieCreature(i); //On enleve la creature si elle possède des points de vie negatives
                }
            }
        } else if (choix.equals("S")) {
            System.out.println("Inserez 1 si vous voulez choisir le nom du ficher\n"
                    + "Inserez 2 pour sauvegarder avec um nom automatique");
            String choix2 = "";
            choix2 = scanner.nextLine();
            while(!(choix2.equals("1")||choix2.equals("2"))){
                 System.out.println("Inserez 1 si vous voulez choisir le nom du ficher\n"
                        + "Inserez 2 pour sauvegarder avec um nom automatique");
                 choix2 = scanner.nextLine();
            }

            

            if (choix2.equals("1")) {
                System.out.println("Nom du ficher :");
                String fileName = scanner.next();

                File tempFile = new File(".\\" + fileName + ".txt");
                boolean exists = tempFile.exists();
                while (exists) {
                    System.out.println("File already exists, please chose another name: ");
                    fileName = scanner.next();
                    File tempFile2 = new File(".\\" + fileName + ".txt");
                    exists = tempFile2.exists();
                }
                fileName = fileName + ".txt";
                SauvegardePartie sauv = new SauvegardePartie(fileName);
                sauv.sauvagerderPartie(this);

            } else {
                SauvegardePartie sauv = new SauvegardePartie();
                sauv.sauvagerderPartie(this);
                //acho que o programa deveria encerrar depois de salvar o jogo

            }
        } else if (choix.equals("E")) {
            return false;
        }

        //À la fin de chaque tour, il faut parcourrir la liste de Nourritures du Personnage
        for (int i = 0; i < j.getPersonnage().getNourr().size(); i++) {
            j.getPersonnage().getNourr().get(i).setChange(j.getPersonnage());
        }
        //Vérifie si il y a des nourriture avec durée = 0
        j.getPersonnage().removeNourriture();

        if (this.checkVieJoueur()) {
            System.out.println("Vous êtes mort!");
            return false;
        }

        if (this.checkFinDePartie()) {
            return false;
        }

        return true;

    }

    public boolean checkFinDePartie() {
        if (this.creatures.size() == 0) {
            System.out.println("Vous avez gagné le jeu! Félicitations!");
            return true;
        }
        return false;
    }

    /**
     * Montre tous les informations des objets qui ont été créés.
     */
    public void afficheMondeElementsJeu() {
        int i, j;

        for (i = 0; i < creatures.size(); i++) {
            creatures.get(i).affiche();
        }

        for (i = 0; i < objets.size(); i++) {
            objets.get(i).affiche();
        }

        this.j.affiche();

    }

    public void afficheMondeMatrice() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                System.out.print(monde[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public void afficheMondeEspecial() {
        System.out.println("Pour bien comprandre les coordonées da la carte de jeu, voici l'exemple d'un monde de dimension 5");
        System.out.println("Les numeros de la première ligne sont les valuers de la coordonée Y, donc chaque numero corresponde à une colonne");
        System.out.println("Et le numero à la fin de chaque ligne, corresponde à la valeur de la coordonée X, donc chaque numero correponde à une ligne");
        for (int k = 0; k < 5; k++) {
            System.out.print(k + " ");
        }

        System.out.print("\n");

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("* ");
            }
            System.out.print(i);
            System.out.print("\n");
        }
        System.out.println("Voilà! Le monde de jeu :");
    }

    /**
     * La méthode suivante, en regardant la matrice monde, valide une position,
     * autremante dit, la méthode dit s'il y a d'autre personnage à une distance
     * plus petite que 3 unités
     *
     * @param x coordonée X de la case où le personnage veut aller
     * @param y coordonée Y de la case où le personnage veut aller
     * @return la méthode renvoye false s'il y a un personnage dans la case, ou
     * a moins de 3 unités de distance, et renvoye true sinon.
     */
    public boolean validationPosition(int x, int y) {
        int alpha;
        int beta;
        alpha = x + y;
        beta = Math.min(x, y);
        alpha = alpha - beta;
        int bsAlpha = 0;
        int bsBeta = 0;
        int biAlpha = 0;
        int biBeta = 0;

        if (alpha == x) {
            if (beta >= 2 && alpha <= ROW - 3) {
                for (int i = 0; i <= 2; i++) {
                    for (int j = 0; j <= 2; j++) {
                        if (monde[alpha + i][beta + j] == 1 || monde[alpha - i][beta - j] == 1 || monde[alpha - i][beta + j] == 1 || monde[alpha + i][beta - j] == 1) {
                            return false;
                        }
                    }
                }
            } else {
                if (alpha > ROW - 3) {
                    bsAlpha = ROW - 1 - alpha;
                    biAlpha = 2;
                    if (beta > ROW - 3) {
                        bsBeta = ROW - 1 - beta;
                        biBeta = 2;
                    } else if (beta < 2) {
                        bsBeta = 2;
                        biBeta = beta;
                    } else {
                        bsBeta = 2;
                        biBeta = 2;
                    }
                } else if (alpha < 2) {
                    bsAlpha = 2;
                    biAlpha = alpha;
                    bsBeta = 2;
                    biBeta = beta;
                } else if (2 <= alpha && alpha <= ROW - 3) {
                    bsAlpha = 2;
                    biAlpha = 2;
                    bsBeta = 2;
                    biBeta = beta;
                }
                for (int i = 0; i <= bsAlpha; i++) {
                    for (int j = 0; j <= bsBeta; j++) {
                        if (monde[alpha + i][beta + j] == 1) {
                            return false;
                        }
                    }
                }
                for (int i = 0; i <= biAlpha; i++) {
                    for (int j = 0; j <= biBeta; j++) {
                        if (monde[alpha - i][beta - j] == 1) {
                            return false;
                        }
                    }
                }
                for (int i = 0; i <= bsAlpha; i++) {
                    for (int j = 0; j <= biBeta; j++) {
                        if (monde[alpha + i][beta - j] == 1) {
                            return false;
                        }
                    }
                }
                for (int i = 0; i <= biAlpha; i++) {
                    for (int j = 0; j <= bsBeta; j++) {
                        if (monde[alpha - i][beta + j] == 1) {
                            return false;
                        }
                    }
                }
            }
        } else if (alpha == y) {
            if (beta >= 2 && alpha <= ROW - 3) {
                for (int i = 0; i <= 2; i++) {
                    for (int j = 0; j <= 2; j++) {
                        if (monde[beta + j][alpha + i] == 1 || monde[beta - j][alpha - i] == 1 || monde[beta + j][alpha - i] == 1 || monde[beta - j][alpha + i] == 1) {
                            return false;
                        }
                    }
                }
            } else {
                if (alpha > ROW - 3) {
                    bsAlpha = ROW - 1 - alpha;
                    biAlpha = 2;
                    if (beta > ROW - 3) {
                        bsBeta = ROW - 1 - beta;
                        biBeta = 2;
                    } else if (beta < 2) {
                        bsBeta = 2;
                        biBeta = beta;
                    } else {
                        bsBeta = 2;
                        biBeta = 2;
                    }
                } else if (alpha < 2) {
                    bsAlpha = 2;
                    biAlpha = alpha;
                    bsBeta = 2;
                    biBeta = beta;
                } else if (2 <= alpha && alpha <= ROW - 3) {
                    bsAlpha = 2;
                    biAlpha = 2;
                    bsBeta = 2;
                    biBeta = beta;
                }
                for (int i = 0; i <= bsAlpha; i++) {
                    for (int j = 0; j <= bsBeta; j++) {
                        if (monde[beta + j][alpha + i] == 1) {
                            return false;
                        }
                    }
                }
                for (int i = 0; i <= biAlpha; i++) {
                    for (int j = 0; j <= biBeta; j++) {
                        if (monde[beta - j][alpha - i] == 1) {
                            return false;
                        }
                    }
                }
                for (int i = 0; i <= bsAlpha; i++) {
                    for (int j = 0; j <= biBeta; j++) {
                        if (monde[beta - j][alpha + i] == 1) {
                            return false;
                        }
                    }
                }
                for (int i = 0; i <= biAlpha; i++) {
                    for (int j = 0; j <= bsBeta; j++) {
                        if (monde[beta + j][alpha - i] == 1) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public void checkVieCreature(int i) {
        if (this.creatures.get(i).getPtVie() <= 0) {
            this.monde[this.creatures.get(i).getPos().getX()][this.creatures.get(i).getPos().getY()] = 0;
            this.elementsDeJeu.remove(creatures.get(i));
            this.creatures.remove(i);
        }
    }

    public boolean checkVieJoueur() {
        if (this.j.getPersonnage().getPtVie() <= 0) {
            return true;
        } else {
            return false;
        }
    }
}
