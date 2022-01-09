package com.williamdaw.RPG_game;

import java.util.Scanner;

public class Player {
    private String[] inventory = new String[10];
    private String name;
    private Room current_room;

    public void ask_name(Scanner scanner) {
        System.out.println("What is your name?");
        this.name = scanner.nextLine();
    }
    public void move_player(Room room) {

    }

    public String get_name() {
        return this.name;
    }

    public Player(Scanner scanner, House house) throws Exception {
        ask_name(scanner);
        if (house.has_room("Front garden")) move_player(house.get_room("Front garden"));
    }

}
