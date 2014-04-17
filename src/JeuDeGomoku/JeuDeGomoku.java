/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JeuDeGomoku;

import java.util.ArrayList;
import GomokuPack.*;
import JeuDePlateau.JeuDePlateau;
import JoueurGomoku.*;

public class JeuDeGomoku extends JeuDePlateau {

    Joueur joueurCourant;
    Joueur[] joueurs;
    Plateau plateau;

    public JeuDeGomoku() {
        //initialisation des 2 joueurs

        //le joueur courant est initialisé a la valeur null pour faciler le test dans joueurSuivant()
        joueurCourant = null;

        //initialisation du plateau
        Plateau plateau = new Plateau(19, 19);
    }

    //permet d'attribuer un id (et donc un ordre de passage ) à un joueur
    public void setJoueur(int ordre,Joueur joueur) {
        joueurs[ordre]=joueur;
    }

    //réinitialisation du plateau
    public void setPlateau(Plateau plateau) {
        plateau.initialiser();
    }

    

    public boolean coupValide(Coup c) {
        boolean b = false;
        // On vérifie si le coup est dans le plateau et si la case est libre
        if (plateau.verifierCoup(c)) {
            // On vérifie si le case jouée est adjacente à une case occupée;

            if (plateau.getNoDebord(c.getPosition().x - 1, c.getPosition().y - 1) != 0) {
                b = true;
            }
            if (plateau.getNoDebord(c.getPosition().x - 1, c.getPosition().y - 1) != 0) {
                b = true;
            }
            if (plateau.getNoDebord(c.getPosition().x - 1, c.getPosition().y) != 0) {
                b = true;
            }
            if (plateau.getNoDebord(c.getPosition().x - 1, c.getPosition().y + 1) != 0) {
                b = true;
            }
            if (plateau.getNoDebord(c.getPosition().x, c.getPosition().y - 1) != 0) {
                b = true;
            }
            if (plateau.getNoDebord(c.getPosition().x, c.getPosition().y + 1) != 0) {
                b = true;
            }
            if (plateau.getNoDebord(c.getPosition().x + 1, c.getPosition().y - 1) != 0) {
                b = true;
            }
            if (plateau.getNoDebord(c.getPosition().x + 1, c.getPosition().y) != 0) {
                b = true;
            }
            if (plateau.getNoDebord(c.getPosition().x + 1, c.getPosition().y + 1) != 0) {
                b = true;
            }

        }
        return b;
    }

    //Retourne vrai si la partie est terminée, 0 sinon
    public boolean partieTerminee() {

        //On vérifier que les joueurs n'ont pas joué leurs 60 pièces
        if ((plateau.etatId(joueurs[0].getId()).size() == 60) && (plateau.etatId(joueurs[1].getId()).size() == 60)) {
            return true;
        }
        
        //On vérifie qu'un coup ait déjà été joué.
        Coup c = plateau.getDernierCoup();
        if(c==null)
        {
            return false;
        }
        //On vérifie si le dernier coup joué est gagant, pour cela (on prend l'exemple du cas horizontal) on regarde les 4 cases à gauche de la case jouée et 
        //les 4 cases à droite, si 5 cases alignés ont le même id, alors le joueur a gagné la partie.
        //Exemple (x case du joueur, X case jouée):
        //ooxxXxxoo gagnant
        //xxxxXoooo gagnant
        //xxoxXxooo perdant
        //vérification horizontale. 
        
        //on incrémente cpt à chaque fois qu'il y a une piece du plateau sur la ligne qui a le meme numéro que l'id du joueur qui vient de jouer
        //si jamais on n'a pas le meme, on le remet a 0
        //si cpt = 5 alors on a 5 pieces d'affilé qui ont été joué par la meme personne, donc le joueur a gagné.
        
        int cpt = 0;
        for (int i = 0; i < 9; i++) {
            if (plateau.getNoDebord(c.getPosition().x + 4 - i, c.getPosition().y) == c.getId()) {
                cpt = cpt + 1;
                if (cpt == 5) {
                    return true;
                }
            } else {
                cpt = 0;
            }
        }

        cpt = 0;
        //vérification verticale
        for (int i = 0; i < 9; i++) {
            if (plateau.getNoDebord(c.getPosition().x, c.getPosition().y + 4 - i) == c.getId()) {
                cpt = cpt + 1;
                if (cpt == 5) {
                    return true;
                } else {
                    cpt = 0;
                }
            }
        }

        cpt = 0;
        //vérification diagonale /
        for (int i = 0; i < 9; i++) {
            if (plateau.getNoDebord(c.getPosition().x + 4 - i, c.getPosition().y - 4 + i) == c.getId()) {
                cpt = cpt + 1;
                if (cpt == 5) {
                    return true;
                } else {
                    cpt = 0;
                }
            }
        }

        cpt = 0;
        //verification diagonale \
        for (int i = 0; i < 9; i++) {
            if (plateau.getNoDebord(c.getPosition().x + 4 - i, c.getPosition().y + 4 - i) == c.getId()) {
                cpt = cpt + 1;
                if (cpt == 5) {
                    return true;
                } else {
                    cpt = 0;
                }
            }
        }
        return false;
    }
    
    
}
