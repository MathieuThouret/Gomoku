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
public class Position {

    int x;
    int y;

    public Position(int x1, int y1) {
        x = x1;
        y = y1;
    }

    public String toString() {
        return "x=" + x + " ; y=" + y;
    }

}
