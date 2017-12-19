/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.Timer;

public class Platno extends JComponent implements ActionListener{
    
    ArrayList<Renderable> renderable;
    private Timer timer;
    
    public Platno() {
        this.renderable = new ArrayList();
        Renderable ship = new Ship();
        renderable.add(ship);
    }
    
    public void init() {
        this.setFocusable(true);
        timer = new Timer(50, (ActionListener) this);
        timer.start();
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, 640, 480);
        for(Renderable t : renderable){
            t.render(g);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        repaint();
    }
    
}
