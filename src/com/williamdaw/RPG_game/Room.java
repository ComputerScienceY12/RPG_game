package com.williamdaw.RPG_game;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Room {
    String name;
    int floor;
    ArrayList<Item> items = new ArrayList<>();
    ArrayList<PotentialMurderLocation> potential_murder_locations = new ArrayList<>();
    ArrayList<Room> adjacent_rooms = new ArrayList<>();

    public Room(String room_name) {
        this.name = room_name;
    }

    public Room(String room_name, int floor, Item[] items) {
        this.name = room_name;
        this.floor = floor;
        this.items.addAll(Arrays.asList(items));
    }

    public Room(String room_name, int floor, Item[] items, PotentialMurderLocation[] potential_murder_locations) {
        this.name = room_name;
        this.floor = floor;
        this.items.addAll(Arrays.asList(items));
        this.potential_murder_locations.addAll(Arrays.asList(potential_murder_locations));
    }

    public Room(String room_name, int floor, ArrayList<Item> items, ArrayList<PotentialMurderLocation> potential_murder_locations) {
        this.name = room_name;
        this.floor = floor;
        this.items.addAll(items);
        this.potential_murder_locations.addAll(potential_murder_locations);
    }

    public void add_item(Item item) {
        this.items.add(item);
    }

    public void add_items(ArrayList<Item> items) {
        this.items.addAll(items);
    }

    public String get_name() {
        return this.name;
    }

    public void add_adjacent_room(Room adjacent_room) {
        this.adjacent_rooms.add(adjacent_room);
    }

    public ArrayList<Room> get_adjacent_rooms() {
        return this.adjacent_rooms;
    }

    public ArrayList<PotentialMurderLocation> get_potential_murder_locations() {
        return this.potential_murder_locations;
    }
}
