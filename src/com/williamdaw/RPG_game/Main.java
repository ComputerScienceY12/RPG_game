package com.williamdaw.RPG_game;

import javax.xml.stream.Location;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Random rand = new Random();

        String[] characters = new String[]{"Daniel", "Martin", "will", "Mrs Fowler", "Cam"};
        String killer = characters[rand.nextInt(characters.length)];
        rand.nextInt(characters.length);
        System.out.println(killer);


        Map<String, PotentialMurderLocation[]> bedrooms = Map.of(
                "Guest", new PotentialMurderLocation[]{new PotentialMurderLocation("on bed"),new PotentialMurderLocation("Next to the window")},
                "Master", new PotentialMurderLocation[]{new PotentialMurderLocation("in wardrobe"),new PotentialMurderLocation("Behind the door")},
                "Child", new PotentialMurderLocation[]{new PotentialMurderLocation("on floor"),new PotentialMurderLocation("Bed")}
        );
        Map<String, PotentialMurderLocation[]> other_rooms = Map.of(
                "Porch", new PotentialMurderLocation[]{new PotentialMurderLocation("on deck Chair"),new PotentialMurderLocation("on the steps")},
                "Living Room", new PotentialMurderLocation[]{new PotentialMurderLocation("on sofa"),new PotentialMurderLocation("against the tv")},
                "Kitchen", new PotentialMurderLocation[]{new PotentialMurderLocation("in the sink"),new PotentialMurderLocation("in the cupboards")}
        );
        Map<String, PotentialMurderLocation[]> bathrooms = Map.of(
                "Downstairs Bathroom", new PotentialMurderLocation[]{new PotentialMurderLocation("in the bath"),new PotentialMurderLocation("on the sink")},
                "Upstairs Bathroom", new PotentialMurderLocation[]{new PotentialMurderLocation("in the shower"),new PotentialMurderLocation("next to the door")}
        );

        Map<String, PotentialMurderLocation[]> outside = Map.of(
                "Front Garden", new PotentialMurderLocation[]{new PotentialMurderLocation("in the flowerbed"),new PotentialMurderLocation("on the concrete")},
                "Back Garden", new PotentialMurderLocation[]{new PotentialMurderLocation("on the trampolene"),new PotentialMurderLocation("up against the fence")}
        );

//        Map<String, Integer> test_map = new HashMap<String, Integer>() { { "Here", 1 }, { } };
//        test_map["here"] == 1
        House house = new House();
        for (String bedroom : bedrooms.keySet()) house.add_room(new Bedroom(bedroom, 1, bedrooms.get(bedroom)));
        for (String gardens : outside.keySet()) house.add_room(new Room(gardens, 0, outside.get(gardens)));
        for (String room : other_rooms.keySet()) house.add_room(new Room(room, 0, other_rooms.get(room)));
        house.add_room(new Room[]{new Bathroom(null, 0, bathrooms.get("Downstairs Bathroom")), new Bathroom(house.get_room("Master Bedroom"), 1, bathrooms.get("Upstairs Bathroom"))});
        house.add_room(new Room[]{new Hallway(0, new PotentialMurderLocation[]{}), new Hallway(1, new PotentialMurderLocation[]{})});


        house.set_murder_location();
        house.get_murder_location();
        String location = "Front Garden";
        String[] rooms_adjacent;
        System.out.println("you murderer option are");
        for (String character : characters) {
            System.out.print(character + " ,");
        }
        Scanner sc = new Scanner(System.in);
        boolean found = false;

        boolean win = false;
        System.out.println(" ");
        Player.getUser_name();
        while (win == false) {

            rooms_adjacent = Room.adjacent_room_finder(location);
            if (Objects.equals(location, "Hallway0")) location = "Downstairs Hallway";// makes the 0 and 1 dissaplear
            if (Objects.equals(location, "Hallway1")) location = "Upstairs Hallway";// makes the 0 and 1 dissaplear
            System.out.println("You are in " + location + "where would you like to go");
            for (int i = 0; i < rooms_adjacent.length; i++) System.out.println(rooms_adjacent[i]);
            String User_choice = sc.nextLine();
            for (String x : rooms_adjacent) {
                if (Objects.equals(x, User_choice)) {
                    found = true;
                    location = User_choice;
                    break;
                }

            }


            /// find a way to call the function addjastent rooms in room
            // then the plan is to use one function to set everything then the other to print it and its in a perminant loop until the game is completed


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
             * WHERE PLAYER STARTS in w while loop within main class
             * WHO PLAYER IS done with a class
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
    }
}

