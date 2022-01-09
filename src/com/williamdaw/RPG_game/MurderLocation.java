package com.williamdaw.RPG_game;

import java.util.ArrayList;
import java.util.Random;

public class MurderLocation extends Room {
    private final PotentialMurderLocation sub_location;

    public MurderLocation(House house) {
        super("Murder Location");
        ArrayList<Room> rooms = house.get_rooms();
        Room value = rooms.get(new Random().nextInt(rooms.size()));
        while (value.potential_murder_locations.size() == 0) value = rooms.get(new Random().nextInt(rooms.size()));
        ArrayList<PotentialMurderLocation> sub_locations = value.get_potential_murder_locations();
        this.sub_location = sub_locations.get(new Random().nextInt(sub_locations.size()));
        this.floor = value.floor;
    }

    public PotentialMurderLocation get_sub_location() {
        return this.sub_location;
    }
}
