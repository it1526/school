/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafika;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author student
 */
public class Grafika {
    private JFrame window;
    private JButton drawButton;
    private JLabel headLabel;
    private Platno platno;
    
    public Grafika(String title,int width,int height){
        window = new JFrame(title);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(width, height);
        /*Vytvoření nápisu okna*/
        headLabel = new JLabel(title);
        int style = Font.BOLD | Font.ITALIC;
        Font font = new Font("Century Gothic",style,20);
        headLabel.setFont(font);
        headLabel.setBackground(Color.CYAN);
        headLabel.setForeground(Color.LIGHT_GRAY);
        headLabel.setOpaque(true);
        headLabel.setHorizontalAlignment(JLabel.CENTER);
        
        drawButton = new JButton(title);
        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Čudlík čudlíkuje!");
                int x = (int) Math.floor(Math.random()*platno.getWidth());
                int y = (int) Math.floor(Math.random()*platno.getHeight());
                platno.setPoint(x, y);
                platno.repaint();
            }
        });
        platno = new Platno();
        
        Container pane = window.getContentPane();
        pane.add(headLabel,BorderLayout.PAGE_START);
        pane.add(drawButton,BorderLayout.PAGE_END);
        pane.add(platno,BorderLayout.CENTER);
        window.setVisible(true);
    }
    
    public static void main(String[] args) {
        new Grafika("Grafika v Javě",640,480);
    }
    
}
