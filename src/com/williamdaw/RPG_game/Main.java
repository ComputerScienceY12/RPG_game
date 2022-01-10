package com.williamdaw.RPG_game;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public Object[] load_config() {
        return new Object[]{};
    }
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame();


        frame.setSize(1000, 500);
        frame.setLocation(50, 100);
        frame.setTitle(" ");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);













































        Scanner scanner = new Scanner(System.in);

        Random rand = new Random();

        House house = new House();
        Player player = new Player(scanner);
//        SimpleAudioPlayer.main(0);

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

        // parse game settings
        NodeList house_settings_node_list = ((Element) doc.getElementsByTagName("game_settings").item(0)).getElementsByTagName("setting");
        for (int i = 0; i < house_settings_node_list.getLength(); i++) {
            Element setting_element = (Element) house_settings_node_list.item(i);
            String setting_name = setting_element.getAttribute("name");
            String setting_value = setting_element.getAttribute("value");
            if (Objects.equals(setting_name, "start_location")) house.start_location = house.get_room(setting_value);
        }

        String current_color_scheme = "dark";

        // parse color schemes
        Map<String, Map<String, String>> color_schemes = new HashMap<>();
        NodeList color_schemes_node_list = ((Element) doc.getElementsByTagName("game_settings").item(0)).getElementsByTagName("color_scheme");
        for (int i = 0; i < color_schemes_node_list.getLength(); i++) {
            Element color_scheme_element = (Element) color_schemes_node_list.item(i);
            Map<String, String> map = new HashMap<>();
            map.put("display", color_scheme_element.getAttribute("display"));
            map.put("title_text_color", color_scheme_element.getAttribute("title_text_color"));
            map.put("main_text_color", color_scheme_element.getAttribute("main_text_color"));
            map.put("background_color", color_scheme_element.getAttribute("background_color"));
            map.put("button_background_color", color_scheme_element.getAttribute("button_background_color"));
            color_schemes.put(color_scheme_element.getAttribute("name"), map);
        }

        frame.getContentPane().setBackground(Color.decode(color_schemes.get(current_color_scheme).get("background_color")));

        Font labelFont = new Font("Verdana", Font.BOLD, 20);
        Font btnFont = new Font("Verdana", Font.PLAIN, 20);
        Font colourFont = new Font("Verdana", Font.BOLD, 12);
        Font exitFont = new Font("Verdana", Font.BOLD, 30);
        // parse user interface
        Map<String, Object> user_interface_items = new HashMap<>();
        NodeList user_interface_items_node_list = ((Element) doc.getElementsByTagName("user_interface_items").item(0)).getElementsByTagName("user_interface_item");
        for (int i = 0; i < user_interface_items_node_list.getLength(); i++) {
            Element user_interface_item = (Element) color_schemes_node_list.item(i);
            String user_interface_item_type = user_interface_item.getAttribute("type");
            String[] bounds_string = user_interface_item.getAttribute("display").split(",");
            Integer[] bounds = new Integer[bounds_string.length];
            for (int j = 0; j < bounds.length; j++) bounds[j] = Integer.parseInt(bounds_string[i]);

            if (Objects.equals(user_interface_item_type, "label")) {
                JLabel element;
                if (Objects.equals(user_interface_item.getAttribute("align"), "CENTER")) {
                    element = new JLabel(user_interface_item.getAttribute("display"), JLabel.CENTER);
                }else if (Objects.equals(user_interface_item.getAttribute("align"), "LEFT")) {
                    element = new JLabel(user_interface_item.getAttribute("display"), JLabel.LEFT);
                }else if (Objects.equals(user_interface_item.getAttribute("align"), "RIGHT")) {
                    element = new JLabel(user_interface_item.getAttribute("display"), JLabel.RIGHT);
                }else {
                    element = new JLabel(user_interface_item.getAttribute("display"));
                }

                element.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
                element.setForeground(Color.decode(color_schemes.get(current_color_scheme).get(user_interface_item.getAttribute("color"))));
                element.setFont(labelFont);

                if (Integer.parseInt(user_interface_item.getAttribute("default_visible")) == 1) element.setVisible(true); else element.setVisible(false);

                if (Objects.equals(user_interface_item.getAttribute("parent"), "main_frame")) frame.add(element);

                user_interface_items.put(user_interface_item.getAttribute("name"), element);
            }else {
                JButton element = new JButton(user_interface_item.getAttribute("value"));
                element.setLayout(null);
                element.setCursor(new Cursor(Cursor.HAND_CURSOR));
                element.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
                element.setForeground(Color.decode(color_schemes.get(current_color_scheme).get(user_interface_item.getAttribute("color"))));
                element.setForeground(Color.decode(color_schemes.get(current_color_scheme).get(user_interface_item.getAttribute("background_color"))));
                element.setFont(btnFont);

                if (Integer.parseInt(user_interface_item.getAttribute("default_visible")) == 1) element.setVisible(true); else element.setVisible(false);

                if (Objects.equals(user_interface_item.getAttribute("parent"), "main_frame")) frame.add(element);

                user_interface_items.put(user_interface_item.getAttribute("name"), element);
            }
        }

        // set player start location
        player.move_player(house.start_location);

        // choose a killer
        String killer = character_names.get(rand.nextInt(character_names.size()));

        // pick a murder location
        house.set_murder_location();
        MurderLocation murder_location = house.get_murder_location();

        String potential_murderers_string = String.join(", ", character_names);
        System.out.println("Potential murderers: " + potential_murderers_string);
        boolean playing = true;
        while (playing) {
            System.out.println("You are in " + player.get_current_room().name + ", where would you like to search?");
            ArrayList<String> murder_location_names =  new ArrayList<>();
            ArrayList<Room> adjacent_rooms = player.get_current_room().get_adjacent_rooms();
            ArrayList<String> adjacent_rooms_names = new ArrayList<>();
            ArrayList<String> current_room_potential_murder_locations_names = new ArrayList<>();
            ArrayList<PotentialMurderLocation> current_room_potential_murder_locations = player.get_current_room().get_potential_murder_locations();
            for (Room s : adjacent_rooms) adjacent_rooms_names.add(s.name);

            for (PotentialMurderLocation s : current_room_potential_murder_locations) current_room_potential_murder_locations_names.add(item_prefixes.get(s.get_value()) + s.get_value());
            for (PotentialMurderLocation s : current_room_potential_murder_locations) murder_location_names.add(s.get_value());

            System.out.println(String.join(", ", adjacent_rooms_names));
            System.out.println(String.join(", ", current_room_potential_murder_locations_names));

            String user_choice = scanner.nextLine();
            if (player.get_current_room().has_adjacent_room(user_choice)) player.move_player(house.get_room(user_choice));
            else if (murder_location_names.contains(user_choice)){
                System.out.println("You are checking if they were murdered in " + player.get_current_room().name);
               if (Objects.equals(murder_location.get_sub_location().get_value(), user_choice)) {
                    System.out.println("You have found the murder location, well done.");
                    System.out.println("You have 3 guesses. You must guess the murderer out of " + potential_murderers_string);
                    for (int i = 0; i < 2; i++){
                        String murder_choice = scanner.nextLine();
                        if (Objects.equals(murder_choice, killer)) {
                            System.out.println("You won, " + killer + " murdered in the " + player.get_current_room().get_name() + item_prefixes.get(user_choice) + user_choice);
                            playing = false;
                            break;
                        }
                    }
                }else System.out.println("This isn't the murder location");
            }

            /*
             * TODO:
             * ADD HOME SCREEN
             * ENSURE ALL WORKS
             * ADD GAME INTERFACE
             * ENSURE ALL WORKS
             * CHECK AGAINST REQUIREMENTS
             * MAKE FINAL CHANGES
             * TEST EVERYTHING
             */
        }
        System.out.println("With many thanks to:");
        System.out.println("Martin Najemi - Did everything");
        System.out.println("William Daw - Did loads");
        System.out.println("Daniel Judd - Did absolutely fuck all");
        System.out.println("Everyone else, you did less than juddy");
        SimpleAudioPlayer.main(1);
    }
}


