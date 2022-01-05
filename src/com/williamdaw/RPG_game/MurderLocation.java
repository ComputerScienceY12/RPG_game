package com.williamdaw.RPG_game;

import java.util.ArrayList;
import java.util.Random;

public class MurderLocation extends Room {
    Room value;
    PotentialMurderLocation sub_location;

    public MurderLocation(House house) {
        super("Murder Location");
        ArrayList<Room> rooms = house.get_rooms();
        this.value = rooms.get(new Random().nextInt(rooms.size()));
        this.floor = this.value.floor;


    }
}
