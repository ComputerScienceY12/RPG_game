package com.williamdaw.RPG_game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Room {
    String name;
    int floor;
    ArrayList<Object> items = new ArrayList<>();
    ArrayList<PotentialMurderLocation> potential_murder_locations = new ArrayList<>();
    ArrayList<Room> adjacent_rooms = new ArrayList<>();

    public Room(String room_name) {
        this.name = room_name;
    }

    public Room(String room_name, int floor) {
        this.name = room_name;
        this.floor = floor;
    }

    public Room(String room_name, int floor, PotentialMurderLocation[] potential_murder_locations) {
        this.name = room_name;
        this.floor = floor;
        this.potential_murder_locations.addAll(Arrays.asList(potential_murder_locations));
    }

    public void add_item(Object item) {
        this.items.add(item);
    }

    public void add_items(ArrayList<Object> items) {
        this.items.addAll(items);
    }

    public String get_name() {
        return this.name;
    }

    public Room[] get_adjacent_rooms() {
        return (Room[]) this.adjacent_rooms.toArray();
    }
}
