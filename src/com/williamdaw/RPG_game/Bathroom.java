package com.williamdaw.RPG_game;

public class Bathroom extends Room {
    Room attached_to;
    public Bathroom(Object attached_to_room, int floor, PotentialMurderLocation[] potential_murder_locations) {
      super("Floor " + floor + " Bathroom", floor, potential_murder_locations);
        if (attached_to_room instanceof Room) this.attached_to = (Room) attached_to_room;
    }
}
