/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JeuDePlateau;

import JoueurGomoku.*;
import GomokuPack.*;

/**
 *
 * @author mathieu
 */
public abstract class JeuDePlateau {
    
    public abstract void setJoueur(int ordre, Joueur joueur);
    
    public abstract void setPlateau(Plateau plateau);
    
    
}
