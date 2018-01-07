/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.Timer;

public class Platno extends JComponent implements ActionListener{
    
    ArrayList<Renderable> renderable;
    ArrayList<logicObject> logic;
    private Timer timer;
    private Ship ship;
    
    public Platno() {
        this.renderable = new ArrayList<>();
        this.logic = new ArrayList<>();
        this.ship = new Ship(400,300);
        renderable.add(ship);
        logic.add(ship);
        this.setFocusable(true);
        this.addKeyListener(ship);
        System.out.println("Laliho");
    }
    
    public void init() {
        timer = new Timer(50, (ActionListener) this);
        timer.start();
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, 800, 600);
        for (Renderable t : renderable) {
            t.render(g);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        for(logicObject o : logic)
            o.performLogic();
        repaint();
    }
    
}
