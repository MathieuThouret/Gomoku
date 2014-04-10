/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GomokuPack;

/**
 *
 * @author p1310207
 */
public class Position {
    public int x;
    public int y;
    
    public Position(int a, int b){
        x=a;
        y=b;
    }
    
    public String toString(){
        return "x = "+x+" y= "+y;
    }
}
