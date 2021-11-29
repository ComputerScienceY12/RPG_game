package com.williamdaw.RPG_game;

import java.util.ArrayList;
import java.util.Collections;

public class Hallway extends room {
    ArrayList<room> adjacent_rooms = new ArrayList<room>();
    public Hallway(int floor) {
        super("Floor " + floor + " Hallway", floor);
    }
    public void add_adjacent_room(ArrayList<room> rooms) {
        this.adjacent_rooms.addAll(rooms);
    }
    public void add_adjacent_room(room[] rooms) {
        Collections.addAll(this.adjacent_rooms, rooms);
    }
    public void add_adjacent_room(room room) {
        adjacent_rooms.add(room);
    }

}
