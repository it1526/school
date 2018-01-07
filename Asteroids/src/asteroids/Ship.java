/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 *
 * @author student
 */
public class Ship extends LineObject implements KeyListener, logicObject{
    private double speedX;
    private double speedY;
    private double rotationDirection;
    private boolean thrust;
    private static final double ROTATION_QUOTIENT = 10; //Modifikitátor ryhclosti otáčení.
    private static final double FORCE = 1; //Síla způsobená motorem.
    
    public Ship(int x,int y){
        this.thrust = false;
        this.location = new Point(x,y);
        this.rotation = 0;
        this.speedX = 0;
        this.speedY = 0;
        this.baseOffsets = new ArrayList<>();
        baseOffsets.add(new Point(0,-15));
        baseOffsets.add(new Point(15,15));
        baseOffsets.add(new Point(12,9));
        baseOffsets.add(new Point(-12,9));
        baseOffsets.add(new Point(-15,15));
        actualOffsets = new ArrayList<>();
        for(Point p : baseOffsets)
            actualOffsets.add((Point)p.clone());
        
    }

    @Override
    public void performLogic() {
        rotation += rotationDirection/ROTATION_QUOTIENT;
        
        if(location.x < 0 || location.x > 800 || location.y < 0 || location.y > 600){ //Zobecnit později.
            location.x = 800 - location.x;
            location.y = 600 - location.y;
        }
        if(thrust){
            speedX += FORCE * Math.sin(rotation);
            speedY -= FORCE * Math.cos(rotation);
        }
        location.translate((int)speedX, (int)speedY);
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                rotationDirection = -1;
                break;
            case KeyEvent.VK_RIGHT:
                rotationDirection = 1;
                break;
            case KeyEvent.VK_UP:
                thrust = true;
                break;
            case KeyEvent.VK_R:
                location.setLocation(400,200);
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_RIGHT:
                rotationDirection = 0;
                break;
            case KeyEvent.VK_UP:
                thrust = false;
                break;
        }
    }
    
}
