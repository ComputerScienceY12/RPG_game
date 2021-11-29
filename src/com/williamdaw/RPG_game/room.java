package com.williamdaw.RPG_game;

public class room {
    String name;
    int floor;
    public room() {

    }

    public room(String room_name, int floor) {
        this.name = room_name;
        this.floor = floor;
    }
    public String get_name() {
        return this.name;
    }
}
