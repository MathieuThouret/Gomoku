/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JoueurGomoku;
import java.math.*;

/**
 *
 * @author mathieu
 */
public class Utilitaire {
    public static int monRandom (int min, int max){
       java.util.Random r = new java.util.Random();
        return r.nextInt(max-min)+ min;
    }
    
    /*public static void main(String[] args){
        int a = monRandom(1,10);
        int b = monRandom(30,34);
        System.out.println(a);
        System.out.println(b);
    }*/
}
