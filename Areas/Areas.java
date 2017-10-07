import java.util.*;

public class Areas {

    Scanner sc = new Scanner(System.in, "UTF-8");
    enum Options {
        S, R, T, C, X;
    }

    float readNumber(String text) {
        float input = -1;
        do {
            try {
                System.out.print(text + ": ");
                input = sc.nextFloat();
                if (input < 0) {
                    System.out.println("Číslo nesmí být záporné!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Nesprávně zadané číslo!");
            }
            sc.nextLine();
        } while (input < 0);
        return input;
    }
    
    double getSquareArea(float a) {
        return Math.pow(a, 2);
    }
    
    double getRectangleArea(float a,float b){
        return a*b;
    }

    double getTriangleArea(float a,float h){
        return (a*h)/2;
    }

    double getDiscArea(float r){
        return Math.PI*Math.pow(r, 2);
    }

    void menu() {
        String optChar = "";
        float a;
        float b;
        do {
           System.out.println("Výpočet plochy geometrických útvarů");
           System.out.println("-----------------------------------");
           System.out.println("S = čtverec, R = obdélník, T = trojúhelník, "
                   + "C = kruh, X = konec");
           System.out.print("Zadej volbu: ");
           optChar = sc.nextLine();
           try {
              Options option = Options.valueOf(optChar.toUpperCase());
              switch (option) {
                  case S: System.out.println("Čtverec");
                          a = this.readNumber("Zadej stranu a");
                          System.out.printf("Plocha čtverce o straně %.2f je %.3f", 
                                  a, this.getSquareArea(a));
                          System.out.println();
                          break;
                  case R: System.out.println("Obdélník");
                        a = this.readNumber("Zadej stranu a");
                        b = this.readNumber("Zadej stranu b");
                        System.out.printf("Plocha obdelníku o stranách %.2f a %.2f je %.3f", 
                                        a, b, this.getRectangleArea(a,b));
                        System.out.println();
                        break;
                  case T: System.out.println("Trojúhelník");
                        a = this.readNumber("Zadej stranu trojúhelníka");
                        b = this.readNumber("Zadej výšku k této straně");
                        System.out.printf("Plocha trojúhelníka o straně %.2f a výšce k ní %.2f je %.3f", 
                                a, b, this.getRectangleArea(a,b));
                        System.out.println();
                        break;
                  case C: System.out.println("Kruh");
                        a = this.readNumber("Zadej stranu a");
                        System.out.printf("Plocha kruhu o poloměru %.2f je %.3f", 
                                a, this.getDiscArea(a));
                        System.out.println();
                        break;
              }
           } catch (Exception e) {
               System.out.println("Chybná volba");
           }   
        } while (!optChar.equalsIgnoreCase("X"));
    }

    public static void main(String[] args) {
        Areas areas = new Areas();
        //areas.readNumber("Zadej číslo");
        areas.menu();
    }

}