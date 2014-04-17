/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GomokuPack;

import java.util.ArrayList;
import JoueurGomoku.*;
import JeuDeGomoku.*;
import JeuDePlateau.JeuDeGomokuFactory;
import JeuDePlateau.JeuDePlateau;

/**
 *
 * @author p1307394
 */
public class Gomoku {

    public static void testfun() {
        Position pos;
        pos = new Position(1, 2);
        System.out.println(pos);

        Coup coup;
        coup = new Coup(1, pos);
        System.out.println(coup);

        Plateau plat;
        plat = new Plateau(5, 5);
        System.out.println(plat);

        plat.jouer(coup);
        System.out.println(plat);

        ArrayList posid;
        posid = plat.etatId(1);
        System.out.println(posid);

        System.out.println(plat.longueur);
        System.out.println(plat.largeur);

        System.out.println(plat.historique);

        ArrayList listcoup = new ArrayList<Coup>();
        Position pos1 = new Position(3, 2);
        Position pos2 = new Position(4, 4);
        Coup coup1 = new Coup(1, pos1);
        Coup coup2 = new Coup(2, pos2);
        listcoup.add(coup1);
        listcoup.add(coup2);
        Plateau plat2 = new Plateau(5, 5);
        plat2.initialiser(listcoup);
        System.out.println(plat2);
        plat2.annuler();
        System.out.println(plat2);

    }

    public static void testJoueurAleatoire() {
        Plateau plat = new Plateau(5, 5);
        plat.initialiser();
        Joueur j1 = new JoueurAleatoire(1);
        Joueur j2 = new JoueurAleatoire(2);
        Coup c1 = j1.genererCoup(plat);
        Coup c2 = j2.genererCoup(plat);
        System.out.println(c1);
        System.out.println(c2);
        plat.jouer(c1);
        plat.jouer(c2);
        System.out.println(plat.toString());
    }

    public static void testJoueurAleaVsHumain() {
        Plateau plat = new Plateau(5, 5);
        plat.initialiser();
        Joueur jA = new JoueurAleatoire(1);
        Joueur jH = new JoueurHumain(2);
        Coup cA = jA.genererCoup(plat);
        Coup cH = jH.genererCoup(plat);
        plat.jouer(cA);
        plat.jouer(cH);
        System.out.println(plat.toString());
    }

    public static void testPresentation() {
        JeuDeGomokuFactory factory = new JeuDeGomokuFactory();
        JeuDePlateau JDP = new JeuDeGomoku();
        ArrayList<Coup> situation = new ArrayList<Coup>();
        
        //--1--
        Plateau plateau = new Plateau(9,9);
        plateau.initialiser();
        System.out.println(plateau);
        
        //--2--
        Position pos = new Position(8,9);
        Coup coup = new Coup(1,pos);
        plateau.jouer(coup);
        System.out.println(plateau);
       
        pos = new Position(1,1);
        coup = new Coup(2,pos);
        plateau.jouer(coup);       
        System.out.println(plateau);

        //--3--
        Joueur jHum = new JoueurHumain(1);
        Joueur jIA = new JoueurAleatoire(2);        
        plateau.jouer(jHum.genererCoup(plateau));
        System.out.println(plateau);
        
        plateau.jouer(jIA.genererCoup(plateau));
        System.out.println(plateau);
        
        //--4--
        situation = plateau.getHistorique();
        JDP = factory.CreerPartieHumainVSAleatoire(situation);
        JDP.jouerPartie();
        
        
    }
    public static void main(String[] args) {
        testPresentation();
    }

}
