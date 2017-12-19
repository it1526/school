package asteroids;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;

public class Asteroids{
    private JFrame window;
    private Platno platno;
    
    final int width = 640;
    final int height = 480;
    
    public Asteroids(){
        window = new JFrame("Asteroids");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(width, height);
        platno = new Platno();
        platno.init();
        Container pane = window.getContentPane();
        pane.add(platno,BorderLayout.CENTER);
        window.setVisible(true);
    }
    
    public static void main(String[] args) {
    }

}