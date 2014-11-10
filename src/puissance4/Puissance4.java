/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package puissance4;

/**
 *
 * @author Thibaud
 */
public class Puissance4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GameBoard game = new GameBoard(5,5);
        System.out.println(game.toString());
        game.jouer(new Turn(1, new Position (1,1)));
        game.jouer(new Turn(2, new Position (1,5)));
        System.out.println(game.toString());
    }
    
}
