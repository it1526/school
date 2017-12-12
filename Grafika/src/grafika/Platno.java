/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafika;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.Timer;

public class Platno extends JComponent 
    implements MouseListener, 
               MouseMotionListener, 
               KeyListener,
               ActionListener
    {
    
    private Point p = new Point(100,100);
    ArrayList<Tvar> points;
    private Timer timer;
    
    public Platno() {
        this.points = new ArrayList();
    }
    
    public void init() {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addKeyListener(this);
        this.setFocusable(true);
        timer = new Timer(50, (ActionListener) this);
        timer.start();
    }
    
    public void setPoint(int x, int y, boolean fill) {
        p = new Point(x,y);
        this.points.add(new Kruh(p.x, p.y, fill));
    }
    
    public void drawPoints(Graphics g) {
        for (Tvar b: this.points) {
            b.paint(g);
        }
    }
    
    public void drawAxis(Graphics g, Dimension size) {
        Graphics2D g2d = (Graphics2D) g;
        float tloustka = 1f;
        float miterLimit = 20f;
        float[] dashPattern = {5f};
        float dashPhase = 8f;
        BasicStroke stroke = new BasicStroke(tloustka, 
                BasicStroke.CAP_BUTT, 
                BasicStroke.JOIN_MITER,
                miterLimit, dashPattern, dashPhase);
        g2d.setStroke(stroke);
        
        g2d.setColor(Color.gray);
        g2d.drawLine(0, p.y, size.width, p.y);        
        g2d.drawLine(p.x, 0, p.x, size.height);        
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.white);
        Dimension size = this.getSize();
        g.fillRect(0, 0, size.width, size.height);
        drawAxis(g, size);
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
        System.out.println("x" + me.getX());
        System.out.println("y" + me.getY());
        //this.setPoint(me.getX(),me.getY(),true);
        this.repaint();
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        Tvar b = this.points.get(this.points.size()-1);
        switch (ke.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                System.out.println("vlevo");
                p.x--;                 
                b.getPoint().x--;
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("vpravo");
                p.x++;
                b.getPoint().x++;
                break;
            case KeyEvent.VK_UP:
                System.out.println("nahoru");
                p.y--;
                b.getPoint().y--;
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("dolu");
                p.y++;
                b.getPoint().y++;
                break;                
            case KeyEvent.VK_INSERT:
                System.out.println("vlozit");
                this.setPoint(p.x, p.y, true);
                break;                
            case KeyEvent.VK_PAGE_DOWN:
                System.out.println("hubni");
                if (b.getRadius() > 3) b.setRadius(b.getRadius()-1);
                break;                
            case KeyEvent.VK_PAGE_UP:
                System.out.println("tloustni");
                if (b.getRadius() < 100) b.setRadius(b.getRadius()+1);
                break;                
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        for(Tvar t: this.points){
            t.animate(this);
        }
        repaint();
    }

}
