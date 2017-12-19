/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids;

import java.awt.Graphics;

/**
 *
 * @author student
 */
public class Ship extends gameObject{
    private int x;
    private int y;
    
    private int vx;
    private int vy;
    
    public Ship(){
        x = 320;
        y = 240;
    }
    
    @Override
    public void colides(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void performLogic() {
        
    }

    @Override
    public void render(Graphics g) {
        g.drawLine(x+5, y, x+10, y+15);
        g.drawLine(x+5, y, x, y+15);
        g.drawLine(x, y+10, x+10, y+10);
    }
    
}
