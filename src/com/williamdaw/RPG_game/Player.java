package com.williamdaw.RPG_game;

import java.util.Scanner;

public class Player {
    private String[] inventory = new String[10];
    private String name;
    private Room current_room;

    public void ask_name(Scanner scanner) {
//        System.out.println("What is your name?");
//        this.name = scanner.nextLine();
        this.name = "xyz";
    }

    public void move_player(Room room) {
        this.current_room = room;
    }

    public String get_name() {
        return this.name;
    }

    public Player(Scanner scanner) {
        ask_name(scanner);
    }

    public Room get_current_room() {
        return this.current_room;
    }

}
