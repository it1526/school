/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafika;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;


abstract class Tvar {
    
    protected Point point;
    protected Color color;
    protected boolean fill;
    public Tvar(int x,int y,boolean fill){
        point = new Point(x,y);
        int red = (int)Math.floor(Math.random() *256);
        int green = (int)Math.floor(Math.random() *256);
        int blue = (int)Math.floor(Math.random() *256);
        color = new Color(red,green,blue);
        this.fill = fill;
    }
    
    public void setPoint(int x,int y){
        point.setLocation(x, y);
    }
    
    public boolean isFill() {
        return fill;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }
    
    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    abstract public void setSize(int size);
    
    abstract public void paint(Graphics g);
    
    abstract public void animate(Platno p);
}
