/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GomokuPack;
import java.util.ArrayList;
/**
 *
 * @author p1307394
 */
public class Gomoku {

    /**
     * @param args the command line arguments
     */
    public static void testfun(){
        Position pos;
        pos = new Position(1, 2);
        System.out.println(pos);

        Coup coup;
        coup = new Coup(1, pos);
        System.out.println(coup);

        Plateau plat;
        plat = new Plateau(5, 5);
        System.out.println(plat);

        plat.jouer(coup);
        System.out.println(plat);

        ArrayList posid;
        posid = plat.etatId(1);
        System.out.println(posid);

        System.out.println(plat.longueur);
        System.out.println(plat.largeur);
        
        System.out.println(plat.historique);
        
        ArrayList listcoup= new ArrayList<Coup>();
        Position pos1 = new Position(3, 2);
        Position pos2 = new Position(4, 4);
        Coup coup1 = new Coup(1, pos1);
        Coup coup2 = new Coup(2, pos2);
        listcoup.add(coup1);
        listcoup.add(coup2);
        Plateau plat2=new Plateau(5,5);
        plat2.initialiser(listcoup);
        System.out.println(plat2);
        plat2.annuler();
        System.out.println(plat2);
        
    }
    
    public static void main(String[] args) {
        testfun();
        SimulateurDeJeu.Simuler();
    }

}
