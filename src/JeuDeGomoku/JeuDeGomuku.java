/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JeuDeGomoku;
import GomokuPack.*;

public class JeuDeGomuku {

    public JeuDeGomuku()
            {
              
            }
    
    //permet d'attribuer un id 
    public void setJoueur(int ordre, Joueur joueur)
    {
        joueur.id=ordre;
    }
}
