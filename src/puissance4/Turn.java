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
public class Turn {

    int id;
    protected Position pos = new Position(0, 0);

    public Turn(int idc, Position posc) {
        id = idc;
        pos = posc;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public Position getPosition(){
        return this.pos;
    }
    
    public void setPosition(Position pos){
        this.pos=pos;
    }

    public String toString() {
        return pos.toString() + " ; " + "id=" + id;
    }
}
