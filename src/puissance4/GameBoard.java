/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puissance4;

import java.util.ArrayList;

/**
 *
 * @author Thibaud
 */
public class GameBoard {

    int longueur;
    int largeur;
    int[][] etatPlateau;
    ArrayList<Turn> historique;

    public GameBoard(int longu, int largu) {
        longueur = longu;
        largeur = largu;
        etatPlateau = new int[longueur + 1][largeur + 1];
        historique = new ArrayList<Turn>();
        initialiser();
    }

    public ArrayList<Turn> getHistorique() {
        return historique;
    }

    public int getEtatPlateau(int x, int y) {
        return etatPlateau[x][y];
    }

    //toutes les cases à 0
    public void initialiser() {
        int i, j;
        for (i = 1; i <= longueur; i++) {
            for (j = 1; j <= largeur; j++) {
                etatPlateau[i][j] = 0;
            }
        }
    }

    //initialiser avec une liste de coups prédéfinis
    public void initialiser(ArrayList<Turn> turns) {
        int i, j, x = 0;
        Turn turn;
        for (i = 1; i <= longueur; i++) {
            for (j = 1; j <= largeur; j++) {
                etatPlateau[i][j] = 0;
            }
        }
        for (i = 0; i < turns.size(); i++) {
            turn = turns.get(x);
            jouer(turn);
            x++;
        }
    }

    //vérifie si le coup n'est pas sur une case déjà prise et si il est bien sur le plateau
    public boolean verifierCoup(Turn turn) {
        boolean ok = true;
        if ((turn.pos.x > longueur) || (turn.pos.y > largeur)) {
            ok = false;
        } else if ((turn.pos.x <= 0) || (turn.pos.y <= 0)) {
            ok = false;
        } else if (etatPlateau[turn.pos.x][turn.pos.y] != 0) {
            ok = false;
        }
        return ok;

    }

    //pose le coup sur le plateau
    public void jouer(Turn turn) {
        etatPlateau[turn.pos.x][turn.pos.y] = turn.id;
        historique.add(turn);
    }

    //annule le dernier coup joué
    public Turn annuler() {
        Turn der;
        der = historique.get(historique.size() - 1);
        etatPlateau[der.pos.x][der.pos.y] = 0;
        return der;
    }

    //retourn une liste de tous les coups du joueur id
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

    //renvoi 0 si la case (x,y) est hors du plateau, renvoi l'id de la case sinon
    public int getNoDebord(int x, int y) {
        if ((x > longueur) || (y > largeur) || (x < 1) || (y < 1)) {
            return 0;
        } else {
            return etatPlateau[x][y];
        }
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
        for (i = 1; i <= longueur; i++) {
            for (j = 1; j <= largeur; j++) {
                if (etatPlateau[j][i] == 0) {
                    strPlat = strPlat + "◌ ";
                } else if (etatPlateau[j][i] == 1) {
                    strPlat = strPlat + "● ";

                } else {
                    strPlat = strPlat + "○ ";
                }
            }
            strPlat = strPlat + "\n";
        }
        return strPlat;
    }

    public int getDernierId() {
        Turn t;
        if (!historique.isEmpty()) {
            t = historique.get(historique.size() - 1);
            return t.getId();
        } else {
            return 0;
        }
    }

    public Turn getDernierCoup() {
        Turn t;
        if (!historique.isEmpty()) {
            t = historique.get(historique.size() - 1);
            return t;
        } else {
            return null;
        }
    }

}
