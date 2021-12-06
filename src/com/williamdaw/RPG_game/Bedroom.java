package com.williamdaw.RPG_game;

import java.util.Objects;

public class Bedroom extends Room {
    public Bedroom(String type, int floor, PotentialMurderLocation[] potential_murder_locations) {
        super(type + " Bedroom", floor, potential_murder_locations);
        if (Objects.equals(type, "Master")) {
            System.out.println();
        }
    }
}
