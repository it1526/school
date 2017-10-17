package people;

import java.util.ArrayList;
import java.util.List;

public class People {

    
    public static void main(String[] args) {
        Human student = new Human("Hugo",Human.Sex.MALE);
        Human studentka = new Human("Hilda",Human.Sex.FEMALE);
        //System.out.println(student.toString());
        //System.out.println(studentka.toString());
        student.setAge(21);
        //System.out.println(student.getAge());
        
        Human sportovec = new HockeyPlayer("Jarda",Human.Sex.MALE,20000);
        sportovec.setAge(45);
        sportovec.setWeight(102);
        sportovec.setHeight(1.89);
        ((HockeyPlayer) sportovec).setGoals(10);
        
        List<Human> lide = new ArrayList<Human>();
        lide.add(sportovec);
        lide.add(student);
        lide.add(studentka);
        for(Human clovek:lide)
            System.out.println(clovek.toString());
        
    }
    
}