package com.williamdaw.RPG_game;

import java.util.ArrayList;
import java.util.Arrays;

public class Room {
    String name;
    int floor;
    ArrayList<PotentialMurderLocation> potential_murder_locations = new ArrayList<PotentialMurderLocation>();
    public Room(String s, int floor) {
        System.out.println(s);
        System.out.println(floor);


    }

    public Room(String room_name, int floor, PotentialMurderLocation[] potential_murder_locations) {
        this.name = room_name;
        this.floor = floor;
        this.potential_murder_locations.addAll(Arrays.asList(potential_murder_locations));
    }
    public String get_name() {
        return this.name;
    }
}
