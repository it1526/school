package people;

import java.awt.Color;


public class Human {
    //vlastní výčtový typ
    public enum Sex {
        MAN, WOMAN
    }
    //attributes
    private String name;
    private int age = 20;
    private float height = (float)1.80;
    private int weight = 70;
    private Sex sex = Sex.MAN;
    /*Modifikátor protected zabraňuje veřejnému
        přístupu k atributu, ale ten je přístupný
        pro všechny potomky třídy Human.*/
    protected Color eyes = Color.BLUE;
    
    //methods
    
    //Konstruktor
    public Human(String jmeno){
        this.name=jmeno;
    }
    
    public Human(String jmeno, int age, Sex sex){
        this.name=jmeno;
        this.setAge(age);
        this.setSex(sex);
    }
    
    //Getters and Setters
    public int getAge(){
        return this.age;
    }
    
    public void setAge(int age){
        if(age<120 && age>0){
            this.age=age;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
    
    
    
    public double getBMI(){
        return Math.round(this.getWeight()/Math.pow(this.getHeight(),2)*100.0)/100.0;
    }
    
    @Override
    public String toString(){
        String output = this.getName() + " [Human]";
        /*output += "I'm " + this.getSex() + "\n";
        output += "Age: " + this.getAge() + " years\n";
        output += "Height: " + this.getHeight() + " m\n";
        output += "Weight: " + this.getWeight() + " kg";*/
        return output;
    }
}