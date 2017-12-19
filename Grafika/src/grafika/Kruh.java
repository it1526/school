/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafika;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author student
 */
public class Kruh extends Tvar{
    private int radius;
    private Image image;
    public Kruh(int x,int y,boolean fill){
        super(x,y,fill);
        radius = (int)Math.floor(Math.random() *100)+50;
        try{
            image = ImageIO.read(this.getClass().getResource(""));
        }catch(IOException ex){}
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
        else if()
            g.drawOval(this.getPoint().x - this.getRadius(), 
                       this.getPoint().y - this.getRadius(), 
                       2*this.getRadius(), 2*this.getRadius());
        else
            g.drawI
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

    @Override
    public boolean detect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setActive() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
