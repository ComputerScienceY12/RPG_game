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

    public String[] adjasent_rooms (String room_name) throws Exception{
        Map<String, String[]> adjastent_room = Map.of(

        "Master",new String[]{"Hallway1"},
        "Guest",new String[]{"Hallway1","Upstairs Bathroom"},
        "Child",new String[]{"Hallway1"},
        "Upstairs Bathroom",new String[]{"Hallway1"},
        "Hallway1",new String[]{"Hallway0","Child","Master","Guest"},
        "Porch",new String[]{"Hallway0","Front Garden"},
        "Front Garden",new String[]{"Porch"},
        "Living Room",new String[]{"Hallway0"},
        "Kitchen",new String[]{"Hallway0","Downstairs Bathroom","Back Garden"},
        "Back Garden",new String[]{"Hallway0"}
        );
        return adjastent_room.get(room_name);


    }
}
