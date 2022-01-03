package com.williamdaw.RPG_game;

import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        Random rand = new Random();

        String[] characters = new String[]{"Daniel","Martin","will","Mrs Fowler","Cam"};
        String Murder = characters[rand.nextInt(characters.length)];rand.nextInt(characters.length);

        System.out.println(Murder);





        Map<String, PotentialMurderLocation[]> bedrooms = Map.of(
                "Guest", new PotentialMurderLocation[]{ new PotentialMurderLocation("on bed") },
                "Master", new PotentialMurderLocation[]{ new PotentialMurderLocation("in wardrobe") },
                "Child", new PotentialMurderLocation[]{ new PotentialMurderLocation("on floor") }
        );
        Map<String, PotentialMurderLocation[]> other_rooms = Map.of(
                "Porch", new PotentialMurderLocation[]{ new PotentialMurderLocation( "on deck Chair")},
                "Living Room", new PotentialMurderLocation[]{ new PotentialMurderLocation("on sofa") },
                "Kitchen", new PotentialMurderLocation[]{ new PotentialMurderLocation( "in the sink") }
        );
        Map<String, PotentialMurderLocation[]> bathrooms = Map.of(
                "Downstairs Bathroom", new PotentialMurderLocation[]{ new PotentialMurderLocation( "in the bath") },
                "Upstairs Bathroom", new PotentialMurderLocation[]{ new PotentialMurderLocation (  "hello")}
        );

        Map<String, PotentialMurderLocation[]> outside = Map.of(
                "Front Garden", new PotentialMurderLocation[]{ new PotentialMurderLocation( "run over") },
                "Back Garden", new PotentialMurderLocation[]{ new PotentialMurderLocation (  "death by trowl")}
        );

//        Map<String, Integer> test_map = new HashMap<String, Integer>() { { "Here", 1 }, { } };
//        test_map["here"] == 1
        House house = new House();
        for (String bedroom : bedrooms.keySet()) house.add_room(new Bedroom(bedroom, 1, bedrooms.get(bedroom)));
        for (String gardens : outside.keySet()) house.add_room(new Room(gardens, 1, outside.get(gardens)));
        for (String room : other_rooms.keySet()) house.add_room(new Room(room, 0, other_rooms.get(room)));
        house.add_room(new Room[] { new Bathroom(null, 0, bathrooms.get("Downstairs Bathroom")), new Bathroom(house.get_room("Master Bedroom"), 1, bathrooms.get("Upstairs Bathroom")) });
        house.add_room(new Room[] { new Hallway(0, new PotentialMurderLocation[] {}), new Hallway(1, new PotentialMurderLocation[] {}) });


        house.set_murder_location();



//        Map<String, Item[]> murder_weapons = Map.of(
//                "Knife", new Item[]{ new Item("stabbed") },
//                "bat", new Item[]{ new Item("beaten") },
//                "Poison", new Item[]{ new Item("poisoned") },
//                "Handgun", new Item[]{ new Item("shot") }
//        );

//        Map<String, Item[]> other_rooms_items = Map.of(
//                "Porch", new Item[]{ new Item("on bed") },
//                "Living Room", new Item[]{ new Item("in wardrobe") },
//                "Kitchen", new Item[]{ new Item("on floor") }
//        );
//        Map<String, Item[]> bedrooms_items = Map.of(
//                "Guest", new Item[]{ new Item("on bed") },
//                "Master", new Item[]{ new Item("key"),new Item("flashlight") },
//                "Child", new Item[]{ new Item("toy") }
//        );
//        Map<String, Item[]> bathrooms_items = Map.of(
//                "Downstairs Bathroom", new Item[]{ new Item("hairdrier") },
//                "Upstairs", new Item[]{ new Item("toaster") }
////                "Child", new Item[]{ new Item("on floor") }
//        );
//

//        Player.getUser_name();
//        DansCode.main();
/*
* TODO:
* WHO KILLED? RANDom generator start of main class
* WHERE PLAYER STARTS
* WHO PLAYER IS
* START INVESTIGATION
* ENSURE ALL OPTIONS WORK
* MAKE A WAY TO WIN
* TEST EVERYTHING
* TEST RANDOMNESS
* TEST EVERYTHING
* TEST ROBUSTNESS
* CHECK AGAINST REQUIREMENTS
*
* NEW BRANCH GITHUB
*
* ADD HOME SCREEN
* ENSURE ALL WORKS
* ADD GAME INTERFACE
* ENSURE ALL WORKS
* CHECK AGAINST REQUIREMENTS
* MAKE FINAL CHANGES
* TEST EVERYTHING
*
*
*

* */



    }
    public static void story_printer(){


    }
}

