package com.williamdaw.RPG_game;

import java.util.*;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class Main {
    public Object[] load_config() {
        return new Object[]{};
    }
    public static void main(String[] args) throws Exception {
        Random rand = new Random();

        File inputFile = new File("config.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();

        // parse characters
        ArrayList<String> character_names = new ArrayList<>();
        NodeList character_node_list = ((Element) doc.getElementsByTagName("characters").item(0)).getElementsByTagName("character");
        for (int i = 0; i < character_node_list.getLength(); i++) character_names.add(((Element) character_node_list.item(i)).getAttribute("name"));

        // parse prefixes
        Map<String, String> item_prefixes = new HashMap<>();
        NodeList object_prefix_node_list = ((Element) doc.getElementsByTagName("object_prefixes").item(0)).getElementsByTagName("object_prefix");
        for (int i = 0; i < object_prefix_node_list.getLength(); i++) {
            Element object_prefix_node = (Element) object_prefix_node_list.item(i);
            item_prefixes.put(object_prefix_node.getAttribute("object"), object_prefix_node.getAttribute("prefix"));
        }

        // parse rooms & adjacent rooms
        NodeList room_node_list = ((Element) doc.getElementsByTagName("rooms").item(0)).getElementsByTagName("room");
        for (int i = 0; i < room_node_list.getLength(); i++) {
            Node room_node = room_node_list.item(i);
            character_names.add(((Element) room_node).getAttribute("name"));
        }










//            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//                Element eElement = (Element) nNode;
//                System.out.println("Student roll no : "
//                        + eElement.getAttribute("rollno"));
//                System.out.println("First Name : "
//                        + eElement
//                        .getElementsByTagName("firstname")
//                        .item(0)
//                        .getTextContent());
//                System.out.println("Last Name : "
//                        + eElement
//                        .getElementsByTagName("lastname")
//                        .item(0)
//                        .getTextContent());
//                System.out.println("Nick Name : "
//                        + eElement
//                        .getElementsByTagName("nickname")
//                        .item(0)
//                        .getTextContent());
//                System.out.println("Marks : "
//                        + eElement
//                        .getElementsByTagName("marks")
//                        .item(0)
//                        .getTextContent());
//            }

        String killer = character_names.get(rand.nextInt(character_names.size())); // TODO: CANNOT KILL HERE

        System.out.println(killer); // TODO: REMOVE ME

        // Create a map of all the rooms and items.
        Map<String, Item[]> bedrooms = Map.of(
                "Guest", new Item[]{new Item("Bed"), new Item("Next to the window")},
                "Master", new Item[]{new Item("Wardrobe"), new Item("Door")},
                "Child", new Item[]{new Item("Floor"), new Item("Bed")}
        );
        Map<String, Item[]> other_rooms = Map.of(
                "Porch", new Item[]{new Item("on deck Chair"), new Item("on the steps")},
                "Living Room", new Item[]{new Item("on sofa"), new Item("against the tv")},
                "Kitchen", new Item[]{new Item("in the sink"), new Item("in the cupboards")}
        );
        Map<String, Item[]> bathrooms = Map.of(
                "Downstairs Bathroom", new Item[]{new Item("in the bath"), new Item("on the sink")},
                "Upstairs Bathroom", new Item[]{new Item("in the shower"), new Item("next to the door")}
        );

        Map<String, Item[]> outside = Map.of(
                "Front Garden", new Item[]{new Item("in the flowerbed"), new Item("on the concrete")},
                "Back Garden", new Item[]{new Item("on the trampoline"), new Item("up against the fence")}
        );

        House house = new House();
//        for (String bedroom : bedrooms.keySet()) house.add_room(new Bedroom(bedroom, 1, bedrooms.get(bedroom)));
//        for (String gardens : outside.keySet()) house.add_room(new Room(gardens, 0, outside.get(gardens)));
//        for (String room : other_rooms.keySet()) house.add_room(new Room(room, 0, other_rooms.get(room)));
//        house.add_room(new Room[]{new Bathroom(null, 0, bathrooms.get("Downstairs Bathroom")), new Bathroom(house.get_room("Master Bedroom"), 1, bathrooms.get("Upstairs Bathroom"))});
        house.add_room(new Room[]{new Hallway(0), new Hallway(1)});



        house.set_murder_location();
        MurderLocation murder_location = house.get_murder_location();
        String room_murder_subsection = "";
        if (outside.containsKey(murder_location.name)) {
            room_murder_subsection = "outside";
        }
        if(bedrooms.containsKey(murder_location.name)) {
            room_murder_subsection = "bedrooms";
        }
        if(other_rooms.containsKey(murder_location.name)) {
            room_murder_subsection = "other_rooms";
        }
//        DansCode.main();
        System.out.println(room_murder_subsection + house.get_murder_location());
        Room current_room = house.get_room("Front garden");

        System.out.println("you murderer option are");
        for (String character : character_names) {
            System.out.print(character + " ,");
        }
        Scanner sc = new Scanner(System.in);
        boolean found = false;

        boolean win = false;
        System.out.println(" ");
        Player.getUser_name();
        // ask martin how to return the murder location
        while (!(win)) {

            Room[] adjacent_rooms = current_room.get_adjacent_rooms();
            System.out.println(current_room);
            System.out.println("You are in " + current_room + ", where would you like to go");

            for (Room s : adjacent_rooms) System.out.println(s.name);

            String user_choice = sc.nextLine();
            if (Objects.equals(user_choice, murder_location.name))
                System.out.println("Please enter the location followed by the murder");

//            String guess = sc.nextLine();
//            if (guess.contains(killer) && guess.contains()) break;
//            String User_choice_c = User_choice.substring(0, 1).toUpperCase() + User_choice.substring(1);

            if (house.has_room(user_choice)) current_room = house.get_room(user_choice);

            System.out.println("you win");

            /// find a way to call the function adjacent rooms in room
            // then the plan is to use one function to set everything then the other to print it and its in a permanent loop until the game is completed


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


