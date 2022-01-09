package com.williamdaw.RPG_game;

import java.util.*;

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

    public Room(String room_name, int floor, ArrayList<Item> items, ArrayList<PotentialMurderLocation> potential_murder_locations) {
        this.name = room_name;
        this.floor = floor;
        this.items.addAll(items);
        this.potential_murder_locations.addAll(potential_murder_locations);
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

    public boolean has_adjacent_room(String room_name) {
        for (Room room : this.adjacent_rooms) if (Objects.equals(room.name, room_name)) return true;
        return false;
    }
}
