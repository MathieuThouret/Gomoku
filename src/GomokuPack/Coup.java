/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GomokuPack;

/**
 *
 * @author p1307394
 */
public class Coup {

    int id;
    protected Position pos = new Position(0, 0);

    public Coup(int idc, Position posc) {
        id = idc;
        pos = posc;
    }

    public String toString() {
        return pos.toString() + " ; " + "id=" + id;
    }
    
    public void setCoupPosition(Position posc){
        pos=posc;
    }
}
