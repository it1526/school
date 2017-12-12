/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafika;

import java.awt.Graphics;

/**
 *
 * @author student
 */
public class Kruh extends Tvar{
    private int radius;
    
    public Kruh(int x,int y,boolean fill){
        super(x,y,fill);
        radius = (int)Math.floor(Math.random() *100)+50;
    }
    
    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    @Override
    public void paint(Graphics g){
        g.setColor(this.getColor());
        if (this.isFill())
            g.fillOval(this.getPoint().x - this.getRadius(), 
                       this.getPoint().y - this.getRadius(), 
                       2*this.getRadius(), 2*this.getRadius());
        else
            g.drawOval(this.getPoint().x - this.getRadius(), 
                       this.getPoint().y - this.getRadius(), 
                       2*this.getRadius(), 2*this.getRadius());
    }
    
    @Override
    public void setSize(int delta){
        radius += delta;
    }
    
    @Override
    public void animate(Platno p){
        this.point.x += 1;
        if (this.point.x - radius >= p.getWidth())
            this.point.x = 0 - radius;
    }
}
