/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JeuDePlateau;

import GomokuPack.*;
import JoueurGomoku.*;
import JeuDeGomoku.*;
import java.util.ArrayList;

/**
 *
 * @author mathieu
 */
public class JeuDeGomokuFactory implements JeuDePlateauFactory {
    
    @Override
    public JeuDePlateau CreerPartieHumainVSHumain(ArrayList<Coup> situation) {
        JeuDePlateau JDP = new JeuDeGomoku();
        JDP.setJoueur(0, new JoueurHumain(1));
        JDP.setJoueur(1, new JoueurHumain(2));
        JDP.setPlateau(new Plateau(9,9));
        JDP.plateau.initialiser(situation);
        return JDP;
    }

    @Override
    public JeuDePlateau CreerPartieHumainVSAleatoire(ArrayList<Coup> situation) {
        JeuDePlateau JDP = new JeuDeGomoku();
        JDP.setJoueur(0, new JoueurHumain(1));
        JDP.setJoueur(1, new JoueurAleatoire(2));
        JDP.plateau = new Plateau(9,9);
        JDP.plateau.initialiser(situation);
        return JDP;
    }

    @Override
    public JeuDePlateau CreerPartieAleatoireVSAleatoire(ArrayList<Coup> situation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
