/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafika;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JComponent;


class Bod {
    
    private Point point;
    private Color color;
    private int radius;
    public Bod(int x,int y){
        point = new Point(x,y);
        int red = (int)Math.floor(Math.random() *256);
        int green = (int)Math.floor(Math.random() *256);
        int blue = (int)Math.floor(Math.random() *256);
        color = new Color(red,green,blue);
        radius = (int)Math.floor(Math.random() *100)+50;
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

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    
}

public class Platno extends JComponent{
    public Platno(){
        
    }
    
    private Point p;
    ArrayList<Bod> points = new ArrayList<>();
    
    public void setPoint(int x,int y){
        p = new Point(x,y);
        points.add(new Bod(x,y));
    }
    
    public void drawPoints(Graphics g){
        for(Bod bod : points){
            g.setColor(bod.getColor());
            g.fillOval(bod.getPoint().x-(bod.getRadius()/2),bod.getPoint().y-(bod.getRadius()/2) ,bod.getRadius() ,bod.getRadius() );
        }
    }
    
    public void drawAxis(Graphics g,Dimension size,Point p){
        g.setColor(Color.GRAY);
        g.drawLine(0,p.y,size.width,p.y);
        g.drawLine(p.x,0,p.x,size.height);
    }
    
    @Override
    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        Dimension size = this.getSize();
        g.fillRect(0,0,size.width,size.height);
        drawAxis(g,size,p);
        drawPoints(g);
        
    }
}
