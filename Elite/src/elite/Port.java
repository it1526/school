/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elite;

/**
 *
 * @author student
 */
public class Port {
    public enum Type{
        Coriolis, Orbis, Ocellus
    }
    
    private String name;
    private double xCoordinate;
    private double yCoordinate;
    private double zCoordinate;
    private Type type;
    
    public Port(){
        name = "";
        xCoordinate = 0;
        yCoordinate = 0;
        type = Type.Coriolis;
    }
    
    @Override
    public String toString(){
        if (name == "")
            return "Unnamed "+type+" starport";
        else
            return name+" ("+type+")";
    }
    
    public double getzCoordinate() {
        return zCoordinate;
    }

    public void setzCoordinate(double zCoordinate) {
        this.zCoordinate = zCoordinate;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public double getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
