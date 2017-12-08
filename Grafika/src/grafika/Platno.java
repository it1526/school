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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JComponent;


class Bod {
    
    private Point point;
    private Color color;
    private int radius;
    private boolean fill;
    public Bod(int x,int y,boolean fill){
        point = new Point(x,y);
        int red = (int)Math.floor(Math.random() *256);
        int green = (int)Math.floor(Math.random() *256);
        int blue = (int)Math.floor(Math.random() *256);
        color = new Color(red,green,blue);
        radius = (int)Math.floor(Math.random() *100)+50;
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

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    
}

public class Platno extends JComponent implements MouseListener, MouseMotionListener,KeyListener{
    public Platno(){
        
    }
    
    private Point p;
    ArrayList<Bod> points = new ArrayList<>();
    
    public void setPoint(int x,int y,boolean fill){
        p = new Point(x,y);
        points.add(new Bod(x,y,fill));
    }
    
    public void init(){
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addKeyListener(this);
        this.setFocusable(true);
    }
    
    public void drawPoints(Graphics g){
        for(Bod bod : points){
            g.setColor(bod.getColor());
            if(bod.isFill())
                g.fillOval(bod.getPoint().x-(bod.getRadius()/2),bod.getPoint().y-(bod.getRadius()/2) ,bod.getRadius() ,bod.getRadius() );
            else
                g.drawOval(bod.getPoint().x-(bod.getRadius()/2),bod.getPoint().y-(bod.getRadius()/2) ,bod.getRadius() ,bod.getRadius() );
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

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        System.out.println(me.getButton());
        if (me.getButton() == 1) {
            this.setPoint(me.getX(),me.getY(),false);
        }
        if (me.getButton() == 3) {
            this.setPoint(me.getX(),me.getY(),true);
        }
        this.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseDragged(MouseEvent me) {
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        p.setLocation(me.getX(),me.getY());
        this.repaint();
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        System.out.println("LELELE");
        Bod bod = points.get(0);
        Point point = bod.getPoint();
        switch(ke.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                bod.setPoint(point.x-1, point.y);
                break;
            case KeyEvent.VK_RIGHT:
                bod.setPoint(point.x+1, point.y);
                break;
            case KeyEvent.VK_UP:
                bod.setPoint(point.x, point.y-1);
                break;
            case KeyEvent.VK_DOWN:
                bod.setPoint(point.x, point.y+1);
                break;
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
}
