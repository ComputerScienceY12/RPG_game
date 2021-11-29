package com.williamdaw.RPG_game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;

public class House {
    private ArrayList<room> rooms = new ArrayList<room>();

    public void add_room(room room) {
        this.rooms.add(room);
    }
    public void add_room(room[] rooms) {
        Collections.addAll(this.rooms, rooms);
    }

    public void murder_location() {
        Random randomizer = new Random();
//        String random = House.locations.get(randomizer.nextInt(House.locations.length));

    }
    public boolean has_room(String room_name) {
        for (com.williamdaw.RPG_game.room room : this.rooms) if (Objects.equals(room.get_name(), room_name)) return true;
        return false;
    }
    public room get_room(String room_name) throws Exception {
        for (com.williamdaw.RPG_game.room room : this.rooms) if (Objects.equals(room.get_name(), room_name)) return room;
        throw new Exception("Room not found");
    }
}
