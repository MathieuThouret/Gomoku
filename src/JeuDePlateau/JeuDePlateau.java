/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JeuDePlateau;

import JoueurGomoku.*;
import GomokuPack.*;
import JeuDeGomoku.*;

/**
 *
 * @author mathieu
 */
public abstract class JeuDePlateau {
    
    Joueur joueurCourant;
    Joueur[] joueurs;
    Plateau plateau;
    
    public abstract boolean partieTerminee();
    
    public abstract boolean coupValide(Coup c);
    
    public abstract void setJoueur(int ordre,Joueur joueur);
    
    public abstract void setPlateau(Plateau plateau);
    
    public Joueur joueurSuivant(){
        //cas où il y a un joueur courant
        if (joueurCourant != null) {
            if (joueurCourant == joueurs[0]) {
                return joueurs[1];
            } else {
                return joueurs[0];
            }
        } //cas où il n'y a pas de joueur courant mais un coup dans l'historique
        else if (plateau.getDernierId() != 0) {
            if (joueurs[0].getId() == plateau.getDernierId()) {
                return joueurs[0];
            } else {
                return joueurs[1];
            }
        } else {
            return joueurs[0];
        }
    }
    
    public Joueur jouerPartie() {
        
        Coup c;
        joueurCourant = joueurSuivant();
        while(!partieTerminee()) {
            c=joueurCourant.genererCoup(plateau);
            if (coupValide(c)) {
                plateau.jouer(c);
                System.out.println(plateau);
                joueurCourant=joueurSuivant();
            }
            else {
                System.out.println("coup invalide \n");
            }
        }
        // à la sortie de la boucle on inverse le joueur courant pour pouvoir retourner le joueur gagnant
        //(car on change de joueur directement après chaque coup, le joueur courant est le joueur qui doit jouer et non celui qui a jouer)
        joueurCourant=joueurSuivant();
        return joueurCourant;
        
    }
    
}
