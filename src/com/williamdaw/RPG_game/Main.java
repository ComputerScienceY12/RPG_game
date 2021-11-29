package com.williamdaw.RPG_game;

import java.util.Random;
import java.util.Scanner;

//interface rooms {
//    public void library
//    // stairs
//    // roof top
final class House{
    public static String[] locations = {"guest bedroom","master bedroom","porch","living room","kitchen","downstairs bathroom","childs bedroom","boot room"};
    public static String murder_location(){
        Random randomizer = new Random();
        String random = House.locations.get(randomizer.nextInt(House.locations.length));

    }
}

class syntax{
    public static void line_break(){
        System.out.println("---------------------------------------------------------------");
    }
    public static void error_message(){
        System.out.println("critical error");
    }
}
class porch{
    public static void beginning() {
        System.out.println("There is a murder in the house, on the loose its your job to find him");
        System.out.println("In you ruck");
    }
class study {
        public static

}


}
public class Main {
    String[][] inventory = new String[5][2];
    public static String[] user_name = new String[2];
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        user_name = (input.nextLine()).split(" ");


    }

}

