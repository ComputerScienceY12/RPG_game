package com.williamdaw.RPG_game;

import java.util.*;

//interface rooms {
//    public void library
//    // stairs
//    // roof top
// font 13

///

class ground_floor {

}
class upper_floor{

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


    }
    class item{
        public static String pickup_location = "";
    }


}
public class Main {
    String[][] inventory = new String[5][2];
    public static String[] user_name = new String[2];
    public static void main(String[] args) throws Exception {
        String[] bedrooms = {"Guest", "Master", "Child"};
        String[] other_rooms = {"Porch", "Living Room", "Kitchen", "Boot Room"};
        String[] bathrooms = {"Downstairs Bathroom", "Upstairs Bathroom"};


//        Map<String, Integer> test_map = new HashMap<String, Integer>() { { "Here", 1 }, { } };
//        test_map["here"] == 1

        House house = new House();
        for (String bedroom : bedrooms) house.add_room(new bedroom(bedroom, 1));
        for (String room : other_rooms) house.add_room(new room(room, 0));
        house.add_room(new room[] { new Bathroom(null, 0), new Bathroom(house.get_room("Master Bedroom"), 1) });
        house.add_room(new room[] { new Hallway(0), new Hallway(1) });

        Scanner input = new Scanner(System.in);
        user_name = (input.nextLine()).split(" ");

    }
}

