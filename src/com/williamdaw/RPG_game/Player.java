package com.williamdaw.RPG_game;

import java.util.Scanner;

public class Player {
    private String [] inventory =new String[10];

    public static String[] user_name = new String[2];
    public static void adding_list (House house){


    }

    public static String[] getUser_name() {
        System.out.println("enter username:");
        Scanner input = new Scanner(System.in);
        user_name = input.nextLine().split(" ");
        return user_name;
    }



}
