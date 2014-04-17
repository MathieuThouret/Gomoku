/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JeuDePlateau;
import GomokuPack.Coup;
import java.util.ArrayList;

/**
 *
 * @author mathieu
 */
public interface JeuDePlateauFactory {
    
    public JeuDePlateau CreerPartieHumainVSHumain (ArrayList<Coup> situation);
    
    public JeuDePlateau CreerPartieHumainVSAleatoire (ArrayList<Coup> situation);
    
    public JeuDePlateau CreerPartieAleatoireVSAleatoire (ArrayList<Coup> situation);
}
