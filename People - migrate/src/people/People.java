package people;

import java.util.ArrayList;
import java.util.List;

public class People {

    
    public static void main(String[] args) {
        Human student = new Human("Hugo",18,Human.Sex.MAN);
        Human studentka = new Human("Hilda",17,Human.Sex.WOMAN);
        student.setWeight(72);
        //System.out.println(student.toString());
        //System.out.println(student.getBMI());
        
        studentka.setWeight(55);
        studentka.setHeight(1.75f);
        //System.out.println(studentka.toString());
        
        Human sportovec = new Hokejista("Jarda", 20000);
        sportovec.setAge(45);
        sportovec.setHeight(189);
        sportovec.setWeight(102);
        ((Hokejista) sportovec).setGoals(10);
        //System.out.println(sportovec.toString());
        
        List<Human> lide = new ArrayList<Human>();
        lide.add(student);
        lide.add(studentka);
        lide.add(sportovec);
        
        for (Human clovek : lide){
            System.out.println(clovek.toString());
        }
    }
    
}