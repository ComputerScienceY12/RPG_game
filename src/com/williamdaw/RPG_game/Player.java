package com.williamdaw.RPG_game;

import java.util.Scanner;

public class Player {
    private String[] inventory = new String[10];
    private String name;

    public void ask_name(Scanner scanner) {
        System.out.println("What is your name?");
        this.name = scanner.nextLine();
    }

    public String get_name() {
        return this.name;
    }

    public Player(Scanner scanner) {
        ask_name(scanner);
    }

}
