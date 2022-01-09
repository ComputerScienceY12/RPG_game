package com.williamdaw.RPG_game;

import java.util.ArrayList;

public class Bathroom extends Room {
    public Bathroom(String name, int floor, PotentialMurderLocation[] potential_murder_locations) {
        super(name, floor, potential_murder_locations);
    }
    public Bathroom(String name, int floor, ArrayList<Item> items, ArrayList<PotentialMurderLocation> potential_murder_locations) {
        super(name, floor, items, potential_murder_locations);
    }
}
