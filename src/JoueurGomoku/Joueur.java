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
public abstract class Joueur {
    int id;
    
    public Joueur(int id){
        this.id=id;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setId(int _id){
        this.id=_id;
    }
   
    abstract public Coup genererCoup(Plateau etatJeu);
    
}
