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
public class HockeyPlayer extends Sportsman{
    public enum Hand{
        RIGHT,LEFT,AMBIDEXTROUS
    };
    
    private int goals = 0;
    private int asissts = 0;
    private Hand hand;
    
    public HockeyPlayer(String jmeno, Sex sex, int energy) {
        super(jmeno, sex, energy);
    }

    public int getGoals() {
        return goals;
    }

    public int getAsissts() {
        return asissts;
    }

    public Hand getHand() {
        return hand;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public void setAsissts(int asissts) {
        this.asissts = asissts;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }
    
}
