package com.williamdaw.RPG_game;

import java.util.ArrayList;
import java.util.Objects;

public class Bedroom extends Room {
    public Bedroom(String type, int floor, ArrayList<Item> item, ArrayList<PotentialMurderLocation> potential_murder_locations) {
        super(type + " bedroom", floor, item, potential_murder_locations);
        if (Objects.equals(type, "Master")) {
            System.out.println();
        }
    }
}
