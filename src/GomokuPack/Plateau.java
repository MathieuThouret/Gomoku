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
public class Plateau {

    int longueur;
    int largeur;
    int[][] etatPlateau;
    ArrayList<Coup> historique;

    public Plateau(int longu, int largu) {
        longueur = longu;
        largeur = largu;
        etatPlateau = new int[longueur + 1][largeur + 1];
        historique = new ArrayList<Coup>();
        initialiser();
    }

    public void initialiser() {
        int i, j;
        for (i = 1; i <= longueur; i++) {
            for (j = 1; j <= largeur; j++) {
                etatPlateau[i][j] = 0;
            }
        }
    }

    public void initialiser(ArrayList<Coup> coups) {
        int i, j, x = 0;
        Coup coup;
        for (i = 1; i <= longueur; i++) {
            for (j = 1; j <= largeur; j++) {
                etatPlateau[i][j] = 0;
            }
        }
        for (i = 0; i < coups.size(); i++) {
            coup = coups.get(x);
            jouer(coup);
            x++;
        }
    }

    public boolean verifierCoup(Coup coup) {
        boolean ok = true;
        if ((coup.pos.x > longueur) || (coup.pos.y > largeur)) {
            ok = false;
        } else if (etatPlateau[coup.pos.x][coup.pos.y] != 0) {
            ok = false;
        }
        return ok;

    }

    public void jouer(Coup coup) {
        if (verifierCoup(coup)) {
            etatPlateau[coup.pos.x][coup.pos.y] = coup.id;
            historique.add(coup);
        } else {
            System.out.println("coup invalide \n");
        }
    }

    public Coup annuler() {
        Coup der;
        der = historique.get(historique.size() - 1);
        etatPlateau[der.pos.x][der.pos.y] = 0;
        return der;
    }

    public ArrayList etatId(int id) {
        ArrayList posid = new ArrayList();

        int i, j;
        Position pos;
        for (i = 0; i < longueur; i++) {
            for (j = 0; j < largeur; j++) {
                if (etatPlateau[i][j] == id) {
                    pos = new Position(i, j);
                    posid.add(pos);
                }
            }
        }
        return posid;

    }

    public int getLongueur() {
        return longueur;
    }

    public int getLargeur() {
        return largeur;
    }

    public String toString() {
        String strPlat;
        strPlat = "";
        int i, j;
        for (i = 0; i < longueur; i++) {
            for (j = 0; j < largeur; j++) {
                strPlat = strPlat + etatPlateau[i][j] + " ";
            }
            strPlat = strPlat + "\n";
        }
        return strPlat;
    }
}
