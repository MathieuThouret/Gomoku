/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JeuDeGomoku;

import java.util.ArrayList;
import GomokuPack.*;
import JoueurGomoku.*;

public class JeuDeGomuku {

    Joueur joueurCourant;
    Joueur[] joueurs;
    Plateau plateau;

    public JeuDeGomuku() {
        //initialisation des 2 joueurs
        joueurs[0] = setJoueur(1);
        joueurs[1] = setJoueur(2);

        //joueur 0 commence par défaut
        joueurCourant = joueurs[0];

        //initialisation du plateau
        setPlateau(19,19);
    }

    //permet d'attribuer un id (et donc un ordre de passage ) un joueur
    public Joueur setJoueur(int ordre){
        Joueur joueur = new JoueurHumain(ordre);
        return joueur;
    }

    //réinitialisation du plateau
    public void setPlateau(int longueur, int largeur) {
        Plateau plateau = new Plateau(longueur,largeur);
        plateau.initialiser();
    }

    //Change le joueur courant
    public Joueur joueurSuivant() {
        if (joueurCourant == joueurs[0]) {
            return joueurs[1];
        } else {
            return joueurs[0];
        }

    }

    //Retourne vrai si la partie est terminée, 0 sinon
    public boolean partieTerminee(Coup c) {
        
        //On vérifier que les joueurs n'ont pas joué leurs 60 pièces
        if ((plateau.etatId(joueurs[0].getId()).size() == 60) && (plateau.etatId(joueurs[1].getId()).size() == 60)) {
            return true;
        }
        
        //On vérifie si les joueurs ont gagné, on parcourt leur liste de point, et pour chacun on vérifie si le premier point peut vérifier un des motifs suivant
        // X point controler :
        //Xxxxx Xoooo Xoooo ooooX
        //ooooo xoooo oxooo oooxo
        //ooooo xoooo ooxoo ooxoo
        //ooooo xoooo oooxo oxooo
        //ooooo xoooo oooox xoooo
        
        //vérification horizontale. 
        int cpt=0;
        //on incrémente cpt à chaque fois qu'il y a une piece du plateau sur la ligne qui a le meme numéro que l'id du joueur qui vient de jouer
        //si jamais on n'a pas le meme, on le remet a 0
        //si cpt = 5 alors on a 5 pieces d'affilé qui ont été joué par la meme personne, donc le joueur a gagné.
        for (int i = 0; i<9;i++){
            if (plateau.getEtatPlateau(c.getPosition().x+4-i, c.getPosition().y) == c.getId()){
                cpt=cpt+1;
                if (cpt == 5){
                    return true;//************penser à gérer pour les bords du tableau*************
                }
            }
            else {
                cpt=0;
            }
        }
        
        //vérification verticale
        for (int i = 0; i < 9; i++){
            if (plateau.getEtatPlateau(c.getPosition().x,c.getPosition().y+4-i)==c.getId()){
                cpt = cpt + 1;
                if (cpt == 5){
                    return true;
                }
                else {
                    cpt=0;
                }
            }
        }
        
        //vérification diagonale /
        for (int i = 0; i < 9; i++){
            if (plateau.getEtatPlateau(c.getPosition().x+4-i,c.getPosition().y-4+i)==c.getId()){
                cpt = cpt + 1;
                if (cpt == 5){
                    return true;
                }
                else {
                    cpt=0;
                }
            }
        }
        
        //verification diagonale \
        for (int i = 0; i < 9; i++){
            if (plateau.getEtatPlateau(c.getPosition().x+4-i,c.getPosition().y+4-i)==c.getId()){
                cpt = cpt + 1;
                if (cpt == 5){
                    return true;
                }
                else {
                    cpt=0;
                }
            }
        }
    return false;
    }

    private boolean verifligne(int id) {
        boolean fin = false;
        ArrayList<Position> listcoup = plateau.etatId(id);
        Position posCour;
        int i;
        for (i = 0; i < listcoup.size(); i++) {
           posCour=listcoup.get(i);
           if((plateau.getNoDebord(posCour.x+1,posCour.y)!=id)
                   ||(plateau.getNoDebord(posCour.x+2,posCour.y)!=id)
                   ||(plateau.getNoDebord(posCour.x+3,posCour.y)!=id)
                   ||(plateau.getNoDebord(posCour.x+4,posCour.y)!=id)){
               
           }
           
        }

        return fin;
    }

    private boolean verifcolonne(int id) {
        boolean fin = false;

        return fin;
    }

    private boolean verifdiag1(int id) {
        boolean fin = false;

        return fin;
    }

    private boolean veriflignediag2(int id) {
        boolean fin = false;

        return fin;
    }
}
