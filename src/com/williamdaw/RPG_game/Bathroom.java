package com.williamdaw.RPG_game;

public class Bathroom extends room {
    room attached_to;
    public Bathroom(Object attached_to_room, int floor) {
        super("Floor " + floor + " Bathroom", floor);
        if (attached_to_room instanceof room) this.attached_to = (room) attached_to_room;
    }
}
