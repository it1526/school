/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

/**
 *
 * @author student
 */
public class Hokejista extends Sportsman {
    public enum Position {
        goalkeeper, forward, defendceman
    }
    private Position position;
    private int goals = 0;
    private int assists = 0;
    

    public Hokejista(String jmeno, int energy) {
        super(jmeno, energy);
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
    

    @Override
    public String toString() {
        return "Hokejista{" + "position=" + position + ", goals=" + goals + ", assists=" + assists + '}';
    }
    
    
    
}
