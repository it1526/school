package people;

import java.awt.Color;

public class Human {
    //Vlastní výčtový datový typ
    public enum Sex{
        MALE,FEMALE,OTHER
    }
    
    //Atributy třídy
    private String name;
    private int age = 20;
    private int weight = 60;
    private double height = 1.75;
    private Sex sex;
    //Protected = přímý přístup potomkům
    protected Color eyes = Color.BLUE;
    
    //Metody třídy
    
    //Konstruktor třídy
    public Human(String jmeno,Sex sex){
        this.name = jmeno;
        this.sex = sex;
    }
    
    public Human(String jmeno,Sex sex,int age){
        this.name = jmeno;
        this.sex = sex;
        this.setAge(age);
    }
    
    @Override
    public String toString(){
       String output =  "My name's "+this.name+".\n"; 
       output += "I'm "+this.sex+".\n";
       output += "I measure "+this.height+" meters tall.\n";
       output += "I weigh "+this.weight+" kilograms.\n";
       output += "I'm "+this.age+" years old.\n";
       output += "My BMI is "+this.getBMI()+".";
       return output;
    }
    
    public double getBMI(){
        return this.weight/Math.pow(this.weight, 2);
    }
    
    //Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public Sex getSex() {
        return sex;
    }
    
    //Setters
    
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if(age >= 0 && age <= 130)
            this.age = age;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}