package people;

public class Sportsman extends Human{
    
    private int energy = 15000;
    private double steroids = 0;
    
    public Sportsman(){
        
    }
    public Sportsman(String jmeno, Sex sex) {
        super(jmeno, sex);
    }
    
    public Sportsman(String jmeno, Sex sex,int energy) {
        super(jmeno, sex);
        this.energy = energy;
    }
    
    public Sportsman(String jmeno, Sex sex,double steroids){
        super(jmeno, sex);
        this.steroids = steroids;
    }
    
    public Sportsman(String jmeno, Sex sex,int energy,double steroids){
        super(jmeno, sex);
        this.energy = energy;
        this.steroids = steroids;
    }

    public int getEnergy() {
        return energy;
    }

    public double getSteroids() {
        return steroids;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void setSteroids(double steroids) {
        this.steroids = steroids;
    }

    @Override
    public String toString() {
        return super.toString() + " [Sportsman]";
    }
    
    
}
