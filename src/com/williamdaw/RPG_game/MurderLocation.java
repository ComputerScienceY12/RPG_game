package com.williamdaw.RPG_game;

import java.util.ArrayList;
import java.util.Random;

public class MurderLocation extends Room {
    Room value;
    public MurderLocation(House house) {
        ArrayList<Room> rooms = house.get_rooms();
        this.value = rooms.get(new Random().nextInt(rooms.size()));
    }
}
