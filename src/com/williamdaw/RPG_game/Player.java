package com.williamdaw.RPG_game;

public class Player {
    private final String[] inventory = new String[10];
    private Room current_room;

    public void move_player(Room room) {
        this.current_room = room;
    }

    public Room get_current_room() {
        return this.current_room;
    }

}
