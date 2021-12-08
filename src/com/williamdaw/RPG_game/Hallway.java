package com.williamdaw.RPG_game;

import java.util.ArrayList;
import java.util.Collections;

public class Hallway extends Room {
    ArrayList<Room> adjacent_rooms = new ArrayList<Room>();
    public Hallway(int floor, PotentialMurderLocation[] potential_murder_locations) {
        super("Floor " + floor + " Hallway", floor, potential_murder_locations);
    }
    public void add_adjacent_room(ArrayList<Room> rooms) {
        this.adjacent_rooms.addAll(rooms);
    }
    public void add_adjacent_room(Room[] rooms) {
        Collections.addAll(this.adjacent_rooms, rooms);
    }
    public void add_adjacent_room(Room room) {
        adjacent_rooms.add(room);
    }

}
