/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 *
 * @author student
 */
public class Ship extends LineObject implements KeyListener, logicObject{
    private boolean thrust;
    private static final double FORCE = 1; //Síla způsobená motorem.
    private ArrayList<Point> thrustEffectPoints;
    private ArrayList<Point> thrustEffectPointsRotated;
    private static final double SPEED_LIMIT = 24;
    
    public Ship(int x,int y){
        this.thrust = false;
        this.location = new Point(x,y);
        this.rotation = 0;
        this.speedX = 0;
        this.speedY = 0;
        baseOffsets.add(new Point(0,-15));
        baseOffsets.add(new Point(15,15));
        baseOffsets.add(new Point(12,9));
        baseOffsets.add(new Point(-12,9));
        baseOffsets.add(new Point(-15,15));
        for(Point p : baseOffsets)
            actualOffsets.add((Point)p.clone());
        thrustEffectPoints = new ArrayList<>();
        thrustEffectPoints.add(new Point(9,9));
        thrustEffectPoints.add(new Point(-9,9));
        thrustEffectPoints.add(new Point(-9,18));
        thrustEffectPoints.add(new Point(9,18));
        thrustEffectPointsRotated = new ArrayList<>();
        for(Point p : thrustEffectPoints)
            thrustEffectPointsRotated.add((Point)p.clone());
    }

    @Override
    public void performLogic() {
        if(thrust){
            speedX += FORCE * Math.sin(rotation);
            speedY -= FORCE * Math.cos(rotation);
            double size = Math.sqrt(speedX*speedX+speedY*speedY); 
            if(size > SPEED_LIMIT){
                speedX *= SPEED_LIMIT / size;
                speedY *= SPEED_LIMIT / size;
            }       
        }
        super.performLogic();
    }
    
    @Override
    public void render(Graphics g){
        super.render(g);
        if(thrust){
            int x,y;
            int xArray[] = new int [4];
            int yArray[] = new int [4];
            for(int i = 0;i<thrustEffectPoints.size();i++){
                x = thrustEffectPoints.get(i).x;
                y = thrustEffectPoints.get(i).y;
                thrustEffectPointsRotated.get(i).x = (int) (x*Math.cos(rotation) - y*Math.sin(rotation)); 
                thrustEffectPointsRotated.get(i).y = (int) (y*Math.cos(rotation) + x*Math.sin(rotation));
            }
            for(int i = 0;i<thrustEffectPointsRotated.size();i++){
                xArray[i] = location.x+thrustEffectPointsRotated.get(i).x;
                yArray[i] = location.y+thrustEffectPointsRotated.get(i).y;
            }
            g.setColor(Color.RED);
            g.drawPolygon(new Polygon(xArray,yArray,4));
        }
            
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
