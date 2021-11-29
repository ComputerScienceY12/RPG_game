package com.williamdaw.RPG_game;

import java.util.Objects;

public class bedroom extends room {
    public bedroom(String type, int floor) {
        super(type + " Bedroom", floor);
        if (Objects.equals(type, "Master")){
            master();
        }

    }
    public static void master(){
        System.out.println();

    }
}
