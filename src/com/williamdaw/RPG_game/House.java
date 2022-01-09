package com.williamdaw.RPG_game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class House {
    private MurderLocation murder_location = null;
    private final ArrayList<Room> rooms = new ArrayList<>();
    public Room start_location;

    public void set_murder_location() {
        this.murder_location = new MurderLocation(this);
    }

    public void add_room(Room room) {
        this.rooms.add(room);
    }

    public boolean has_room(String room_name) {
        for (com.williamdaw.RPG_game.Room room : this.rooms) if (Objects.equals(room.get_name(), room_name)) return true;
        return false;
    }

    public Room get_room(String room_name) throws Exception {
        for (com.williamdaw.RPG_game.Room room : this.rooms) if (Objects.equals(room.get_name(), room_name)) return room;
        throw new Exception("Room not found");
    }

    public ArrayList<Room> get_rooms() {
        return this.rooms;
    }

    public MurderLocation get_murder_location() throws Exception {
        if (this.murder_location == null) throw new Exception("Murder location has not been set.");
        return this.murder_location;
    }
}

