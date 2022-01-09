package com.williamdaw.RPG_game;

import java.util.ArrayList;

public class Hallway extends Room {
    public Hallway(String name, int floor, ArrayList<Item> item, ArrayList<PotentialMurderLocation> potential_murder_locations) {
        super(name, floor, item, potential_murder_locations);
    }
}
