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
        setJoueur(1, joueurs[0]);
        setJoueur(2, joueurs[1]);

        //joueur 0 commence par défaut
        joueurCourant = joueurs[0];

        //initialisation du plateau
        Plateau plateau = new Plateau(19, 19);

    }

    //permet d'attribuer un id (et donc un ordre de passage ) un joueur
    public void setJoueur(int ordre, Joueur joueur) {
        joueur.setId(ordre);
    }

    //réinitialisation du plateau
    public void setPlateau(Plateau plateau) {
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
    public boolean partieTerminee() {
        boolean fin = false;
        //On vérifier que les joueurs n'ont pas joué leur 60 pièces
        if ((plateau.etatId(joueurs[0].getId()).size() == 60) && (plateau.etatId(joueurs[1].getId()).size() == 60)) {
            fin = true;
        }

        //On vérifie si les joueurs ont gagné, on parcourt leur liste de point, et pour chacun on vérifie si le premier point peut vérifier un des motifs suivant
        // X point controler :
        //Xxxxx Xoooo Xoooo ooooX
        //ooooo xoooo oxooo oooxo
        //ooooo xoooo ooxoo ooxoo
        //ooooo xoooo oooxo oxooo
        //ooooo xoooo oooox xoooo
        return fin;
    }

    private boolean verifligne(int id) {
        boolean fin = false;
        ArrayList listcoup = plateau.etatId(id);
        Position posCour;
        int i;
        for (i = 0; i < listcoup.size(); i++) {
           posCour=listcoup.get(i);
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
