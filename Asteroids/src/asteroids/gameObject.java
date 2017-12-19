/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids;

/**
 *
 * @author student
 */
abstract public class gameObject extends Renderable{
    abstract public void colides(int x,int y);
    abstract public void performLogic();
}
