/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elite;

public class Ship {
    public enum ShipType{
        Sidewinder, Cobra, Cutter, Python, Orca
    }
    
    private String name;
    private String comment;
    private Port homePort;
    private ShipType shipType;
    
    public Ship(){
        name = "";
        comment = "";
        homePort = null;
        shipType = ShipType.Sidewinder;
    }
    
    @Override
    public String toString(){
        if(name == "")
            return "Unnamed "+shipType;
        else
            return name+" ("+shipType+")";
    }
    
    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }

    public Port getHomePort() {
        return homePort;
    }

    public ShipType getShipType() {
        return shipType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setHomePort(Port homePort) {
        this.homePort = homePort;
    }

    public void setShipType(ShipType shipType) {
        this.shipType = shipType;
    }
    
    
}
