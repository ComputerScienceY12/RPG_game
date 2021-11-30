package com.williamdaw.RPG_game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;

public class House {
    private MurderLocation murder_location;
    private ArrayList<Room> rooms = new ArrayList<Room>();

    public House() {
        this.murder_location = new MurderLocation(this);
    }

    public void add_room(Room room) {
        this.rooms.add(room);
    }
    public void add_room(Room[] rooms) {
        Collections.addAll(this.rooms, rooms);
    }

    public boolean has_room(String room_name) {
        for (com.williamdaw.RPG_game.Room room : this.rooms) if (Objects.equals(room.get_name(), room_name)) return true;
        System.out.println("hello");
        return false;
    }
    public Room get_room(String room_name) throws Exception {
        for (com.williamdaw.RPG_game.Room room : this.rooms) if (Objects.equals(room.get_name(), room_name)) return room;
        throw new Exception("Room not found");
    }
}

