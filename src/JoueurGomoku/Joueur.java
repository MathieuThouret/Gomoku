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
public class Joueur {
    int _id;
    
    public Joueur(int _id){
        this._id=_id;
    }
    
    public int getId(){
        return this._id;
    }
    //Génère un coup aléatoirement sur le plateau 'etatJeu' seulement si la case est libre.
    public Coup genererCoup(Plateau etatJeu){
        int x = Utilitaire.monRandom(1,etatJeu.getLargeur());
        int y = Utilitaire.monRandom(1,etatJeu.getLongueur());
        return new Coup(this._id, new Position(x,y));
    }
    
}
