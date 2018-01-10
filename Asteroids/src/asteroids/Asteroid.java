/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids;

import java.awt.Point;
import java.util.Arrays;

/**
 *
 * @author Vikto
 */
public class Asteroid extends LineObject{
    
    public Asteroid(){
        this.location.x = (int) (Math.random() * 800);
        this.location.y = (int) (Math.random() * 400);
        double[] angles = new double[8];
        for(int i=0;i<8;i++){
            angles[i] = Math.random() * Math.PI * 2;
        }
        Arrays.sort(angles);
        for(int i=0;i<8;i++){
            baseOffsets.add(new Point(
            (int) ((Math.random() * (50 - 15) + 15) * Math.cos(angles[i])),
            (int) ((Math.random() * (50 - 15) + 15) * Math.sin(angles[i]))        
            ));
        }
        for(int i = 0;i<8;i++){
            actualOffsets.add(new Point());
        }
        do{
            speedX = Math.random() * 12;
            speedY = Math.random() * 12;
        }while(Math.sqrt(speedX*speedX+speedY*speedY) > 12);
    }
    
}
