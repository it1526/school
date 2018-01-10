/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public abstract class LineObject implements Renderable, logicObject{
    protected Point location = new Point(); //Umístění STŘEDU objektu.
    protected double rotation = 0; // Rotace objektu; 0 je severní směr; tj. nahoru.
    protected Color color = Color.WHITE;
    protected ArrayList<Point> baseOffsets = new ArrayList<>(); //Množina bodů která definuje body objektu.
    //Všechno je vytvořeno z čar; mezi sousedícími body se vykreslí čáry. Např. B[0] > B[1], bude jedna čára. Nesmí se ale zapomenout že B[n] > B [0] je taky čára.
    //Body neobsahují absolutní souřadnice ale souřadnice relativní k bodu "location".
    //Na body bude poté aplikována transformace rotace dle hodnoty "rotation".
    protected ArrayList<Point> actualOffsets = new ArrayList<>();; //Stejné jako výš, ale po aplikaci rotace. Přepočítáva se každý snímek v logice objektu.
    protected double ROTATION_QUOTIENT = 10; //Modifikitátor ryhclosti otáčení.
    protected double speedX = 0;
    protected double speedY = 0;
    protected double rotationDirection = 0;
    
    @Override
    public void render(Graphics g){
        int x,y;
        for(int i = 0;i<actualOffsets.size();i++){
            x = baseOffsets.get(i).x;
            y = baseOffsets.get(i).y;
            actualOffsets.get(i).x = (int) (x*Math.cos(rotation) - y*Math.sin(rotation)); 
            actualOffsets.get(i).y = (int) (y*Math.cos(rotation) + x*Math.sin(rotation));
        }
        
        g.setColor(color);
         
        Point prev = actualOffsets.get(actualOffsets.size()-1);
        Point cur;
        
        for(int i = 0;i<actualOffsets.size();i++){
            cur = actualOffsets.get(i);
            
            g.drawLine(location.x+prev.x, location.y+prev.y, location.x+cur.x, location.y+cur.y);
            
            prev = cur;
        }
    }

    @Override
    public void performLogic() {
        rotation += rotationDirection/ROTATION_QUOTIENT;
        
        if(location.x < 0 || location.x > 800 || location.y < 0 || location.y > 600){ //Zobecnit později.
            location.x = 800 - location.x;
            location.y = 600 - location.y;
        }
        
        location.translate((int)speedX, (int)speedY);
    }
    
}
