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
public class JeuDePlateau {
    
    public Joueur jouerPartie() {
        Coup c;
        while(!partieTerminee()) {
            c=joueurCourant.genererCoup(plateau);
            if (coupValide(c)) {
                plateau.jouer(c);
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
