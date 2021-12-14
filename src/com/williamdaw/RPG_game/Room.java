package com.williamdaw.RPG_game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Room extends House{
    String name;
    int floor;
    ArrayList<Object> items = new ArrayList<>();
    ArrayList<PotentialMurderLocation> potential_murder_locations = new ArrayList<PotentialMurderLocation>();



    public Room(String room_name) {
        this.name = room_name;
    }

    public Room(String room_name, int floor, PotentialMurderLocation[] potential_murder_locations) {
        this.name = room_name;
        this.floor = floor;
        this.potential_murder_locations.addAll(Arrays.asList(potential_murder_locations));
    }

    public void add_item(Object item) {
        this.items.add(item);
    }

    public void add_items(ArrayList<Object> items) {
        this.items.addAll(items);
    }

    public String get_name() {
        return this.name;
    }

    public void adjasent_rooms () {
        Object[][] Guest = {{"Hallway1",1}};
        Object[][] Master = {{"Hallway1",1},{"Upstairs Bathroom ",1}};
        Object[][] child = {{"Hallway1",1}};
        Object[][] Upstairs_Bathroom = {{"Hallway1",1}};
        Object[][] Hallway1 = {{"Hallway0",0},{"Child",1},{"Master",1},{"Guest",1}};
        Object[][] Hallway0 = {{"Hallway",1},{"Kitchen",0},{"Porch",0},{"Living_Room",0}};
        Object[][] Porch = {{"Hallway0",0},{"Front_Garden",0}};
        Object[][] Front_Garden = {{"Porch",0}};
        Object[][] Living_Room = {{"Hallway0",0}};
        Object[][] Kitchen = {{"Hallway0",0},{"Downstairs Bathroom",0},{"Back Garden",0}};
        Object[][] Downstairs_Bathroom = {{"Hallway0",0}};
        Object[][] Back_Garden = {{"Hallway0",0}};



    }
}
