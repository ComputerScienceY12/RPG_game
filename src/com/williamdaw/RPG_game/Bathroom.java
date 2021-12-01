package com.williamdaw.RPG_game;

public class Bathroom extends Room {
    Room attached_to;
    public Bathroom(Object attached_to_room, int floor) {
      super("Floor " + floor + " Bathroom", floor);
        if (attached_to_room instanceof Room) this.attached_to = (Room) attached_to_room;
    }
}
