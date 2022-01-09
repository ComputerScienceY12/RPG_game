package com.williamdaw.RPG_game;

import java.util.ArrayList;
import java.util.Collections;

public class Hallway extends Room {
    ArrayList<Room> adjacent_rooms_hallway = new ArrayList<Room>();
//    public Hallway(int floor) {
//        String prefix = "";
//        if (floor == 0) {
//            prefix = "Upstairs ";
//        }else if (floor == 1) {
//            prefix = "Downstairs ";
//        }
//        super("Hallway x", floor);
//    }
    public Hallway(String name, int floor, ArrayList<Item> item, ArrayList<PotentialMurderLocation> potential_murder_locations) {
        super(name, floor, item, potential_murder_locations);
    }
    public void add_adjacent_room(ArrayList<Room> rooms) {
        this.adjacent_rooms_hallway.addAll(rooms);
    }
    public void add_adjacent_room(Room[] rooms) {
        Collections.addAll(this.adjacent_rooms_hallway, rooms);
    }
    public void add_adjacent_room(Room room) {
        adjacent_rooms_hallway.add(room);
    }


}
