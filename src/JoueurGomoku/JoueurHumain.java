/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JoueurGomoku;

import GomokuPack.*;
import java.util.Scanner;

/**
 *
 * @author mathieu
 */
public class JoueurHumain extends Joueur {

    public JoueurHumain(int id) {
        super(id);
    }

    @Override
    public Coup genererCoup(Plateau etatJeu) {
        System.out.println("Veuillez entrer la position du coup");
        Scanner sc = new Scanner(System.in);
        System.out.println("x:");
        int x = sc.nextInt();
        System.out.println("y:");
        int y = sc.nextInt();
        Coup c = new Coup(id, new Position(x, y));
        while (!etatJeu.verifierCoup(c)) {
            System.out.println("Le coup n'est pas disponible, recommencez");
            x = sc.nextInt();
            y = sc.nextInt();
            c = new Coup(id, new Position(x, y));
        }
        return c;
    }
}
