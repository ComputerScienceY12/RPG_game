package com.williamdaw.RPG_game;

public class Room {
    String name;
    int floor;
    public Room() {

    }

    public Room(String room_name, int floor) {
        this.name = room_name;
        this.floor = floor;
    }
    public String get_name() {
        return this.name;
    }
}
