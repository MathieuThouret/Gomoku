/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JoueurGomoku;

import GomokuPack.*;

/**
 *
 * @author mathieu
 */
public class JoueurAleatoire extends Joueur {

    public JoueurAleatoire(int id) {
        super(id);
    }

    //Génère un coup aléatoirement sur le plateau 'etatJeu' seulement si la case est libre.
    @Override
    public Coup genererCoup(Plateau etatJeu) {
        int x = Utilitaire.monRandom(1, etatJeu.getLargeur()+2);
        int y = Utilitaire.monRandom(1, etatJeu.getLongueur()+2);
        Coup c=new Coup(id, new Position(x, y));
        while (!etatJeu.verifierCoup(c)) {
            x = Utilitaire.monRandom(1, etatJeu.getLargeur()+2);
            y = Utilitaire.monRandom(1, etatJeu.getLongueur()+2);
            c.setPosition(new Position(x,y));
        }
        return c;
    }
}
