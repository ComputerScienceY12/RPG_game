package com.williamdaw.RPG_game;

import java.util.Map;
import java.util.Scanner;

//interface rooms {
//    public void library
//    // stairs
//    // roof top
// font 13

///

public class Main {

    public static String murder_room;
    String[][] inventory = new String[5][2];
    public static String[] user_name = new String[2];
    public static void main(String[] args) throws Exception {
//        String[] bedrooms = {"Guest", "Master", "Child"};
//        String[] other_rooms = {"Porch", "Living Room", "Kitchen", "Boot Room"};
//        String[] bathrooms = {"Downstairs Bathroom", "Upstairs Bathroom"};
        String[] people = new String[]{"Daniel","Martin","will","Mrs Fowler","Cam"};

        Map<String, Weapons[]> weapons = Map.of(
                "All", new Weapons[]{ new Weapons("Knife") },
                "All", new Weapons[]{ new Weapons("Bat") },
                "All", new Weapons[]{ new Weapons("Scissors")},
                "All", new Weapons[]{ new Weapons("Rope")},
                "Bathroom", new Weapons[]{ new Weapons("Drowing")},
                "Bathroom", new Weapons[]{ new Weapons("Toast Bath")},
                "All", new Weapons[]{ new Weapons("5.56 cadet training rife")}

        );
        Map<String, PotentialMurderLocation[]> bedrooms = Map.of(
                "Guest", new PotentialMurderLocation[]{ new PotentialMurderLocation("on bed") },
                "Master", new PotentialMurderLocation[]{ new PotentialMurderLocation("in wardrobe") },
                "Child", new PotentialMurderLocation[]{ new PotentialMurderLocation("on floor") }
        );
        Map<String, PotentialMurderLocation[]> other_rooms = Map.of(
                "Porch", new PotentialMurderLocation[]{ new PotentialMurderLocation( "on deck Chair") },
                "Living Room", new PotentialMurderLocation[]{ new PotentialMurderLocation("on sofa") },
                "Kitchen", new PotentialMurderLocation[]{ new PotentialMurderLocation( "in the sink") }
        );
        Map<String, PotentialMurderLocation[]> bathrooms = Map.of(
                "Downstairs Bathroom", new PotentialMurderLocation[]{ new PotentialMurderLocation( "in the bath") },
                "Upstairs Bathroom", new PotentialMurderLocation[]{ new PotentialMurderLocation (  "hello")}
        );

//        Map<String, Integer> test_map = new HashMap<String, Integer>() { { "Here", 1 }, { } };
//        test_map["here"] == 1
        House house = new House();
        for (String bedroom : bedrooms.keySet()) house.add_room(new Bedroom(bedroom, 1));
        for (String room : other_rooms.keySet()) house.add_room(new Room(room, 0));
        house.add_room(new Room[] { new Bathroom(null, 0), new Bathroom(house.get_room("Master Bedroom"), 1) });
        house.add_room(new Room[] { new Hallway(0), new Hallway(1) });
        System.out.println("enter username:");
        Scanner input = new Scanner(System.in);
        user_name = (input.nextLine()).split(" ");
        House x = house;
        house.set_murder_location();
        MurderLocation murder_location = house.get_murder_location();

        System.out.println(murder_location);



    }
}

