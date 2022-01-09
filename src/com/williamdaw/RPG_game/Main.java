package com.williamdaw.RPG_game;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.*;

public class Main {

    public Object[] load_config() {
        return new Object[]{};
    }
    public static void main(String[] args) throws Exception {
//        SimpleAudioPlayer.main();

        Scanner scanner = new Scanner(System.in);

        Random rand = new Random();

        House house = new House();
        Player player = new Player(scanner);

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

        // parse rooms, potential murder locations and items
        NodeList room_node_list = ((Element) doc.getElementsByTagName("rooms").item(0)).getElementsByTagName("room");
        for (int i = 0; i < room_node_list.getLength(); i++) {
            Element room_element = (Element) room_node_list.item(i);
            String room_type = room_element.getAttribute("type");
            String room_name = room_element.getAttribute("name");
            int room_floor = Integer.parseInt(room_element.getAttribute("floor"));

            ArrayList<Item> room_items = new ArrayList<>();
            ArrayList<PotentialMurderLocation> potential_murder_locations = new ArrayList<>();
            NodeList room_item_node_list = room_element.getElementsByTagName("item");
            for (int j = 0; j < room_item_node_list.getLength(); j++) {
                Element item = (Element) room_item_node_list.item(j);
                String item_name = item.getAttribute("name");
                if (Integer.parseInt(item.getAttribute("murder_location")) == 1) potential_murder_locations.add(new PotentialMurderLocation(item_name));
                else room_items.add(new Item(item_name));
            }

            Room room;
            if (Objects.equals(room_type, "bedroom")) room = new Bedroom(room_name, room_floor, room_items, potential_murder_locations);
            else if (Objects.equals(room_type, "bathroom")) room = new Bathroom(room_name, room_floor, room_items, potential_murder_locations);
            else if (Objects.equals(room_type, "hallway")) room = new Hallway(room_name, room_floor, room_items, potential_murder_locations);
            else if (Objects.equals(room_type, "other_rooms")) room = new Room(room_name, room_floor, room_items, potential_murder_locations);
            else throw new Exception("XML file has unsupported room type.");
            house.add_room(room);
        }

        // parse adjacent rooms
        for (int i = 0; i < room_node_list.getLength(); i++) {
            Element room_element = (Element) room_node_list.item(i);
            String room_type = room_element.getAttribute("type");
            String room_name = room_element.getAttribute("name");
            String suffix = "";
            if (Objects.equals(room_type, "bedroom")) suffix = " bedroom";
            NodeList room_adjacent_room_node_list = room_element.getElementsByTagName("adjacent_room");
            for (int j = 0; j < room_adjacent_room_node_list.getLength(); j++) {
                if (!(house.has_room(room_name + suffix))) {
                    System.out.println(room_name + suffix);
                }
                if (!(house.has_room(((Element) room_adjacent_room_node_list.item(j)).getAttribute("name")))) {
                    System.out.println(room_name + suffix);
                    System.out.println(((Element) room_adjacent_room_node_list.item(j)).getAttribute("name"));
                }
                Room room = house.get_room(room_name + suffix);
                Room room1 = house.get_room(((Element) room_adjacent_room_node_list.item(j)).getAttribute("name"));
                room.add_adjacent_room(room1);
            }
        }

        // choose a killer
        String killer = character_names.get(rand.nextInt(character_names.size()));
        System.out.println(killer); // TODO: REMOVE ME

        // pick a murder location
        house.set_murder_location();
        MurderLocation murder_location = house.get_murder_location();
        PotentialMurderLocation murderLocation = murder_location.sub_location;

        Room current_room = house.get_room("Front garden");

        String potential_murderers_string = String.join(", ", character_names);
        System.out.println("Potential murderers: " + potential_murderers_string);
        boolean playing = true;
        while (playing) {
            System.out.println("You are in " + current_room.name + ", where would you like to search?");

            ArrayList<Room> adjacent_rooms = current_room.get_adjacent_rooms();
            ArrayList<String> adjacent_rooms_names = new ArrayList<>();
            ArrayList<String> current_room_potential_murder_locations_names = new ArrayList<>();
            ArrayList<PotentialMurderLocation> current_room_potential_murder_locations = current_room.get_potential_murder_locations();
            for (Room s : adjacent_rooms) adjacent_rooms_names.add(s.name);
            for (PotentialMurderLocation s : current_room_potential_murder_locations) current_room_potential_murder_locations_names.add(item_prefixes.get(s.value) + s.value);
            System.out.println(String.join(", ", adjacent_rooms_names));
            System.out.println(String.join(", ", current_room_potential_murder_locations_names));


            String user_choice = scanner.nextLine();
//            if (Objects.equals(user_choice, murder_location.name)) System.out.println("Please enter the location followed by the murder");

            if (house.has_room(user_choice)) current_room = house.get_room(user_choice);
            else if (current_room_potential_murder_locations_names.contains(user_choice)){
                System.out.println("You are checking if they were murdered here");
                if (!(house.is_sub_murder_location(user_choice))) System.out.println("This isn't the murder location");
                else {
                    System.out.println("this is the murder location");
                    System.out.println("You have 3 guesses. You must guess the murder out of " + murder_options);
                    for (int i = 0; i < 6; i++){
                        String murder_choice = scanner.nextLine();
                        if (murder_choice == killer){
                            System.out.println("You won it was " + killer +" in the" + current_room + item_prefixes.get(user_choice) + user_choice);
                            break;
                        }




                    }

                }
            }

//            String guess = sc.nextLine();
//            if (guess.contains(killer) && guess.contains()) break;
//            String User_choice_c = User_choice.substring(0, 1).toUpperCase() + User_choice.substring(1);

            /*
             * TODO:
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

             */
        }
    }
}


