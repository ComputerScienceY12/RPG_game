package com.williamdaw.RPG_game;

import java.util.ArrayList;
import java.util.Random;

public class MurderLocation extends Room {
    Room value;
    PotentialMurderLocation sub_location;

    public MurderLocation(House house,int floor) {
        super("Floor" + house, floor, other_rooms.get(room));
        ArrayList<Room> rooms = house.get_rooms();
        this.value = rooms.get(new Random().nextInt(rooms.size()));


//        this.value.get_potential_murder_locations()
//        this.sub_location =
    }
}
