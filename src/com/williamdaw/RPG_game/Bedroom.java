package com.williamdaw.RPG_game;

import java.util.Objects;

public class Bedroom extends Room {
    public Bedroom(String type, int floor) {
        super(type + " Bedroom", floor);
        if (Objects.equals(type, "Master")){
            master();
        }

    }
    public static void master(){
        System.out.println();

    }
}
